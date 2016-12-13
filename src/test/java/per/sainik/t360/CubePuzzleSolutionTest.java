package per.sainik.t360;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import per.sainik.t360.ds.Cube;
import per.sainik.t360.ds.SquareShape;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

public class CubePuzzleSolutionTest {

    private static final Logger logger = LoggerFactory.getLogger(CubePuzzleSolutionTest.class);

    @Test
    public void positiveTest() {
        boolean firstShapeArray[][] = {
                {false, false, true, false, false},
                {false, true, true, true, false},
                {true, true, true, true, true},
                {false, true, true, true, false},
                {false, false, true, false, false}
        };
        SquareShape firstSquareShape = new SquareShape(firstShapeArray);
        boolean secondShapeArray[][] = {
                {true, false, true, false, true},
                {true, true, true, true, true},
                {false, true, true, true, false},
                {true, true, true, true, true},
                {true, false, true, false, true}
        };
        SquareShape secondSquareShape = new SquareShape(secondShapeArray);
        boolean thirdShapeArray[][] = {
                {false, false, true, false, false},
                {false, true, true, true, true},
                {true, true, true, true, false},
                {false, true, true, true, true},
                {false, false, true, false, false}
        };
        SquareShape thirdSquareShape = new SquareShape(thirdShapeArray);
        boolean fourthShapeArray[][] = {
                {false, true, false, true, false},
                {true, true, true, true, false},
                {false, true, true, true, true},
                {true, true, true, true, false},
                {true, true, false, true, false}
        };
        SquareShape fourthSquareShape = new SquareShape(fourthShapeArray);
        boolean fifthShapeArray[][] = {
                {false, true, false, true, false},
                {true, true, true, true, true},
                {false, true, true, true, false},
                {true, true, true, true, true},
                {true, false, true, false, false}
        };
        SquareShape fifthSquareShape = new SquareShape(fifthShapeArray);
        boolean sixthShapeArray[][] = {
                {false, true, false, true, false},
                {false, true, true, true, true},
                {true, true, true, true, false},
                {false, true, true, true, true},
                {true, true, false, true, true}
        };
        SquareShape sixthSquareShape = new SquareShape(sixthShapeArray);
        List<SquareShape> squareShapes = new ArrayList<SquareShape>();
        squareShapes.add(fifthSquareShape);
        squareShapes.add(firstSquareShape);
        squareShapes.add(sixthSquareShape);
        squareShapes.add(thirdSquareShape);
        squareShapes.add(secondSquareShape);
        squareShapes.add(fourthSquareShape);


        Cube cube = CubePuzzleSolution.solution(squareShapes);
        Cube result = new Cube(cube.getEdgeSize());
        assertSame(true, result.match(cube.getBottom()));
        assertSame(true, result.match(cube.getUp()));
        assertSame(true, result.match(cube.getRight()));
        assertSame(true, result.match(cube.getDown()));
        assertSame(true, result.match(cube.getLeft()));
        assertSame(true, result.match(cube.getTop()));
        logger.info("One of the solutions in \"unfolded form\" looks as follows:" + BlueCubeUtils.newLIne + "{}", cube.toString());
        try {
            cube.printOnFile("cubes_solution.txt");
        } catch (Exception e) {
        }

    }

}
