package org.cryptoapi.bench.brokenhash;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

public class BrokenHashABSCase1 {
    CryptoHash1 crypto;
    public BrokenHashABSCase1() throws NoSuchAlgorithmException, NoSuchPaddingException {
        crypto = new CryptoHash1("SHA1");
    }
}

class CryptoHash1 {
    /*@StringVal("SHA1")*/ String crypto;

    public CryptoHash1(/*@StringVal("SHA1")*/ String defCrypto) throws NoSuchPaddingException, NoSuchAlgorithmException {
        crypto = defCrypto;
    }

    public void encrypt(String str, String passedAlgo) throws UnsupportedEncodingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException {
        if(passedAlgo.isEmpty()){
            passedAlgo = crypto;
        }

        MessageDigest md = MessageDigest.getInstance(crypto);
        md.update(str.getBytes());
        System.out.println(md.digest());

    }
}
