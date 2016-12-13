package per.sainik.t360;

import org.junit.Assert;
import org.junit.Test;
import per.sainik.t360.ds.SquareShape;


public class SquareShapeTest {

    @Test
    public void testRotation() {
        boolean array[][] = {
                {true, false, true, false, true},
                {true, true, true, true, true},
                {false, true, true, true, false},
                {true, true, true, true, true},
                {true, false, true, false, true}
        };
        SquareShape shape = new SquareShape(array);

        shape.rotate90AntiClockWise();

        boolean expectedArray[][] = {
                {true, true, false, true, true},
                {false, true, true, true, false},
                {true, true, true, true, true},
                {false, true, true, true, false},
                {true, true, false, true, true}
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Assert.assertEquals(shape.getSquare2DArray()[i][j], expectedArray[i][j]);
            }
        }
    }

    @Test
    public void testClone() {
        boolean array[][] = {
                {true, false, true, false, true},
                {true, true, true, true, true},
                {false, true, true, true, false},
                {true, true, true, true, true},
                {true, false, true, false, true}
        };
        SquareShape shape = new SquareShape(array);

        SquareShape cloned = shape.clone();
        cloned.getSquare2DArray()[0][0] = false;

        Assert.assertNotEquals(cloned.getSquare2DArray()[0][0], array[0][0]);

    }


    @Test
    public void testFlip() {
        boolean array[][] = {
                {true, true},
                {false, false}
        };
        SquareShape shape = new SquareShape(array);
        shape.flipVertically();
        boolean expectedArray[][] = {
                {false, false},
                {true, true}
        };
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(shape.getSquare2DArray()[i][j], expectedArray[i][j]);
            }
        }
    }


}
