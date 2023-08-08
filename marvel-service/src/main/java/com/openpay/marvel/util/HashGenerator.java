package com.openpay.marvel.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashGenerator {

    private static final String MD5 = "MD5";

    public static String generate(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            byte[] bytes = md.digest(text.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
