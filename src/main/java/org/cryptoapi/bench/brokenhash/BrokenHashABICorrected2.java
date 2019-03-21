package org.cryptoapi.bench.brokenhash;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BrokenHashABICorrected2 {
    public static final String DEFAULT_CRYPTO = "SHA-256";
    private static char /*@StringVal("SHA-256")*/ [] CRYPTO;
    private static char /*@StringVal("SHA-256")*/ [] crypto;
    public static void main (String [] args) throws NoSuchAlgorithmException {
        String str = "abcdef";
        go2();
        go3();
        go(str);
    }

    private static void go2(){
        CRYPTO = DEFAULT_CRYPTO.toCharArray();
    }
    private static void go3(){
        crypto = CRYPTO;
    }

    public static void go (String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(String.valueOf(crypto));
        md.update(str.getBytes());
        System.out.println(md.digest());
    }
}
