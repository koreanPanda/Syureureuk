import javax.swing.*;
import java.awt.*;

/**
 * Created by Panda on 2015-12-07.
 */
public class AbstractJEditorPane extends JEditorPane{
    AbstractJEditorPane(){
        super();
        this.setContentType("text/html");
        this.setMargin(new Insets(10,10,10,10));
    }
}
