package org.cryptoapi.bench.brokencrypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class StringConcatBroken {

    private final String first = "DES";
    private final String second = "ECB";
    private final String third = "PKCS5Padding";

    public void go() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance("D" + "ES");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(first + "/" + second + "/" + third);
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    public static void main (String [] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        StringConcatBroken bc = new StringConcatBroken();
        bc.go();
    }
}
