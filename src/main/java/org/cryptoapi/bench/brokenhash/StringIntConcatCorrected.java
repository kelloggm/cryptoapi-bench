package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class StringIntConcatCorrected {

    private final String start = "SHA-";
    private final int end = 256;

    public void go() throws NoSuchAlgorithmException {
        MessageDigest message = MessageDigest.getInstance(start + end);
    }

    public static void main (String [] args) throws NoSuchAlgorithmException {
        StringIntConcatCorrected bc = new StringIntConcatCorrected();
        bc.go();
    }
}
