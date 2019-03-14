package org.cryptoapi.bench.brokenhash;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BrokenHashABSCase1 {
    CryptoHash0 crypto;
    public BrokenHashABSCase1() throws NoSuchAlgorithmException, NoSuchPaddingException {
        crypto = new CryptoHash0("SHA-256");
    }

    class CryptoHash0 {
        @StringVal("SHA-256")
        String crypto;

        public CryptoHash0(@StringVal("SHA-256") String defCrypto) throws NoSuchPaddingException, NoSuchAlgorithmException {
            crypto = defCrypto;
        }

        public void encrypt(String str, String passedAlgo) throws UnsupportedEncodingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException {
            if (passedAlgo.isEmpty()) {
                passedAlgo = crypto;
            }

            MessageDigest md = MessageDigest.getInstance(crypto);
            md.update(str.getBytes());
            System.out.println(md.digest());

        }
    }
}

