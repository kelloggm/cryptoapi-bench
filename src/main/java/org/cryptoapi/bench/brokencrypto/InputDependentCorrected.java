package org.cryptoapi.bench.brokencrypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class InputDependentCorrected {
    public void go(boolean safe) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String algorithm, shortName;
        if (safe) {
            algorithm = "AES/CBC/PKCS5Padding";
            shortName = "AES";
        } else {
            throw new IllegalArgumentException("only do safe things");
        }
        KeyGenerator keyGen = KeyGenerator.getInstance(shortName);
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    public static void main (String [] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        InputDependentCorrected bc = new InputDependentCorrected();
        bc.go(args[1].equals("I want to be safe"));
    }
}
