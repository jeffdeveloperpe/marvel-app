package com.openpay.service.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

    private static final String MD5 = "MD5";

    public static String generate(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            byte[] bytes = md.digest(text.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toHexString((aByte & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
