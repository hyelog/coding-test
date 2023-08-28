package org.example.data.codwars;

public class Printer {

    public static String printerError(String s) {
        // your code
        char[] data = s.toCharArray();
        int error = 0;
        for (int i=0; i< s.length(); i++) {
            if (data[i] > 'm') {
                error++;
            }
        }
        return error + "/" + s.length();
    }
}