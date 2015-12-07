import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by Panda on 2015-11-20.
 */
public class ResourceTxt extends BufferedReader{

    ArrayList<String> scene = new ArrayList<String>();
    String temp;
    int textLine = 0;
    public ResourceTxt(Reader in) {
        super(in);
        init();
    }

    public void init(){
        try {
            while((temp = super.readLine()) != null ){
                scene.add(temp);
                textLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}

    public int getTextLine(){
        return textLine;
    }

    public String getSceneString(int sceneNumber){
        return scene.get(sceneNumber);
    }

    public String getFullText(){
        StringBuilder fullText = new StringBuilder("");
        int i = 0;
        String countUnits = "";
        fullText.append("<font size = 4 face=\"돋움\">");
        for(i = 0 ; i < textLine ;i++){
            fullText.append("<p>");
            countUnits = Integer.toString( (i + 1) );
            fullText.append("#");
            fullText.append(countUnits);
            fullText.append("[");
            fullText.append(this.getSceneString(i));
            fullText.append("]");
            fullText.append("</p>");
        }
        fullText.append("</font>");
        return fullText.toString();
    }


}
