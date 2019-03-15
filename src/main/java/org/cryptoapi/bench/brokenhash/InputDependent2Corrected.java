package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class InputDependent2Corrected {
    public static void main (String [] args) throws NoSuchAlgorithmException {
        String input = args[1];
        if (!input.equals("SHA-256")) {
            return;
        }
        MessageDigest message = MessageDigest.getInstance(input);
    }
}
