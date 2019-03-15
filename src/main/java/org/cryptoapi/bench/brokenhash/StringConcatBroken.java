package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class StringConcatBroken {

    private final String start = "SHA";
    private final String end = "1";

    public void go() throws NoSuchAlgorithmException {
        MessageDigest message = MessageDigest.getInstance(start + end);
    }

    public static void main (String [] args) throws NoSuchAlgorithmException {
        StringConcatBroken bc = new StringConcatBroken();
        bc.go();
    }
}
