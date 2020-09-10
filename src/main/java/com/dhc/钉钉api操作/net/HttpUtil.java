package com.dhc.钉钉api操作.net;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);
    /**
     * GET同步请求
     * @param url   请求url
     * @return      字符串
     */
    public static String doGet(String url) {
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String doGetWithHeader(String url, Map<String, String> headerMap) {
        Request.Builder url1 = new Request.Builder().url(url);
        if (headerMap != null && headerMap.size() > 0) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                if (entry.getValue() != null) {
                    url1.addHeader(entry.getKey(), entry.getValue());
                }
            }
        }
        Request request = url1.build();
        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * GET同步请求
     * @param domain    请求域名
     * @param params    url携带的参数
     * @return          字符串
     */
    public static String doGet(String domain , Map<String, String> params) {
        Request request = new Request.Builder().url(OkHttpHelper.getUrlAppendParam(domain, params)).build();
        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * GET同步请求
     * @param url       请求url
     * @param targetClz 返回目标类的类型
     * @return          返回目标类的对象
     */
    public static <T> T doGet(String url, Class<T> targetClz) {
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                String result = response.body().string();
                if (result != null && result.length() > 0) {
                    return JSON.parseObject(result, targetClz);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * GET同步方法
     * @param domain    请求域名
     * @param params    url携带的参数
     * @param targetClz 返回目标类的类型
     * @return          返回目标类的对象
     */
    public static <T> T doGet(String domain, Map<String, String> params, Class<T> targetClz) {
        Request request = new Request.Builder().url(OkHttpHelper.getUrlAppendParam(domain, params)).build();
        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                String result = response.body().string();
                if (result != null && result.length() > 0) {
                    return JSON.parseObject(result, targetClz);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * GET异步请求
     * @param url       请求url
     * @param callback  回调，成功回调目标类对象
     * @param targetClz 返回目标类的类型
     */
    public static <T> void doGetAsync(String url, HttpCallback<T> callback, Class<T> targetClz) {
        Request request = new Request.Builder().url(url).build();
        OkHttpHelper.enqueue(request, new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                if (callback != null) {
                    callback.onFail(e.toString());
                }
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.body() != null) {
                    String result = response.body().string();
                    if (result != null && result.length() > 0) {
                        if (callback != null) {
                            callback.onSuccess(JSON.parseObject(result, targetClz));
                        }
                    }
                }
                if (callback != null) {
                    callback.onFail("return null");
                }
            }
        });
    }

    /**
     * POST同步请求(表单)
     * @param url   请求url
     * @param map   请求参数
     * @return      返回字符串
     */
    public static String postWithForm(String url, Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                builder.add(key, value);
            }
        }

        Request request = new Request.Builder().url(url).post(builder.build()).build();
        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POST同步请求(表单)
     * @param url   请求url
     * @param map   请求参数
     * @return      返回字符串
     */
    public static String postWithFormHead(String url, Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder().addEncoded("application/x-www-form-urlencoded", "UTF-8");
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                builder.add(key, value);
            }
        }

        Request request = new Request.Builder().url(url).post(builder.build()).build();
        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POST同步请求(表单+文件)
     * @param url       请求url
     * @param map       请求参数
     * @param fileMap   请求文件
     * @return          返回字符串
     */
    public static String postWithFormFile(String url, Map<String, String> map, Map<String, File> fileMap) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                builder.addFormDataPart(key, value);
            }
        }
        if (null != fileMap) {
            for (Map.Entry<String, File> entry : fileMap.entrySet()) {
                String key = entry.getKey();
                File value = entry.getValue();
                builder.addFormDataPart(key, value.getName(), RequestBody.create(MediaType.parse("image/png"), value));
            }
        }

        Request request = new Request.Builder().url(url).post(builder.build()).build();
        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POST同步请求(JSON)
     * @param url           请求url
     * @param jsonParams    请求json参数
     * @return
     */
    public static String postWithJson(String url, String jsonParams) {
        RequestBody body = RequestBody.create(OkHttpHelper.APPLICATION_JSON, jsonParams);
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            log.error("Exception:", e);
        }
        return null;
    }

    /**
     * POST同步请求(JSON)
     * @param url           请求url
     * @param jsonParams    请求json参数
     * @return
     */
    public static String postWithJsonForResp(String url, String jsonParams) {
        RequestBody body = RequestBody.create(OkHttpHelper.APPLICATION_JSON, jsonParams);
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = OkHttpHelper.execute(request);
            JSONObject respJson = new JSONObject();
            if (response != null) {
                respJson.put("respCode", response.code());
                if (response.body() != null) {
                    respJson.put("respBody", response.body().string());
                }
            }
            return respJson.toJSONString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POST同步请求(XML)
     * @param url   请求url
     * @param xml   请求xml参数
     * @return
     */
    public static String postWithXml(String url, String xml) {
        RequestBody body = RequestBody.create(OkHttpHelper.APPLICATION_XML, xml);
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = OkHttpHelper.execute(request);
            if (response != null && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POST异步请求(JSON)
     * @param url       请求url
     * @param callback  回调，成功返回目标类的对象
     * @param targetClz 返回目标类的类型
     */
    public static <T> void postWithJsonAsync(String url, String jsonParams, HttpCallback<T> callback, Class<T> targetClz) {
        RequestBody body = RequestBody.create(OkHttpHelper.APPLICATION_JSON, jsonParams);
        Request request = new Request.Builder().url(url).post(body).build();
        OkHttpHelper.enqueue(request, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    callback.onFail(e.toString());
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() != null) {
                    String result = response.body().string();
                    if (result != null && result.length() > 0) {
                        if (callback != null) {
                            callback.onSuccess(JSON.parseObject(result, targetClz));
                        }
                    }
                }
                if (callback != null) {
                    callback.onFail("return null");
                }
            }
        });
    }

    public static <T> void postWithFormAsync(String url, String jsonParams, HttpCallback<T> callback, Class<T> targetClz) {
        RequestBody body = RequestBody.create(OkHttpHelper.APPLICATION_FORM_URLENCODED, jsonParams);
        Request request = new Request.Builder().url(url).post(body).build();
        OkHttpHelper.enqueue(request, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    callback.onFail(e.toString());
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() != null) {
                    String result = response.body().string();
                    if (result != null && result.length() > 0) {
                        if (callback != null) {
                            callback.onSuccess(JSON.parseObject(result, targetClz));
                        }
                    }
                }
                if (callback != null) {
                    callback.onFail("return null");
                }
            }
        });
    }

    /**
     * POST同步请求
     * @param certPath      自签名路径
     * @param password      自签名密码
     * @param keyStoreType  自签名类型
     * @param url           请求url
     * @param params        请求参数
     * @param type          请求头类型
     * @return              返回字符串
     */
    public static String postSSL(String certPath, char[] password, String keyStoreType, String url, String params, MediaType type) {
        OkHttpClient client = OkHttpHelper.getTrustSSLClient(certPath, password, keyStoreType);
        RequestBody body = RequestBody.create(type, params);
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = client.newCall(request).execute();
            if (response != null && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String post(String url, MultiValueMap<String, String> params){
        RestTemplate client = getClient();
        HttpHeaders headers = getHeaders();
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);
        freeClient(client);

        return response.getBody();
    }

    public static String doService(String url, MultiValueMap<String, String> params, HttpMethod httpMethod){
        if(httpMethod == HttpMethod.GET){
            if( params!=null && !params.isEmpty() ){
                url+="?";
                for(String key : params.keySet()){
                    url+=key + "=" + params.get(key).get(0) + "&";
                }
                url = url.substring(0, url.length() - 1);
            }
            params = null;
        }
        RestTemplate client = getClient();
        HttpHeaders headers = null;
        if (httpMethod == HttpMethod.POST) {
            headers = getHeaders();
        }
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, httpMethod, requestEntity, String.class);
        freeClient(client);

        return response.getBody();
    }

    private static List<RestTemplate> clientPool = new ArrayList<>();
    private static RestTemplate getClient(){
        synchronized (clientPool)
        {
            if(clientPool.isEmpty())
                return new RestTemplate();
            return clientPool.remove(0);
        }
    }
    private static void freeClient(RestTemplate client)
    {
        synchronized (clientPool)
        {
            clientPool.add(client);
        }
    }
    private static HttpHeaders headers = null;
    private static synchronized HttpHeaders getHeaders(){
        if (headers == null)
        {
            headers = new HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED);
        }
        return headers;
    }
}
