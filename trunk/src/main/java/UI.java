import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Panda on 2015-11-27.
 */
public class UI extends JFrame{
    Frame superFrame = this;
    public UI(){
        super("리소스 제작 툴");
        super.setSize(1000,600);
        super.setLocationRelativeTo(null);
        componentSetting();
        super.setLayout(null);
        super.setResizable(false);
    }

    private void componentSetting(){
        JButton btn_textInsertMode = new JButton("텍스트 입력 모드");
        JButton btn_delimitersAddMode = new JButton("구분기호 생성 모드");
        JButton btn_importKorText = new JButton("+");
        JButton btn_importEngText = new JButton("+");
        JButton btn_export = new JButton("EXPORT");

        final AbstractJEditorPane ta_korText = new AbstractJEditorPane();
        final AbstractJEditorPane ta_engText = new AbstractJEditorPane();
        JScrollPane jsp_korText = new JScrollPane(ta_korText);
        JScrollPane jsp_engText = new JScrollPane(ta_engText);


        btn_textInsertMode.setSize(415,33);
        btn_textInsertMode.setLocation(100,30);
        btn_delimitersAddMode.setSize(415,33);
        btn_delimitersAddMode.setLocation(535,30);
        btn_export.setSize(100,33);
        btn_export.setLocation(840,520);
        btn_importEngText.setSize(33, 200);
        btn_importEngText.setLocation(50,80);
        btn_importKorText.setSize(33, 200);
        btn_importKorText.setLocation(50,300);

        jsp_engText.setSize(850,200);
        jsp_engText.setLocation(100,80);
        jsp_korText.setSize(850,200);
        jsp_korText.setLocation(100,300);
        //////////////////////////////////////////////////////////////

        this.add(btn_textInsertMode);
        this.add(btn_delimitersAddMode);
        this.add(btn_export);

        btn_importEngText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File temp = null;
                FileDialog fd = new FileDialog(superFrame, "txt파일 열기", FileDialog.LOAD);
                fd.setVisible(true);
                ReadTxt engTxt = new ReadTxt();
                try {
                    engTxt.setEngResPath(fd.getDirectory() + fd.getFile());
                    ta_engText.setText(engTxt.getEngBook().getFullText());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btn_importKorText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File temp = null;
                FileDialog fd = new FileDialog(superFrame, "txt파일 열기", FileDialog.LOAD);
                fd.setVisible(true);
                ReadTxt engTxt = new ReadTxt();
                try {
                    engTxt.setKorResPath(fd.getDirectory() + fd.getFile());
                    ta_korText.setText(engTxt.getKorBook().getFullText());
                    System.out.print(ta_korText.getText());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.add(btn_importEngText);
        this.add(btn_importKorText);

        this.add(jsp_engText);
        this.add(jsp_korText);

    }
}
