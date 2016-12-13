package per.sainik.t360;

import per.sainik.t360.ds.Cube;
import per.sainik.t360.ds.SquareShape;

import java.util.List;

/***
 * Solution for the problem
 */
public class CubePuzzleSolution {

  /***
   * find a solution to given cube if solution exists
   * @param squareShapeList
   * @return
   */
  public static Cube solution(List<SquareShape> squareShapeList) {
    return solution(new Cube(squareShapeList.get(0).getSize()), squareShapeList);
  }

  /***
   * This is a branch and bound exponential fan out function
   * but due to restriction of 8 face of any possible cube
   * this function will not fan out exponential way.
   * @param cube
   * @param remainingSquareShape
   * @return
   */
  private static Cube solution(Cube cube, List<SquareShape> remainingSquareShape) {

    if (cube.isValidArtifact())
      return cube;

    for (SquareShape squareShape : remainingSquareShape) {
      SquareShape copySquareShape = squareShape.clone();
      for (int i = 0; i < 4; i++) {
        if (cube.match(copySquareShape)) {
          Cube possibleCube = cube.getClone();
          possibleCube.setNextSide(copySquareShape.clone());
          Cube solution = solution(possibleCube, BlueCubeUtils.removeAndReturnNewList(remainingSquareShape, squareShape));
          if (solution != null)
            return solution;
        }
        copySquareShape.rotate90AntiClockWise();
      }

      copySquareShape.flipVertically();

      for (int i = 0; i < 4; i++) {
        if (cube.match(copySquareShape)) {
          Cube possibleCube = cube.getClone();
          possibleCube.setNextSide(copySquareShape.clone());
          Cube solution = solution(possibleCube, BlueCubeUtils.removeAndReturnNewList(remainingSquareShape, squareShape));
          if (solution != null)
            return solution;
        }
        copySquareShape.rotate90AntiClockWise();
      }

    }
    return null;
  }

}
