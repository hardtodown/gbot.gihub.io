package O4array;

public class Print2DArr {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}};
        print(matrix);
    }
    public static void print(int[][] matrix) {
        int leftUpRow=0,leftUpCol=0,rightDownRow=matrix.length-1,rightDownCol=matrix[0].length-1;
        while (leftUpCol<=rightDownCol&&leftUpRow<=rightDownRow) {
            int r = leftUpRow, c = leftUpCol;
            while (c <= rightDownCol) {
                System.out.print(matrix[r][c++] + " ");
            }
            c = rightDownCol;
            r++;
            while (r <= rightDownRow) {
                System.out.print(matrix[r++][c] + " ");
            }
            r = rightDownRow;
            c--;
            while (c >= leftUpCol) {
                System.out.print(matrix[r][c--] + " ");
            }
            c++;
            r--;
            while (r > leftUpRow) {
                System.out.print(matrix[r--][c] + " ");
            }
            leftUpCol++;
            leftUpRow++;
            rightDownCol--;
            rightDownRow--;
        }
    }
}
