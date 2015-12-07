import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Panda on 2015-12-07.
 */
public class AbstractJEditorPaneTest {
    @Test
    public void getTextWithoutHTMLText(){
        AbstractJEditorPane abstractJEditorPane = new AbstractJEditorPane();
        abstractJEditorPane.setText("<html>\n" +
                "  <head>\n" +
                "    \n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <font size=\"4\" face=\"돋움\">#1[I saw a picture of a boa snake swallowing an \n" +
                "    animal in a book when I was six years old.]<br>#2[Boas sleep through the \n" +
                "    six months for digestion after they swallow their food without chewing it.]<br>#3[I \n" +
                "    drew my first drawing with a colored pencil.]<br>#4[I showed my \n" +
                "    masterpiece to the grown-ups, and asked them whether the drawing \n" +
                "    frightened them.]<br>#5[But they answered that no one would be frightened \n" +
                "    by a hat.]<br>#6[My drawing was not a picture of a hat but a picture of a \n" +
                "    boa digesting an elephant.]<br>#7[I drew another drawing since the \n" +
                "    grown-ups were not able to understand it.]<br></font>\n" +
                "  </body>\n" +
                "</html>\n");

        Assert.assertEquals("#1[I saw a picture of a boa snake swallowing an animal in a book when I was six years old.]\n" +
                "#2[Boas sleep through the six months for digestion after they swallow their food without chewing it.]\n" +
                "#3[I drew my first drawing with a colored pencil.]\n" +
                "#4[I showed my masterpiece to the grown-ups, and asked them whether the drawing frightened them.]\n" +
                "#5[But they answered that no one would be frightened by a hat.]\n" +
                "#6[My drawing was not a picture of a hat but a picture of a boa digesting an elephant.]\n" +
                "#7[I drew another drawing since the grown-ups were not able to understand it.]",
                abstractJEditorPane.getTextWithoutHTML().trim());
    }
}
