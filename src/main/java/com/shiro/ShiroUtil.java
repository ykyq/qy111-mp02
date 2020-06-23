package com.shiro;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.util.DigestUtils;

/**
 * @Author: 陈建
 * @Date: 2019/10/10 0010 17:06
 * @Version 1.0
 */
public class ShiroUtil {
    /**
     * 传入一个明文返回一个加密之后的密文
     */
    public static String getciphertext(String phertext) {
        String ciphertext = DigestUtils.md5DigestAsHex(phertext.getBytes());
        return ciphertext;
    }

    /**
     * 加盐加密
     *
     * @param salt
     * @param message
     * @return
     */
    public static String encryptionBySalt(String salt, String message) {
        //String algorithmName 加密算法, Object source 明文, Object salt 盐值, int hashIterations 加密次数
        String algorithmName = Constants.ALGORITHM_NAME;
        int hashIterations = Constants.HASH_ITERATIONS;
        SimpleHash simpleHash = new SimpleHash(algorithmName, message, salt, hashIterations);
        return simpleHash.toString();
    }

    public static void main(String[] args) {
        String message = "123";
      /*  String s = getciphertext(message);
        System.out.println(s);*/
        //shiro加密
        String salt = "4bd21f";

        String encryption = encryptionBySalt(salt, message);
        System.out.println(encryption);

    }
}
