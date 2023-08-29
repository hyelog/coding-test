package org.example.data.structure;

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
}
