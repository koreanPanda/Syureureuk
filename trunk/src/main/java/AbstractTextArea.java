import javax.swing.*;
import java.awt.*;

/**
 * Created by Panda on 2015-12-07.
 */
public class AbstractTextArea extends JTextArea{
    AbstractTextArea(){
        super();
        this.setLineWrap(true);
        this.setMargin(new Insets(10,10,10,10));
        this.setFont(new Font("doteum", Font.TRUETYPE_FONT ,15));
    }
}
