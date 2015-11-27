import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Panda on 2015-11-19.
 */
public class ReadTxt {
    String resourcePath;
    ResourceTxt engBook;
    ResourceTxt korBook;

    public void setResourcePath(String resourcePath) throws FileNotFoundException {
        this.resourcePath = resourcePath;
        openFile();
    }

    private void openFile() throws FileNotFoundException {
        String korResPath = resourcePath + "_english.txt";
        String engResPath = resourcePath + "_korean.txt";
        korBook = openTxt(korResPath);
        engBook = openTxt(engResPath);
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
