package per.sainik.t360.ds;

import per.sainik.t360.BlueCubeUtils;

/**
 * Representation of Cube
 */
public class Cube extends FilePrintableCubeSolution implements ValidatableArtifact {

    /***
     * Bottom side of the cube
     */
    private SquareShape bottom;

    /***
     * Up side of the cube
     */
    private SquareShape up;

    /***
     * Right side of the cube
     */
    private SquareShape right;

    /***
     * Down side of the cube
     */
    private SquareShape down;

    /***
     * Left side of the cube
     */
    private SquareShape left;

    /***
     * Top side of the Cube
     */
    private SquareShape top;

    /***
     * Next side to be found
     */
    private Side nextSideToFind;

    /***
     * Edge length of the cube
     */
    private int edgeSize;

    /****
     * Create a cube with edge size
     * @param edgeSize
     */
    public Cube(int edgeSize) {
        nextSideToFind = Side.BOTTOM;
        this.edgeSize = edgeSize;
    }

    /***
     * Copy Constructor of the cube
     *
     * @param toCopyFromCube
     */
    public Cube(Cube toCopyFromCube) {
        this.bottom = toCopyFromCube.getBottom();
        this.up = toCopyFromCube.getUp();
        this.right = toCopyFromCube.getRight();
        this.down = toCopyFromCube.getDown();
        this.left = toCopyFromCube.getLeft();
        this.top = toCopyFromCube.getTop();
        this.nextSideToFind = toCopyFromCube.getNextSideToFind();
        this.edgeSize = toCopyFromCube.getEdgeSize();
    }

    /***
     * set the squareShape as next side and change value for nextSideToFind to next required one or NONE
     * @param squareShape to be used as next side
     */
    public void setNextSide(SquareShape squareShape) {
        switch (nextSideToFind) {
            case BOTTOM:
                this.bottom = squareShape;
                this.nextSideToFind = Side.UP;
                break;
            case UP:
                this.up = squareShape;
                this.nextSideToFind = Side.RIGHT;
                break;
            case RIGHT:
                this.right = squareShape;
                this.nextSideToFind = Side.DOWN;
                break;
            case DOWN:
                this.down = squareShape;
                this.nextSideToFind = Side.LEFT;
                break;
            case LEFT:
                this.left = squareShape;
                this.nextSideToFind = Side.TOP;
                break;
            case TOP:
                this.top = squareShape;
                this.nextSideToFind = Side.NONE;
                break;

        }
    }

    /***
     * get the bottom
     *
     * @return SquareShape
     */
    public SquareShape getBottom() {
        return bottom;
    }

    /**
     * set the bottom and set nextSideToFind to UP
     *
     * @param bottom
     */
    public void setBottom(SquareShape bottom) {
        this.bottom = bottom;
        this.nextSideToFind = Side.UP;
    }

    /***
     * get the Up
     *
     * @return SquareShape
     */
    public SquareShape getUp() {
        return up;
    }

    /**
     * set the up and set nextSideToFind to RIGHT
     *
     * @param up
     */
    public void setUp(SquareShape up) {
        this.up = up;
        this.nextSideToFind = Side.RIGHT;
    }

    /***
     * get the Right
     *
     * @return SquareShape
     */
    public SquareShape getRight() {
        return right;
    }

    /***
     * set the right  set nextSideToFind to DOWN
     *
     * @param right
     */
    public void setRight(SquareShape right) {
        this.right = right;
        this.nextSideToFind = Side.DOWN;
    }

    /***
     *  get the DOWN side shape
     *
     * @return SquareShape
     */
    public SquareShape getDown() {
        return down;
    }

    /***
     *
     * @param down
     */
    public void setDown(SquareShape down) {
        this.down = down;
        this.nextSideToFind = Side.LEFT;
    }

    /***
     *  get the LEFT side shape
     *
     * @return SquareShape
     */
    public SquareShape getLeft() {
        return left;
    }

    /***
     * set the LEFt and set nextSideToFind TOP
     *
     * @param left
     */
    public void setLeft(SquareShape left) {
        this.left = left;
        this.nextSideToFind = Side.TOP;
    }

    /***
     * get the TOP
     *
     * @return SquareShape
     */
    public SquareShape getTop() {
        return top;
    }

    public void setTop(SquareShape top) {
        this.top = top;
        this.nextSideToFind = Side.NONE;
    }

    /***
     * returns which side is to find next
     * @return Side
     */

    public Side getNextSideToFind() {
        return nextSideToFind;
    }

