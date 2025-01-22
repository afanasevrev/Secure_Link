package com.example.Server;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static String decrypt(String encryptedMessage, String secretKey) {
        try {
            byte[] decodedIvAndCiphertext = Base64.getDecoder().decode(encryptedMessage);
            byte[] iv = new byte[16];
            System.arraycopy(decodedIvAndCiphertext, 0, iv, 0, 16); // Извлечение IV
            byte[] cipherText = new byte[decodedIvAndCiphertext.length - 16];
            System.arraycopy(decodedIvAndCiphertext, 16, cipherText, 0, cipherText.length); // Извлечение шифротекста
            SecretKeySpec keySpec = new SecretKeySpec(hexStringToByteArray(secretKey), ALGORITHM);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] decryptedBytes = cipher.doFinal(cipherText);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
