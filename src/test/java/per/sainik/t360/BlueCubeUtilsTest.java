package per.sainik.t360;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BlueCubeUtilsTest {

    @Test
    public void testRemoveAndReturnNewList() {
        List<String> strings = new ArrayList<String>();
        strings.add("abcd");
        strings.add("efgh");
        List<String> modifiedString = BlueCubeUtils.removeAndReturnNewList(strings, "efgh");
        Assert.assertEquals(1, modifiedString.size());
    }

}
