package org.cryptoapi.bench.ecbcrypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.checkerframework.common.value.qual.StringVal;

public class EcbInSymmCryptoABICase2 {
    public static final String DEFAULT_CRYPTO = "AES/ECB/PKCS5Padding";
    private static char @StringVal("AES/ECB/PKCS5Padding") [] CRYPTO;
    private static char @StringVal("AES/ECB/PKCS5Padding") [] crypto;
    public void go() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(String.valueOf(crypto));
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }
    private static void go2(){
        CRYPTO = DEFAULT_CRYPTO.toCharArray();
    }
    private static void go3(){
        crypto = CRYPTO;
    }

    public static void main (String [] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        EcbInSymmCryptoABICase2 bc = new EcbInSymmCryptoABICase2();
        go2();
        go3();
        bc.go();
    }
}
