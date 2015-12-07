import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Panda on 2015-11-19.
 */
public class ReadTxtTest {
    @Test
    public void OpenTxtTest() throws FileNotFoundException {
        ReadTxt readTxt = new ReadTxt();
        String absolutePath = readTxt.getAbsolutePath();
        String resource_path = absolutePath + "\\src\\test\\resources\\TheLittlePrince_english.txt";
        readTxt.setEngResPath(resource_path);
        Assert.assertNotNull(readTxt.getKorBook());
    }

    @Test (expected = NullPointerException.class)
    public void OpenEmptyTxtTest() throws FileNotFoundException {
        ReadTxt readTxt = new ReadTxt();
        String absolutePath = readTxt.getAbsolutePath();
        String resource_path = absolutePath + "\\src\\test\\resources\\emptyTxt";
        System.out.println(resource_path);
        readTxt.setEngResPath(resource_path);
    }

}
