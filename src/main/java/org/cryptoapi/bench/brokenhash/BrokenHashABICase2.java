package org.cryptoapi.bench.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.checkerframework.common.value.qual.StringVal;

public class BrokenHashABICase2 {
    public static void main (String [] args) throws NoSuchAlgorithmException {
        String str = "abcdef";
        String crypto = "MD5";
        go(str,crypto);
    }
    public static void go (String str, @StringVal("MD5") String crypto) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(crypto);
        md.update(str.getBytes());
        System.out.println(md.digest());
    }
}