    public int getEdgeSize() {
        return edgeSize;
    }

    public void setEdgeSize(int edgeSize) {
        this.edgeSize = edgeSize;
    }

    /***
     * checks if shape can be fit as Up side if bottom is already available
     * @param squareShape to be used as Up
     * @return true if it fits otherwise false
     */
    private boolean doesShapeFitAsUp(SquareShape squareShape) {
        boolean bottom2DArray[][] = bottom.getSquare2DArray();
        boolean bottomUpSide[] = new boolean[bottom.getSize()];
        int index = 0;
        for (int i = 0; i < edgeSize; i++) {
            bottomUpSide[index++] = bottom2DArray[0][i];
        }
        boolean up2DArray[][] = squareShape.getSquare2DArray();
        boolean upDownSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            upDownSide[index++] = up2DArray[edgeSize - 1][i];
        }
        return doSidesSetWithEachOther(bottomUpSide, upDownSide);
    }

    /****
     * checks if shape can be fit as Right side if bottom and up side are already available
     * @param squareShape to be used as Right
     * @return true if it fits otherwise false
     */
    private boolean doesShapeFitAsRight(SquareShape squareShape) {
        boolean bottom2DArray[][] = bottom.getSquare2DArray();
        boolean bottomRightSide[] = new boolean[bottom.getSize()];
        int index = 0;
        for (int i = 0; i < edgeSize; i++) {
            bottomRightSide[index++] = bottom2DArray[i][edgeSize - 1];
        }
        boolean right2DArray[][] = squareShape.getSquare2DArray();
        boolean rightDownSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            rightDownSide[index++] = right2DArray[edgeSize - 1][i];
        }
        boolean up2DArray[][] = up.getSquare2DArray();
        boolean upRightSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            upRightSide[index++] = up2DArray[i][edgeSize - 1];
        }
        boolean rightLeftSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            rightLeftSide[index++] = right2DArray[i][0];
        }
        return doSidesSetWithEachOther(bottomRightSide, rightDownSide) && doSidesSetWithEachOther(upRightSide, rightLeftSide);
    }

    /****
     * checks if shape can be fit as Down side if down , up and right sides are already available
     * @param squareShape to be used as Down
     * @return true if it fits otherwise false
     */
    private boolean doesShapeFitAsDown(SquareShape squareShape) {
        boolean bottom2DArray[][] = bottom.getSquare2DArray();
        boolean bottomDownSide[] = new boolean[bottom.getSize()];
        int index = 0;
        for (int i = edgeSize - 1; i >= 0; i--) {
            bottomDownSide[index++] = bottom2DArray[edgeSize - 1][i];
        }
        boolean down2DArray[][] = squareShape.getSquare2DArray();
        boolean downUpSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            downUpSide[index++] = down2DArray[edgeSize - 1][i];
        }
        boolean right2DArray[][] = right.getSquare2DArray();
        boolean rightRightSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            rightRightSide[index++] = right2DArray[i][edgeSize - 1];
        }
        boolean downLeftSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            downLeftSide[index++] = down2DArray[i][0];
        }
        return doSidesSetWithEachOther(bottomDownSide, downUpSide) && doSidesSetWithEachOther(rightRightSide, downLeftSide);
    }

    /***
     * checks if SquareShape can be fit as Left Side if down , up , right and down sides are already available
     * @param squareShape to be used as Left
     * @return true if it fits otherwise false
     */
    private boolean doesShapeFitAsLeft(SquareShape squareShape) {
        boolean bottom2DArray[][] = bottom.getSquare2DArray();
        boolean bottomLeftSide[] = new boolean[bottom.getSize()];
        int index = 0;
        for (int i = edgeSize - 1; i >= 0; i--) {
            bottomLeftSide[index++] = bottom2DArray[i][0];
        }
        boolean left2DArray[][] = squareShape.getSquare2DArray();
        boolean leftDownSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            leftDownSide[index++] = left2DArray[edgeSize - 1][i];
        }
        boolean up2DArray[][] = up.getSquare2DArray();
        boolean upLeftSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            upLeftSide[index++] = up2DArray[i][0];
        }
        boolean leftRightSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            leftRightSide[index++] = left2DArray[i][edgeSize - 1];
        }
        boolean down2DArray[][] = down.getSquare2DArray();
        boolean downRightSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            downRightSide[index++] = down2DArray[i][edgeSize - 1];
        }
        boolean leftLeftSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            leftLeftSide[index++] = left2DArray[i][0];
        }
        return doSidesSetWithEachOther(bottomLeftSide, leftDownSide) && doSidesSetWithEachOther(upLeftSide, leftRightSide) && doSidesSetWithEachOther(downRightSide, leftLeftSide);
    }

    /***
     * checks if SquareShape can be used as top if all other sides are available
     * @param squareShape to be used as Top
     * @return true if it fits otherwise false
     */
    private boolean doesShapeFirAsTop(SquareShape squareShape) {
        boolean top2DArray[][] = squareShape.getSquare2DArray();
        boolean topUpSideFromInside[] = new boolean[bottom.getSize()];
        int index = 0;
        for (int i = edgeSize - 1; i >= 0; i--) {
            topUpSideFromInside[index++] = top2DArray[0][i];
        }
        boolean up2DArray[][] = up.getSquare2DArray();
        boolean upUpSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            upUpSide[index++] = up2DArray[0][i];
        }
        boolean topLeftSideFromInside[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            topLeftSideFromInside[index++] = top2DArray[i][0];
        }
        boolean right2DArray[][] = right.getSquare2DArray();
        boolean rightUpSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            rightUpSide[index++] = right2DArray[0][i];
        }
        boolean topDownSideFromInside[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            topDownSideFromInside[index++] = top2DArray[edgeSize - 1][i];
        }
        boolean down2DArray[][] = down.getSquare2DArray();
        boolean downUpSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            downUpSide[index++] = down2DArray[0][i];
        }
        boolean topRightSideFromInside[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = edgeSize - 1; i >= 0; i--) {
            topRightSideFromInside[index++] = top2DArray[i][edgeSize - 1];
        }
        boolean left2DArray[][] = left.getSquare2DArray();
        boolean leftUpSide[] = new boolean[bottom.getSize()];
        index = 0;
        for (int i = 0; i < edgeSize; i++) {
            leftUpSide[index++] = left2DArray[0][i];
        }
        return doSidesSetWithEachOther(topUpSideFromInside, upUpSide) && doSidesSetWithEachOther(topLeftSideFromInside, rightUpSide) && doSidesSetWithEachOther(topDownSideFromInside, downUpSide) &&
                doSidesSetWithEachOther(topRightSideFromInside, leftUpSide) &&
                doCornersMatch(squareShape);
    }

    /***
     * Once all sides are matched it checks if corners are filled  or not
     * @param possibleTop
     * @return
     */
    private boolean doCornersMatch(SquareShape possibleTop) {
        return ((up.getSquare2DArray()[0][0] || left.getSquare2DArray()[0][this.edgeSize - 1] || possibleTop.getSquare2DArray()[0][this.edgeSize - 1])
                && (up.getSquare2DArray()[0][this.edgeSize - 1] || right.getSquare2DArray()[0][0] || possibleTop.getSquare2DArray()[0][0])
                && (up.getSquare2DArray()[this.edgeSize - 1][0] || bottom.getSquare2DArray()[0][0] || left.getSquare2DArray()[this.edgeSize - 1][this.edgeSize - 1])
                && (up.getSquare2DArray()[this.edgeSize - 1][this.edgeSize - 1] || bottom.getSquare2DArray()[0][this.edgeSize - 1] || right.getSquare2DArray()[this.edgeSize - 1][0])
                && (down.getSquare2DArray()[0][0] || possibleTop.getSquare2DArray()[this.edgeSize - 1][0] || right.getSquare2DArray()[0][this.edgeSize - 1])
                && (down.getSquare2DArray()[0][this.edgeSize - 1] || left.getSquare2DArray()[0][0] || possibleTop.getSquare2DArray()[this.edgeSize - 1][this.edgeSize - 1])
                && (down.getSquare2DArray()[this.edgeSize - 1][this.edgeSize - 1] || bottom.getSquare2DArray()[this.edgeSize - 1][0] || left.getSquare2DArray()[this.edgeSize - 1][0])
                && (down.getSquare2DArray()[this.edgeSize - 1][0] || bottom.getSquare2DArray()[this.edgeSize - 1][this.edgeSize - 1] || right.getSquare2DArray()[this.edgeSize - 1][this.edgeSize - 1]));
    }

    /***
     * checks if nextSquareShape match with next vacant position
     * @param nextSquareShape  the shape to be matched
     * @return true if nextSquareShape matched for next position
     */
    public boolean match(SquareShape nextSquareShape) {
        switch (nextSideToFind) {
            case BOTTOM:
                return true;
            case UP:
                return doesShapeFitAsUp(nextSquareShape);
            case RIGHT:
                return doesShapeFitAsRight(nextSquareShape);
            case DOWN:
                return doesShapeFitAsDown(nextSquareShape);
            case LEFT:
                return doesShapeFitAsLeft(nextSquareShape);
            case TOP:
                return doesShapeFirAsTop(nextSquareShape);
        }
        return false;
    }

    /***
     * checks both array follow  rule to be fit .which means both array complement each other in all index other than start and end index
     * @param shapeOneSidePattern
     * @param shapeTwoSidePattern
     * @return true or false
     */
    private boolean doSidesSetWithEachOther(boolean shapeOneSidePattern[], boolean shapeTwoSidePattern[]) {
        boolean firstPlace = shapeOneSidePattern[0] && shapeTwoSidePattern[0];
        boolean lastPlace = shapeOneSidePattern[this.edgeSize - 1] && shapeTwoSidePattern[this.edgeSize - 1];
        boolean middlePlaces = false;
        for (int i = 1; i < this.edgeSize - 1; i++)
            middlePlaces |= (shapeOneSidePattern[i] == shapeTwoSidePattern[i]);
        if (firstPlace || middlePlaces || lastPlace)
            return false;
        return true;
    }

    /***
     * get a clone of the object
     * @return
     */
    public Cube getClone() {
        return new Cube(this);
    }

    /***
     * makes a unfolded of solution which is human readable or printable
     * @return
     */
    protected boolean[][] giveSolution() {
        if (!isValidArtifact())
            return null;
        boolean[][] flatSolution = new boolean[4 * this.edgeSize][3 * this.edgeSize];
        // LEFT SIDE
        for (int i = 0; i < this.edgeSize; i++) {
            for (int j = 0; j < this.edgeSize; j++) {
                flatSolution[this.edgeSize - 1 - j][i] = left.getSquare2DArray()[i][j];
            }
        }
        //BOTTOM SIDE
        for (int i = 0; i < this.edgeSize; i++) {
            for (int j = 0; j < this.edgeSize; j++) {
                flatSolution[i][this.edgeSize + j] = bottom.getSquare2DArray()[i][j];
            }
        }
        // RIGHT SIDE
        for (int i = 0; i < this.edgeSize; i++) {
            for (int j = 0; j < this.edgeSize; j++) {
                flatSolution[j][3 * this.edgeSize - 1 - i] = right.getSquare2DArray()[i][j];
            }
        }
        // DOWN SIDE
        for (int i = 0; i < this.edgeSize; i++) {
            for (int j = 0; j < this.edgeSize; j++) {
                flatSolution[2 * this.edgeSize - 1 - i][2 * this.edgeSize - 1 - j] = down.getSquare2DArray()[i][j];
            }
        }
        // TOP SIDE
        for (int i = 0; i < this.edgeSize; i++) {
            for (int j = 0; j < this.edgeSize; j++) {
                flatSolution[3 * this.edgeSize - 1 - i][2 * this.edgeSize - 1 - j] = top.getSquare2DArray()[i][j];
            }
        }
        // UP SIDE
        for (int i = 0; i < this.edgeSize; i++) {
            for (int j = 0; j < this.edgeSize; j++) {
                flatSolution[3 * this.edgeSize + i][this.edgeSize + j] = up.getSquare2DArray()[i][j];
            }
        }
        return flatSolution;
    }

    @Override
    public String toString() {
        if (isValidArtifact()) {
            boolean flatSolution[][] = giveSolution();
            String str = BlueCubeUtils.newLIne;
            for (int i = 0; i < 4 * this.edgeSize; i++) {
                for (int j = 0; j < 3 * this.edgeSize; j++) {
                    str += flatSolution[i][j] ? "[]" : "  ";
                }
                str += BlueCubeUtils.newLIne;
            }
            return str;
        }
        return super.toString();
    }

    /***
     * checks if cube is completely valid
     * @return true or false
     */
    public boolean isValidArtifact() {
        if (bottom != null && up != null && right != null && down != null && left != null && top != null && nextSideToFind == Side.NONE)
            return doesShapeFitAsUp(this.up) && doesShapeFitAsRight(this.right) && doesShapeFitAsDown(this.down) && doesShapeFitAsLeft(this.left) && doesShapeFirAsTop(this.top) &&
                    bottom.isValidArtifact() && up.isValidArtifact() && right.isValidArtifact() && down.isValidArtifact() && left.isValidArtifact() && top.isValidArtifact();
        return false;
    }
}
