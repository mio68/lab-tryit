package mio68.lab.tryit.codewars;

// https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java
public class Snail {

    public static int[] snail(int[][] array) {
        int size = array.length == 0 ? 0 : array[0].length;
        int[] dst = new int[size * size];
        if (size != 0) {
            snailCopy(array, 0, 0, size, dst, 0);
        }
        return dst;
    }

    private static void snailCopy(int[][] src, int fromRow, int fromCol, int size, int[] dst, int dstOffset) {
        if (size == 1) {
            dst[dstOffset] = src[fromRow][fromCol];
            return;
        }
        int quarter = size - 1;
        int rightCol = fromCol + quarter;
        int bottomRow = fromRow + quarter;
        for (int i = 0; i < quarter; i++) {
            dst[dstOffset + i] = src[fromRow][fromCol + i];
            dst[dstOffset + quarter + i] = src[fromRow + i][rightCol];
            dst[dstOffset + quarter * 2 + i] = src[bottomRow][rightCol - i];
            dst[dstOffset + quarter * 3 + i] = src[bottomRow - i][fromCol];
        }
        if (size > 2) {
            snailCopy(src, fromRow + 1, fromCol + 1, size - 2, dst, dstOffset + 4 * quarter);
        }
    }

    // returns number of copied elements
    private static int copySquare(int[][] src, int fromRow, int fromCol, int edgeLength, int[] dst, int dstOffset) {
        if (dstOffset == dst.length) {
            return 0;
        } else {
            dstOffset += copyPath(src, fromRow, fromCol, edgeLength, dst, dstOffset);
            return copySquare(src, fromRow + 1, fromCol + 1, edgeLength - 2, dst, dstOffset);
        }
    }

    // returns number of copied elements
    private static int copyPath(int[][] src, int fromRow, int fromCol, int edgeLength, int[] dst, int dstOffset) {
        // copy top row
        for (int i = 0; i < edgeLength; i++) {
            dst[dstOffset++] = src[fromRow][fromCol++];
        }
        // copy right column
        fromCol--;
        fromRow++;
        for (int i = 1; i < edgeLength; i++) {
            dst[dstOffset++] = src[fromRow++][fromCol];
        }
        // copy bottom row
        fromCol--;
        fromRow--;
        for (int i = 1; i < edgeLength; i++) {
            dst[dstOffset++] = src[fromRow][fromCol--];
        }
        // copy left column
        fromCol++;
        fromRow--;
        for (int i = 2; i < edgeLength; i++) {
            dst[dstOffset++] = src[fromRow--][fromCol];
        }
        return edgeLength == 1 ? 1 : 4 * (edgeLength - 1);
    }

}