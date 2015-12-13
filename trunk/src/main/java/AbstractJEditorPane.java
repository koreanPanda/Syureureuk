import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Panda on 2015-12-07.
 */
public class AbstractJEditorPane extends JEditorPane{
    ArrayList<String> contents = new ArrayList<String>();

    AbstractJEditorPane(){
        super();
        this.setContentType("text/html");
        this.setMargin(new Insets(10,10,10,10));
    }

    public String getTextWithoutHTML(){
        String result = "";
        try {
            result = this.getDocument().getText(0, this.getDocument().getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return result.replace("] #","]\n#").trim();
    }
}
