package org.example.data.structure;

import java.util.Arrays;

public class MainArray {

    public static void main(String[] args) {
        Function1Dot1 function1Dot1 = new Function1Dot1();

        String testString = "abcdefghijklm";

        System.out.println("first case:" + function1Dot1.isUniqueChars(testString));
        System.out.println("first case with bit:" + function1Dot1.isUniqueCharsWithBit(testString));

        System.out.println("second case:" + function1Dot1.isUniqueChars(testString + "a"));
        System.out.println("second case with bit:" + function1Dot1.isUniqueCharsWithBit(testString + "a"));

        Function1Dot2 function1Dot2Dash1 = new Function1Dot2();

        System.out.println("1.2 simple result: " + function1Dot2Dash1.permutation("dog", "god"));
        System.out.println("1.2 occurrence result: " + function1Dot2Dash1.permutaionWithOccurance("dog", "god"));

        Function1Dot3 function1Dot3 = new Function1Dot3();
        System.out.println("1.3 result : " + Arrays.toString(function1Dot3.replaceSpaces("Mr John Smith".toCharArray(),
                13)));

        String question = "tomacto";
        Function1Dot4 function1Dot4 = new Function1Dot4();
        System.out.println("1.4 answer: " + function1Dot4.isPalindrome(question));

        System.out.println("1.4 answer with Bit: " + function1Dot4.isPalindromeWithBit(question));

        String firstWord = "pale";
        String secondWord = "bake";
        Function1Dot5 function1Dot5 = new Function1Dot5();
        System.out.println("1.5 answer: " + (function1Dot5.isRecurrenceOne(firstWord, secondWord)?"true" : "false"));

        String compressionTest = "aaaabbccaaabb";

        StringCompression stringCompression = new StringCompression();
        System.out.println("1.6 answer: " + stringCompression.compress(compressionTest));

        MatrixProblem matrixProblem = new MatrixProblem();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixProblem.rotate(matrix);

        int[][] matrixZero = {{3, 0, 0}, {0, 3, 4}, {5, 6, 7}};
        matrixProblem.zeroMatrix(matrixZero);

        String text1 = "waterer";
        String text2 = "erwater";

        StringRotation stringRotation = new StringRotation();
        System.out.println(stringRotation.rotation(text1, text2)?"true":"false");

        System.out.println(stringRotation.rationWithSubString(text1, text2)?"true":"false");

    }

}