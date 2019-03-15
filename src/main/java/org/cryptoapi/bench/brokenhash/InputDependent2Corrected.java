package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class InputDependent2Corrected {
    public static void main (String [] args) throws NoSuchAlgorithmException {
        if (!args[1].equals("SHA-256")) {
            return;
        }
        MessageDigest message = MessageDigest.getInstance(args[1]);
    }
}
