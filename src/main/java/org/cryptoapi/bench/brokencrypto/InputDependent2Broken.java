package org.cryptoapi.bench.brokencrypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class InputDependent2Broken {
    public static void main (String [] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance(args[1]);
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(args[2]);
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }
}
