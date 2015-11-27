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
    public ArrayList<String> getScene(){
        return scene;
    }


}
