import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Panda on 2015-11-19.
 */
public class ReadTxt {
    String engResPath;
    String korResPath;

    ResourceTxt engBook;
    ResourceTxt korBook;

    public void setEngResPath(String resourcePath) throws FileNotFoundException {
        this.engResPath = resourcePath;
        engBook = openTxt(engResPath);
    }
    public void setKorResPath(String resourcePath) throws FileNotFoundException {
        this.korResPath = resourcePath;
        korBook = openTxt(korResPath);
    }

    private ResourceTxt openTxt(String path) throws FileNotFoundException {
        ResourceTxt buffer = null;
        buffer = new ResourceTxt(new FileReader(path));
        return buffer;
    }


    public ResourceTxt getEngBook(){
        return engBook;
    }

    public ResourceTxt getKorBook(){
        return korBook;
    }

    public String getAbsolutePath(){
        File path = new File("");
        String absolutePath = path.getAbsolutePath();
        path.delete();
        return absolutePath;
    }


}
