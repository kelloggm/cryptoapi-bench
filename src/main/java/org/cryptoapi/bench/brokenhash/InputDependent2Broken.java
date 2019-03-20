package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class InputDependent2Broken {
    public static void main (String [] args) throws NoSuchAlgorithmException {
        MessageDigest message = MessageDigest.getInstance(args[1]);
    }
}
