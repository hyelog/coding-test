package org.example.data.structure.one;

public class Function1Dot5 {
    public boolean isRecurrenceOne(String firstWord, String secondWord) {

        char[] firstWordChar = firstWord.toCharArray();
        char[] secondWordChar = secondWord.toCharArray();

        int firstWordLength = firstWordChar.length;
        int secondWordLength = secondWordChar.length;

        int countFirstLength = 0;
        int countSecondLength = 0;

        boolean[] firstCheck = new boolean[firstWordLength];
        boolean[] secondCheck = new boolean[secondWordLength];

        for (int i=0; i<firstWordLength; i++) {
            for (int j=0; j<secondWordLength; j++) {
                if (!firstCheck[i] & !secondCheck[j] & firstWordChar[i] == secondWordChar[j]) {
                    firstCheck[i] = true;
                    secondCheck[j] = true;
                    countFirstLength++;
                    countSecondLength++;
                }
            }
        }

        int firstGap = firstWordLength - countFirstLength;
        int secondGap = secondWordLength - countSecondLength;
        firstGap = (firstGap>0)?firstGap:-1*firstGap;
        secondGap = (secondGap>0)?secondGap:-1*secondGap;
        return ((firstGap + secondGap) == 1|(firstGap == 1 & secondGap == 1));
    }
}
