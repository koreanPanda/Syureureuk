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
    ConvertToXml DO = new ConvertToXml();

    public UI(){
        super("���ҽ� ���� ��");
        super.setSize(1000,600);
        super.setLocationRelativeTo(null);
        componentSetting();
        super.setLayout(null);
        super.setResizable(false);
    }

    private void componentSetting(){
        JButton btn_textInsertMode = new JButton("�ؽ�Ʈ �Է� ���");
        JButton btn_delimitersAddMode = new JButton("���� �˻�");
        JButton btn_importKorText = new JButton("+");
        JButton btn_importEngText = new JButton("+");
        final JButton btn_export = new JButton("EXPORT");

        final AbstractJEditorPane ta_korText = new AbstractJEditorPane();
        final AbstractJEditorPane ta_engText = new AbstractJEditorPane();
        JScrollPane jsp_korText = new JScrollPane(ta_korText);
        JScrollPane jsp_engText = new JScrollPane(ta_engText);

        final JLabel jl_error = new JLabel();
        jl_error.setText("");
        // location //
        //////////////////////////////////////////////////////////////
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

        jl_error.setSize(700,33);
        jl_error.setLocation(100,520);
        jl_error.setHorizontalAlignment(JLabel.CENTER);
        //////////////////////////////////////////////////////////////

        this.add(btn_textInsertMode);

        btn_delimitersAddMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CheckFormat checkFormat = new CheckFormat();
                String engText = ta_engText.getTextWithoutHTML();
                String korText = ta_korText.getTextWithoutHTML();
                if(checkFormat.checkFormat(engText, korText)){
                    DO.setScenes(checkFormat.toScenes(engText, korText));
                    btn_export.setEnabled(true);
                }
                jl_error.setText(checkFormat.getErrorList());
            }
        });

        this.add(btn_delimitersAddMode);

        btn_export.setEnabled(false);

        btn_export.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(superFrame, "txt���� ����", FileDialog.SAVE);
                fd.setVisible(true);
                DO.exportToXml(fd.getDirectory() + fd.getFile());
            }
        });

        this.add(btn_export);

        btn_importEngText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(superFrame, "txt���� ����", FileDialog.LOAD);
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
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(superFrame, "txt���� ����", FileDialog.LOAD);
                fd.setVisible(true);
                ReadTxt engTxt = new ReadTxt();
                try {
                    engTxt.setKorResPath(fd.getDirectory() + fd.getFile());
                    ta_korText.setText(engTxt.getKorBook().getFullText());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.add(btn_importEngText);
        this.add(btn_importKorText);

        this.add(jsp_engText);
        this.add(jsp_korText);

        this.add(jl_error);

    }
}
