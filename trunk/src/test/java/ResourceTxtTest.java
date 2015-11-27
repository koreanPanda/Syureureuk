import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Panda on 2015-11-20.
 */
public class ResourceTxtTest {

    ReadTxt readTxt = new ReadTxt();
    String absolutePath = readTxt.getAbsolutePath();
    String resource_path = absolutePath + "\\src\\test\\resources\\TheLittlePrince";


    @Test
    public void ResourceTxtNormalTest() {
        ResourceTxt test = readTxt.getEngBook();
        Assert.assertEquals(7,test.getTextLine());
    }

    @Test
    public void ResourceTxtReadTest() {
        ResourceTxt test = readTxt.getEngBook();
        Assert.assertEquals("I saw a picture of a boa snake swallowing an animal in a book when I was six years old.",
                test.getScene().get(0));
        Assert.assertEquals("Boas sleep through the six months for digestion after they swallow their food without chewing it.",
                test.getScene().get(1));
    }

}
