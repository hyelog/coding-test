package org.example.data.structure;

public class Function1Dot2 {
    private String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    public boolean permutaionWithOccurance(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[128];

        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }

        for (int i=0; i<t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
