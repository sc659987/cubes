package per.sainik.t360.ds;

import per.sainik.t360.BlueCubeUtils;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/****
 * It takes a two dimensional array and prints on file
 */
public abstract class FilePrintableCubeSolution {

  protected abstract boolean[][] giveSolution();

  /***
   * prints on file using UTF-8(ASCII chars)
   * @param absoluteFilePath path to file
   * @throws FileNotFoundException if not possible to create the file
   * @throws UnsupportedEncodingException will never occur
   */
  public void printOnFile(String absoluteFilePath) throws FileNotFoundException, UnsupportedEncodingException {
    PrintWriter writer = new PrintWriter(absoluteFilePath, "UTF-8");
    print(writer);
  }

  /***
   * prints on Any Output Stream
   * @param outputStream
   */
  public void printOnOutputStream(OutputStream outputStream) {
    PrintWriter writer = new PrintWriter(outputStream);
    print(writer);
  }

  /***
   * prints on System.out
   */
  public void printOnSystemOut() {
    print(new PrintWriter(System.out));
  }

  /***
   * it takes the giveSolution and prints on PrintWriter
   * @param printWriter
   */
  private void print(PrintWriter printWriter) {
    boolean oneSolution[][] = giveSolution();
    printWriter.print("One of the solutions in \"unfolded form\" looks as follows:" + BlueCubeUtils.newLIne + BlueCubeUtils.newLIne);
    for (int i = 0; i < oneSolution.length; i++) {
      for (int j = 0; j < oneSolution[0].length; j++) {
        printWriter.print(oneSolution[i][j] ? "[]" : "  ");
      }
      printWriter.println();
    }
    printWriter.close();
  }

}
