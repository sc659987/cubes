package per.sainik.t360;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils class for Solution project
 */
public class BlueCubeUtils {


    /***
     * It removes one object and returns a copy of previous List
     * @param ts List from where object will be removed
     * @param t object to be removed
     * @param <T>
     * @return new List without the object t if presents
     */

    public static <T> List<T> removeAndReturnNewList(List<T> ts, T t) {
        List<T> tList = new ArrayList<T>(ts);
        tList.remove(t);
        return tList;
    }

    /***
     * System dependent new line
     */
    public static String newLIne = System.getProperty("line.separator");



}
