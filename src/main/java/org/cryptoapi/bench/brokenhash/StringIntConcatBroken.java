package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class StringIntConcatBroken {

    private final String start = "SHA";
    private final int end = 1;

    public void go() throws NoSuchAlgorithmException {
        MessageDigest message = MessageDigest.getInstance(start + end);
    }

    public static void main (String [] args) throws NoSuchAlgorithmException {
        StringIntConcatBroken bc = new StringIntConcatBroken();
        bc.go();
    }
}
