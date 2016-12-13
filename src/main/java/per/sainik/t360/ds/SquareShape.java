package per.sainik.t360.ds;

import per.sainik.t360.BlueCubeUtils;

/**
 * This represents a Shape which has square shape but having hole
 */
public class SquareShape implements ValidatableArtifact {

    /***
     * holds bit patterns in 2d array
     */
    private boolean square2DArray[][];

    /***
     * size of square
     */
    private int size;

    /***
     * constructor to create square shape
     * @param square2DArray
     */
    public SquareShape(boolean square2DArray[][]) {
        this.square2DArray = square2DArray;
        this.size = square2DArray.length;
    }

    /***
     * rotate the 2d array 90 degree anti clock wise
     */
    public void rotate90AntiClockWise() {
        for (int x = 0; x < size / 2; x++) {
            for (int y = x; y < size - x - 1; y++) {
                boolean temp = square2DArray[x][y];
                square2DArray[x][y] = square2DArray[y][size - 1 - x];
                square2DArray[y][size - 1 - x] = square2DArray[size - 1 - x][size - 1 - y];
                square2DArray[size - 1 - x][size - 1 - y] = square2DArray[size - 1 - y][x];
                square2DArray[size - 1 - y][x] = temp;
            }
        }
    }

    /***
     * flip the 2d array vertically
     */
    public void flipVertically() {
        for (int i = 0; i < (square2DArray.length / 2); i++) {
            boolean[] temp = square2DArray[i];
            square2DArray[i] = square2DArray[square2DArray.length - i - 1];
            square2DArray[square2DArray.length - i - 1] = temp;
        }
    }

    /***
     * create new {@link SquareShape} cloning the underline 2d array
     * @return cloned {@link SquareShape}
     */
    public SquareShape clone() {
        return new SquareShape(this.deepCloneSquareShapeArray());
    }

    /***
     * returns the new clone of 2 d array
     * @return cloned boolean bit patter
     */
    public boolean[][] deepCloneSquareShapeArray() {
        boolean[][] result = new boolean[this.square2DArray.length][];
        for (int r = 0; r < this.square2DArray.length; r++) {
            result[r] = this.square2DArray[r].clone();
        }
        return result;
    }

    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                toString += square2DArray[i][j] ? "[]" : " ";
            toString += BlueCubeUtils.newLIne;
        }
        toString += BlueCubeUtils.newLIne;
        return toString;
    }

    public boolean[][] getSquare2DArray() {
        return square2DArray;
    }

    public int getSize() {
        return size;
    }

    /***
     * checks if other than sides of {@link SquareShape} are solid and having no hole
     * @return true or false
     */
    public boolean isValidArtifact() {
        boolean isValid = true;
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                isValid &= this.square2DArray[i][j];
            }
        }
        return isValid;
    }
}
