package org.cryptoapi.bench.brokencrypto;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BrokenCryptoABICorrected2 {
    public static final String DEFAULT_CRYPTO = "AES/GCM/NoPadding";
    private static char /*@StringVal("AES/GCM/NoPadding")*/ [] CRYPTO;
    private static char /*@StringVal("AES/GCM/NoPadding")*/ [] crypto;
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
        BrokenCryptoABICorrected2 bc = new BrokenCryptoABICorrected2();
        go2();
        go3();
        bc.go();
    }

}
