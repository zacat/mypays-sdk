package com.zoeyun.mypays.sdk.common.utils;


import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Objects;

/**
 * RSA签名
 */
public class RsaUtils {
    public static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";
    public static final String SIGN_TYPE_RSA2 = "RSA";


    public RsaUtils() {
    }

    public static String rsa256Sign(byte[] content, PrivateKey priKey) {
        try {
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(priKey);
            signature.update(content);
            byte[] signed = signature.sign();
            return new String(Base64.getEncoder().encode(signed));
        } catch (Exception var4) {
            throw new RuntimeException("加签异常", var4);
        }
    }

    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, byte[] encodedKey) {
        try {
            if (!Objects.isNull(algorithm) && algorithm.trim().length() != 0) {
                KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
                encodedKey = Base64.getDecoder().decode(encodedKey);
                return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
            } else {
                throw new RuntimeException("私钥类型不能为空");
            }
        } catch (Exception var3) {
            throw new RuntimeException("获取私钥错误", var3);
        }
    }

    public static PublicKey getPublicKeyFromX509(String algorithm, byte[] encodedKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            encodedKey = Base64.getDecoder().decode(encodedKey);
            return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
        } catch (Exception var3) {
            throw new RuntimeException("获取公钥错误", var3);
        }
    }

    public static boolean rsa256CheckContent(byte[] content, String sign, String publicKey) {
        return rsa256CheckContent(content, sign, getPublicKeyFromX509("RSA", publicKey.getBytes()));
    }

    public static boolean rsa256CheckContent(byte[] content, String sign, PublicKey pubKey) {
        try {
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(pubKey);
            signature.update(content);
            boolean res = signature.verify(Base64.getDecoder().decode(sign.getBytes()));
            if (!res) {
                throw new RuntimeException();
            } else {
                return res;
            }
        } catch (Exception var5) {
            throw new RuntimeException("验签异常", var5);
        }
    }
}
