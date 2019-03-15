package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class InputDependentBroken {
    public void go(boolean safe) throws NoSuchAlgorithmException {
        String shortName;
        if (safe) {
            shortName = "SHA-256";
        } else {
            shortName = "MD5";
        }
        MessageDigest message = MessageDigest.getInstance(shortName);
    }

    public static void main (String [] args) throws NoSuchAlgorithmException {
        InputDependentBroken bc = new InputDependentBroken();
        bc.go(args[1].equals("I want to be safe"));
    }
}
