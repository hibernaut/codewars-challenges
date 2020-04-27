package com.hibernaut.katas;

/**
 * For building the encrypted string:
 * Take every 2nd char from the string, then the other chars, that are not every 2nd char, and concat them as new String.
 * Do this n times!
 * <p>
 * Examples:
 * <p>
 * "This is a test!", 1 -> "hsi  etTi sats!"
 * "This is a test!", 2 -> "hsi  etTi sats!" -> "s eT ashi tist!"
 * <p>
 * Write two methods:
 * <p>
 * String encrypt(final String text, final int n)
 * String decrypt(final String encryptedText, final int n)
 * <p>
 * For both methods:
 * If the input-string is null or empty return exactly this value!
 * If n is <= 0 then return the input text.
 */

public class SimpleEncryptionAlternatingSplit {
    public static String encrypt(final String text, final int n) {
        String string = text;
        StringBuffer buffer = new StringBuffer("");

        if (string != null && string != "") {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < string.length(); j += 2) {
                    buffer.append(string.charAt(j));
                }
                for (int j = 0; j < string.length(); j += 2) {
                    buffer.append(string.charAt(j));
                }
                string = buffer.toString();
                buffer = new StringBuffer("");
            }
        }

        return string;
    }

    public static String decrypt(final String encryptedText, final int n) {
        String string = encryptedText;
        StringBuffer buffer = new StringBuffer("");

        if (string != null && string != "") {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < (string.length() / 2); j++) {
                    buffer.append(string.charAt(string.length() / 2 + j));
                    buffer.append(string.charAt(j));
                }
                if (string.length() % 2 != 0) {
                    buffer.append(string.charAt(string.length() - 1));
                }

                string = buffer.toString();
                buffer = new StringBuffer("");
            }
        }

        return string;
    }

    public static void main(String[] args) {
        String encryption = encrypt(null, 0);
        String decryption = decrypt(encryption, 1);
        System.out.println(encryption);
        System.out.println(decryption);
    }
}
