package org.cryptoapi.bench.brokencrypto;

import org.checkerframework.common.value.qual.StringVal;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BrokenCryptoABICorrected {
    public void doCrypto(@StringVal("AES/CBC/PKCS5Padding") String crypto) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(crypto);
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    public static void main (String [] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        BrokenCryptoABICorrected bc = new BrokenCryptoABICorrected();
        String crypto = "AES/CBC/PKCS5Padding";
        bc.doCrypto(crypto);
    }
}
