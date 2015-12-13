
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015-12-13.
 *
 * JDOM 1.1.3을 사용하였습니다.
 * http://shonm.tistory.com/377 를 참고하였습니다.
 * JDOM의 라이센스는 아파치와 흡사합니다.
 */
public class ConvertToXml {
    ArrayList<Scene> scenes= new ArrayList<Scene>();

    public void setScenes(ArrayList<Scene> scenes) {
        this.scenes = scenes;
    }


    public void exportToXml(){
        Document doc = new Document();

        Element root = new Element("generator");

        Element pack = new Element("package");

        Element pack_name = new Element("package-name");

        root.addContent(pack);//root element 의 하위 element 를 만들기
        pack.addContent(pack_name); //package element 의 하위로 package-name 만들기

        pack_name.setText("com.oss_project.shere");
        //package-name element 에 value 값을 text 로 넣어 주기

        doc.setRootElement(root);

        try {
            FileOutputStream out = new FileOutputStream("d:\\test.xml");
            //xml 파일을 떨구기 위한 경로와 파일 이름 지정해 주기
            XMLOutputter serializer = new XMLOutputter();

            Format f = serializer.getFormat();
            f.setEncoding("UTF-8");
            //encoding 타입을 UTF-8 로 설정
            f.setIndent(" ");
            f.setLineSeparator("\r\n");
            f.setTextMode(Format.TextMode.TRIM);
            serializer.setFormat(f);

            serializer.output(doc, out);
            out.flush();
            out.close();

            //String 으로 xml 출력
            // XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat().setEncoding("UTF-8")) ;
            // System.out.println(outputter.outputString(doc));
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
