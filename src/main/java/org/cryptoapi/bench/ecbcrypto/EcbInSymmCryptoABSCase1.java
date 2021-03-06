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

public class EcbInSymmCryptoABSCase1 {
    CryptoECB1 crypto;
    public EcbInSymmCryptoABSCase1() {
        String cryptoAlgo = "AES/ECB/PKCS5Padding";
        crypto = new CryptoECB1(cryptoAlgo);
    }
}

class CryptoECB1 {
    /*@StringVal("AES/ECB/PKCS5Padding")*/ String defAlgo;

    public CryptoECB1(/*@StringVal("AES/ECB/PKCS5Padding")*/ String algo) {
        defAlgo = algo;
    }

    public void encrypt(/*@StringVal("AES/ECB/PKCS5Padding")*/ String passedAlgo) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {

        if(passedAlgo.isEmpty()){
            passedAlgo = defAlgo;
        }

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(passedAlgo);
        cipher.init(Cipher.ENCRYPT_MODE, key);

    }
}
