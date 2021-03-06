package org.cryptoapi.bench.brokenhash;

import javax.crypto.NoSuchPaddingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

public class BrokenHashABSCase3 {
    CryptoHash3 crypto;

    public BrokenHashABSCase3() throws NoSuchAlgorithmException, NoSuchPaddingException {
        crypto = new CryptoHash3("MD4");
    }
}

class CryptoHash3 {
    /*@StringVal("MD4")*/ String crypto;

    public CryptoHash3(/*@StringVal("MD4")*/ String defCrypto) throws NoSuchPaddingException, NoSuchAlgorithmException {
        crypto = defCrypto;
    }

    public void encrypt(String str, String passedAlgo) throws Exception {
        if (passedAlgo.isEmpty()) {
            passedAlgo = crypto;
        }

        MessageDigest md = MessageDigest.getInstance(crypto);
        md.update(str.getBytes());
        System.out.println(md.digest());

    }
}
