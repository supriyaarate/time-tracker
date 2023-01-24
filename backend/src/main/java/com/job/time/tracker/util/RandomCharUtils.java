package com.job.time.tracker.util;

import java.security.SecureRandom;
import java.util.Base64;

public class RandomCharUtils {

    public static String generateRandomBase64Token() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[9];
        secureRandom.nextBytes(token);
        return Base64.getMimeEncoder().withoutPadding().encodeToString(token); //base64 encoding
    }
}
