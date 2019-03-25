package org.cryptoapi.bench.brokencrypto;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BrokenCryptoABSCorrected {
    Crypto0 crypto;
    public BrokenCryptoABSCorrected() throws NoSuchAlgorithmException, NoSuchPaddingException {
        crypto = new Crypto0("AES/GCM/NoPadding");
    }
}

class Crypto0 {
    Cipher cipher;
    /*@StringVal("AES/CBC/PKCS5Padding")*/ String defaultAlgo;
    public Crypto0(/*@StringVal("AES/GCM/NoPadding")*/ String defAlgo) throws NoSuchPaddingException, NoSuchAlgorithmException {
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

