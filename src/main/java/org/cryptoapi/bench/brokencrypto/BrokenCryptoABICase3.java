package org.cryptoapi.bench.brokencrypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

public class BrokenCryptoABICase3 {
    public void go(/*@StringVal("RC4")*/ String crypto) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance("RC4");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(crypto);
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    public static void main (String [] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        BrokenCryptoABICase3 bc = new BrokenCryptoABICase3();
        String crypto = "RC4";
        bc.go(crypto);
    }
}
