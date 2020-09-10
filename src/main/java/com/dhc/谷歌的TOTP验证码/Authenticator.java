package com.dhc.谷歌的TOTP验证码;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

import java.util.Date;

/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/12/24 9:45
 * @description：
 * Time-based One-time Password (TOTP) 算法
 */
public class Authenticator {
    public static void main(String[] args) {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        System.out.println(key.getKey());
        System.out.println(key.getVerificationCode());
        System.out.println(gAuth.authorize("SCGRBPI5KHIEWA5W", 664766));

    }
}
