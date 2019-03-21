package org.cryptoapi.bench.ecbcrypto;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EcbInSymmCryptoABSCorrected {
    CryptoECB0 crypto;
    public EcbInSymmCryptoABSCorrected() {
        String cryptoAlgo = "AES/CBC/PKCS5Padding";
        crypto = new CryptoECB0(cryptoAlgo);
    }
}

class CryptoECB0 {
    /*@StringVal("AES/CBC/PKCS5Padding")*/ String defAlgo;

    public CryptoECB0(/*@StringVal("AES/CBC/PKCS5Padding")*/ String algo) {
        defAlgo = algo;
    }

    public void encrypt(/*@StringVal("AES/CBC/PKCS5Padding")*/ String passedAlgo) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {

        if(passedAlgo.isEmpty()){
            passedAlgo = defAlgo;
        }

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(passedAlgo);
        cipher.init(Cipher.ENCRYPT_MODE, key);

    }
}
