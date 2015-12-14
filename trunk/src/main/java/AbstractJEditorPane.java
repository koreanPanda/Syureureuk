import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Panda on 2015-12-07.
 */
//public class AbstractJEditorPane extends JEditorPane implements MouseListener {
public class AbstractJEditorPane extends JEditorPane{
    ArrayList<String> contents = new ArrayList<String>();

    AbstractJEditorPane(){
        super();
        this.setContentType("text/html");
        this.setMargin(new Insets(10,10,10,10));
//        this.addMouseListener(this);
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

//    public void mouseClicked(MouseEvent e) {
//        int pos = this.getCaretPosition();
//        String temp = this.getTextWithoutHTML();
//        StringBuilder builder = new StringBuilder();
//        builder.append(temp,0,pos);
//        builder.append('/');
//        builder.append(temp,pos,temp.length());
//        this.setText(builder.toString());
//    }
//
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    public void mouseExited(MouseEvent e) {
//
//    }
}
