import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

/**
 * Created by Panda on 2015-12-07.
 */
public class AbstractJEditorPane extends JEditorPane{
    AbstractJEditorPane(){
        super();
        this.setContentType("text/html;charset=UTF-8");
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
