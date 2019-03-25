package org.cryptoapi.bench.brokencrypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class StringConcatCorrected {

    private final String first = "AES";
    private final String second = "GCM";
    private final String third = "NoPadding";

    public void go() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance("A" + "ES");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(first + "/" + second + "/" + third);
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    public static void main (String [] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        StringConcatCorrected bc = new StringConcatCorrected();
        bc.go();
    }
}
