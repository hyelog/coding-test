package org.example.data.structure.one;

public class StringRotation {
    public boolean rotation(String text1, String text2) {
        char[] text1Char = text1.toCharArray();
        char[] text2Char = text2.toCharArray();

        int text1Size = text1Char.length;
        int text2Size = text2Char.length;

        if (text1Size != text2Size) return false;
        int text1Head = 0;
        int text2Head = 0;

        int textCount = 0;
        int text1KeepHead = 0;
        int text1Count = 0;
        while ((textCount != text1Size) && (text1Count < text1Size)) {
            textCount = 0;
            text2Head = 0;
            while (text1Char[text1Head] != text2Char[text2Head]) {
                text1Head++;
                if (text1Head == text1Size) {
                    text1Head = 0;
                }
                text1Count++;
            }
            text1KeepHead = text1Head;

            while (text1Char[text1Head] == text2Char[text2Head]) {
                text1Head++;
                text2Head++;
                textCount++;
                if (textCount == text1Size) {
                    return true;
                }
                if (text1Head == text1Size) {
                    text1Head = 0;
                }
                if (text2Head == text2Size) {
                    text2Head = 0;
                }
            }
            if (textCount < text1Size) {
                text1Head = text1KeepHead + 1;
            }

        }
        return false;
    }

    static int isSubstring(String s1, String s2)
    {
        int M = s1.length();
        int N = s2.length();

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            int j;

            /* For current index i, check for
            pattern match */
            for (j = 0; j < M; j++)
                if (s2.charAt(i + j) != s1.charAt(j))
                    break;

            if (j == M)
                return i;
        }

        return -1;
    }

    public boolean rationWithSubString(String text1, String text2) {
        int len = text1.length();
        if (len == text2.length() && len > 0) {
            String text1text1 = text1 + text1;
            return (text2.indexOf(text1text1)!=-1)?false:true;
        }
        return false;
    }
}
