package org.example.data.structure.one;

public class StringCompression {
    public String compress(String test) {
        int length = test.length();

        StringBuilder stringBuilder = new StringBuilder();
        int resetCount = 0;
        for (int i=0; i<length; i++) {
            char testChar = test.charAt(i);
            resetCount++;

            if ((i == length-1) || (test.charAt(i+1) != testChar)) {
                stringBuilder.append(testChar);
                stringBuilder.append(resetCount);
                resetCount = 0;
            }
        }

        if (stringBuilder.length() > length) {
            return test;
        }
        return stringBuilder.toString();
    }
}
