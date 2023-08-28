package org.example.data.codwars;

public class SpyGraduation {

    public String decrypt(String encrypted) {
        //return the plain text before it was encrypted
        // we played with bits of plain text & password
        // with special XOR and finally got an encrypted text.
        char[] r=encrypted.toCharArray();
        for(int i=0; i<r.length; i++)
            r[i]&=255;
        return String.valueOf(r);
    }
}