
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.FileWriter;
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


    public void exportToXml(String filePath){;
        try {
            Document doc = new Document();

            Element root = new Element("resources");

            doc.setRootElement(root);

            int sceneSize = scenes.size();
            for(int scene_idx = 0; scene_idx< sceneSize; scene_idx++){
                Scene tempScene = scenes.get(scene_idx);

                Element scene = new Element("scene");
                String scene_id = (scene_idx + 1) + "";
                scene.setAttribute(new Attribute("id", scene_id));
                Element eng_txt = new Element("eng_txt");
                Element kor_txt = new Element("kor_txt");

                int meaningUnitSize = tempScene.getKorMeaningUnitCounts();
                for(int meaningUnit_idx = 0; meaningUnit_idx<meaningUnitSize; meaningUnit_idx++){
                    Element string = new Element("string");
                    StringBuilder kor_name = new StringBuilder("");
                    kor_name.append("scene");
                    kor_name.append(scene_id);
                    kor_name.append("_kor_");
                    kor_name.append(meaningUnit_idx);
                    string.setName(kor_name.toString());
                    string.setText(tempScene.getKorMeaningUnit().get(meaningUnit_idx));
                    kor_txt.addContent(string);
                }

                meaningUnitSize = tempScene.getEngMeaningUnitCounts();
                for(int meaningUnit_idx = 0; meaningUnit_idx<meaningUnitSize; meaningUnit_idx++){
                    Element string = new Element("string");
                    StringBuilder eng_name = new StringBuilder("");
                    eng_name.append("scene");
                    eng_name.append(scene_id);
                    eng_name.append("_eng_");
                    eng_name.append(meaningUnit_idx);

                    string.setName(eng_name.toString());
                    string.setText(tempScene.getEngMeaningUnit().get(meaningUnit_idx));
                    eng_txt.addContent(string);
                }

                Element string = new Element("string");
                StringBuilder kor_fulltext_name = new StringBuilder("");
                kor_fulltext_name.append("scene");
                kor_fulltext_name.append(scene_id);
                kor_fulltext_name.append("_complete");
                string.setName(kor_fulltext_name.toString());
                string.setText(tempScene.getKorFullMeaning());
                kor_txt.addContent(string);

                scene.addContent(eng_txt);
                scene.addContent(kor_txt);
                doc.getRootElement().addContent(scene);
            }

            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
