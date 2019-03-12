package org.cryptoapi.bench.brokencrypto;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.checkerframework.common.value.qual.StringVal;

public class BrokenCryptoABSCase1 {
    Crypto2 crypto;
    public BrokenCryptoABSCase1() throws NoSuchAlgorithmException, NoSuchPaddingException {
        crypto = new Crypto2("DES/ECB/PKCS5Padding");
    }
}

class Crypto2 {
    Cipher cipher;
    @StringVal("DES/ECB/PKCS5Padding") String defaultAlgo;
    public Crypto2(@StringVal("DES/ECB/PKCS5Padding") String defAlgo) throws NoSuchPaddingException, NoSuchAlgorithmException {
        defaultAlgo = defAlgo;
    }

    public byte[] encrypt(String txt, String passedAlgo) throws UnsupportedEncodingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException {
        if(passedAlgo.isEmpty()){
            passedAlgo = defaultAlgo;
        }

        KeyGenerator keyGen = KeyGenerator.getInstance(defaultAlgo);
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(defaultAlgo);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte [] txtBytes = txt.getBytes();
        return cipher.doFinal(txtBytes);
    }
}
