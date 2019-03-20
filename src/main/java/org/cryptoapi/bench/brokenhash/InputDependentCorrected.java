package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class InputDependentCorrected {
    public void go(boolean safe) throws NoSuchAlgorithmException {
        String shortName;
        if (safe) {
            shortName = "SHA-256";
        } else {
            throw new IllegalArgumentException("never be unsafe");
        }
        MessageDigest message = MessageDigest.getInstance(shortName);
    }

    public static void main (String [] args) throws NoSuchAlgorithmException {
        InputDependentCorrected bc = new InputDependentCorrected();
        bc.go(args[1].equals("I want to be safe"));
    }
}
