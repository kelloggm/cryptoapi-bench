package org.cryptoapi.bench.ecbcrypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

public class EcbInSymmCryptoABICorrected1 {
    public void go(/*@StringVal("AES/CBC/PKCS5Padding")*/ String crypto) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(crypto);
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    public static void main (String [] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        EcbInSymmCryptoABICorrected1 bc = new EcbInSymmCryptoABICorrected1();
        String crypto = "AES/CBC/PKCS5Padding";
        bc.go(crypto);
    }
}
