package org.example.data.structure;

public class MatrixProblem {
    public boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i=first; i<last; i++) {
                int offset = i-first;
                int top = matrix[first][i];

                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }
        return true;
    }

    public boolean zeroMatrix(int[][] matrix) {
        if (matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int mVector = 0;
        int nVector = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    mVector |= 1 << i;
                    nVector |= 1 << j;
                }
            }
        }
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                int tempM = 1 << i;
                int tempN = 1 << j;

                if ((mVector & (tempM))!=0 || (nVector & (tempN))!=0) {
                    matrix[i][j] = 0;
                }
            }
        }
        return true;
    }
}
