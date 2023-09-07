package org.example.data.structure.one;

public class Function1Dot3 {

    public char[] replaceSpaces(char[] str, int truelength) {
        int spaceCount=0, index, i=0;
        for (i=0; i< truelength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = truelength + spaceCount*2;
        char[] answers = new char[index];
        if (truelength < str.length) str[truelength] = '\0';
        for (i=truelength-1; i>=0; i--) {
            if (str[i] == ' ') {
                answers[index-1] = '0';
                answers[index-2] = '2';
                answers[index-3] = '%';
                index = index -3;
            } else {
                answers[index -1] = str[i];
                index--;
            }
        }
        return answers;
    }
}
