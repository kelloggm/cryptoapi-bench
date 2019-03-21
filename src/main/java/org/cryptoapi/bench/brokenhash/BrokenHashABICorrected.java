package org.cryptoapi.bench.brokenhash;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BrokenHashABICorrected {
    public static void main (String [] args) throws NoSuchAlgorithmException {
        String str = "abcdef";
        String crypto = "SHA-256";
        go(str,crypto);
    }
    public static void go (String str, /*@StringVal("SHA-256")*/ String crypto) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(crypto);
        md.update(str.getBytes());
        System.out.println(md.digest());
    }
}
