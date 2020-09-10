package com.dhc.钉钉api操作.net;

import okhttp3.*;
import org.springframework.core.io.ClassPathResource;

import javax.net.ssl.*;
import java.io.*;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpHelper {
    public static final MediaType APPLICATION_FORM_URLENCODED = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType APPLICATION_XML = MediaType.parse("application/xml; charset=utf-8");

    private static final String UTF_8 = "UTF-8";
    private static final String URL_SEPARATOR = "?";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String NAME_VALUE_SEPARATOR = "=";

    // 连接超时10秒
    private static final int CONNECT_TIMEOUT = 10;
    // 读取数据超时10秒
    private static final int READ_TIMEOUT = 10;

    private static OkHttpClient mClient;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(200);
        dispatcher.setMaxRequests(200);
        builder.dispatcher(dispatcher);
        mClient = builder.build();
    }

    public static OkHttpClient getClient() {
        return mClient;
    }

    public static OkHttpClient getTrustSSLClient(String certPath, char[] password, String keyStoreType) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        try {
//            X509TrustManager trustManager = getTrustManager(certPath, password, keyStoreType);
//            builder.sslSocketFactory(getSSLSocketFactory(trustManager, false), trustManager);
            builder.sslSocketFactory(getSSLSocketFactory(certPath, password, keyStoreType));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    public static OkHttpClient getTrustAllClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        try {
            TrustAllManager trustAllManager = new TrustAllManager();
            builder.sslSocketFactory(getSSLSocketFactory(trustAllManager, true), trustAllManager);
            builder.hostnameVerifier(new TrustAllHostnameVerifier());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    public static class TrustAllManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    private static SSLSocketFactory getSSLSocketFactory(String certPath, char[] password, String keyStoreType) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        InputStream certInput = new ClassPathResource(certPath).getInputStream();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(certInput, password);
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);
        sslContext.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());
        return sslContext.getSocketFactory();
    }

    private static SSLSocketFactory getSSLSocketFactory(TrustManager trustManager, boolean trustAll) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{trustManager}, trustAll ? new SecureRandom() : null);
        return sslContext.getSocketFactory();
    }

    // 好像这个方法不是很行
    private static X509TrustManager getTrustManager(String certPath, char[] password, String keyStoreType) throws Exception {
        InputStream certificate = new FileInputStream(new File(certPath));
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        // 通过证书工厂得到自签证书对象集合
        Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(certificate);
        if (certificates.isEmpty()) {
            throw new IllegalArgumentException("expected non-empty set of trusted certificates");
        }
        // 为证书设置一个keyStore
        KeyStore keyStore = KeyStore.getInstance(keyStoreType == null ? KeyStore.getDefaultType() : keyStoreType);
        keyStore.load(null, password);
        int index = 0;
        // 将证书放入keystore中
        for (Certificate cert : certificates) {
            String certificateAlias = Integer.toString(index++);
            keyStore.setCertificateEntry(certificateAlias, cert);
        }
        // 使用包含自签证书信息的keyStore去构建一个X509TrustManager
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        }
        return (X509TrustManager) trustManagers[0];
    }


    /**
     * 同步请求
     */
    public static Response execute(Request request) throws IOException {
        return mClient.newCall(request).execute();
    }

    /**
     * 异步请求
     */
    public static void enqueue(Request request, Callback responseCallback) {

        mClient.newCall(request).enqueue(responseCallback);
    }

    public static String getUrlAppendParam(String url, Map<String, String> params) {
        return url + URL_SEPARATOR + formatParams(params);
    }

    public static String getUrlAppendParam(String url, Map<String, String> params, String encoding) {
        return url + URL_SEPARATOR + formatParams(params, encoding);
    }

    public static String formatParams(Map<String, String> params) {
        return formatParams(params, UTF_8);
    }

    public static String formatParams(Map<String, String> params, String encoding) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String encodeKey = encode(entry.getKey(), encoding);
            String encodedValue = entry.getValue() != null ? encode(entry.getValue(), encoding) : "";
            if (result.length() > 0) {
                result.append(PARAMETER_SEPARATOR);
            }
            result.append(encodeKey);
            result.append(NAME_VALUE_SEPARATOR);
            result.append(encodedValue);
        }
        return result.toString();
    }

    private static String encode(String content, String encoding) {
        try {
            return URLEncoder.encode(content, encoding != null ? encoding : UTF_8);
        } catch (UnsupportedEncodingException problem) {
            throw new IllegalArgumentException(problem);
        }
    }
}
