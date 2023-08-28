package org.example.data.codwars;

public class Xbonacci {
    public double[] tribonacci(double[] s, int n) {
        // hackonacci me
        double[] answer = new double[n];
        int startI = 0;

        for (int i=0; (i<3 & i<n); i++) {
            answer[startI] = s[startI];
            startI++;
        }
        if (n < 3) {
            return answer;
        }
        for (int i=0; i<(n-3); i++) {
            // i, i+1, i+2
            answer[startI] = answer[i] + answer[i+1] + answer[i+2];
            startI++;
        }
        return answer;
    }
}
