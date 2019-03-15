package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class StringConcatCorrected {

    private final String start = "SHA";
    private final String end = "-256";

    public void go() throws NoSuchAlgorithmException {
        MessageDigest message = MessageDigest.getInstance(start + end);
    }

    public static void main (String [] args) throws NoSuchAlgorithmException {
        StringConcatCorrected bc = new StringConcatCorrected();
        bc.go();
    }
}
