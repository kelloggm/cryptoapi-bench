package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*>>>
import org.checkerframework.common.value.qual.StringVal;
*/

public class BrokenHashABICase1 {
    public static void main (String [] args) throws NoSuchAlgorithmException {
        String str = "abcdef";
        String crypto = "SHA1";
        go(str,crypto);
    }
    public static void go (String str, /*@StringVal("SHA1")*/ String crypto) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(crypto);
        md.update(str.getBytes());
        System.out.println(md.digest());
    }
}
