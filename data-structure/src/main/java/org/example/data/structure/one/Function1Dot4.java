package org.example.data.structure.one;

public class Function1Dot4 {
    public boolean isPalindrome(String str) {
        String replace = str.replace(" ", "").toLowerCase();
        char[] words = replace.toCharArray();

        int[] charSetInt = new int['z' - 'a' + 1];
        // build character numbers
        for (char word : words) {
            charSetInt[word - 'a']++;
        }

        // check odds
        int oddNum = 0;
        for (int i = 0; i < ('z' - 'a' + 1); i++) {
            if (charSetInt[i] % 2 == 1) {
                oddNum++;
            }
            if (oddNum > 1) {
                return false;
            }
        }

        return true;
    }

    int createBitVector(String phrase){
        String replace = phrase.replace(" ", "").toLowerCase();

        int bitVector = 0;
        for (char c : replace.toCharArray()){
            int x = c-'a';
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    // 정수의 i번째 비트값을 toggle.
    int toggle(int bitVector, int index){
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector * mask) == 0){
            bitVector |= mask;
        }else{
            // 차집합: 비트 연산으로 구현하기
            bitVector &= ~mask;
        }
        return bitVector;
    }

    boolean checkExactlyOneBitSet(int bitVector){
        // 정수의 2의 지수승 여부 확인
        return (bitVector & (bitVector - 1)) == 0;
    }
    public boolean isPalindromeWithBit(String str) {
        int bitVector = createBitVector(str);

        return checkExactlyOneBitSet(bitVector);
    }
}