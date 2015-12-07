import junit.framework.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by Panda on 2015-11-20.
 */
public class ResourceTxtTest {

    ReadTxt readTxt = new ReadTxt();
    String absolutePath = readTxt.getAbsolutePath();
    String resource_path = absolutePath + "\\src\\test\\resources\\TheLittlePrince_english.txt";

    @Test
    public void ResourceTxtNormalTest() {
        try {
            readTxt.setEngResPath(resource_path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ResourceTxt test = readTxt.getEngBook();
        Assert.assertEquals(7,test.getTextLine());
    }

    @Test
    public void ResourceTxtReadTest() {
        try {
            readTxt.setEngResPath(resource_path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ResourceTxt test = readTxt.getEngBook();
        Assert.assertEquals("I saw a picture of a boa snake swallowing an animal in a book when I was six years old.",
                test.getSceneString(0));
        Assert.assertEquals("Boas sleep through the six months for digestion after they swallow their food without chewing it.",
                test.getSceneString(1));

        Assert.assertEquals("I saw a picture of a boa snake swallowing an animal in a book when I was six years old.\n" +
                "Boas sleep through the six months for digestion after they swallow their food without chewing it.\n" +
                "I drew my first drawing with a colored pencil.\n" +
                "I showed my masterpiece to the grown-ups, and asked them whether the drawing frightened them.\n" +
                "But they answered that no one would be frightened by a hat.\n" +
                "My drawing was not a picture of a hat but a picture of a boa digesting an elephant.\n" +
                "I drew another drawing since the grown-ups were not able to understand it.\n", test.getFullText());
    }



}
