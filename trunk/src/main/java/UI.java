import javax.swing.*;

/**
 * Created by Panda on 2015-11-27.
 */
public class UI extends JFrame{
    public UI(){
        super("리소스 제작 툴");
        super.setSize(1000,600);
        super.setLocationRelativeTo(null);
        componentSetting();
        super.setLayout(null);
        super.setResizable(false);
    }
    public static void main(String[] args){
        UI ui = new UI();
        ui.setVisible(true);
    }

    private void componentSetting(){
        JButton btn_textInsertMode = new JButton("텍스트 입력 모드");
        JButton btn_delimitersAddMode = new JButton("구분기호 생성 모드");
        JButton btn_importKorText = new JButton("+");
        JButton btn_importEngText = new JButton("+");
        JButton btn_export = new JButton("EXPORT");

        JTextArea ta_korText = new JTextArea();
        JTextArea ta_engText = new JTextArea();

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

        ta_korText.setSize(850,200);
        ta_korText.setLocation(100,80);
        ta_engText.setSize(850,200);
        ta_engText.setLocation(100,300);

        this.add(btn_textInsertMode);
        this.add(btn_delimitersAddMode);
        this.add(btn_export);
        this.add(btn_importEngText);
        this.add(btn_importKorText);

        this.add(ta_engText);
        this.add(ta_korText);
    }
}
