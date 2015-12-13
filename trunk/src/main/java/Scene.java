import java.util.ArrayList;

/**
 * Created by Administrator on 2015-12-12.
 */
public class Scene {
    ArrayList<String> korMeaningUnit = new ArrayList<String>();
    ArrayList<String> engMeaningUnit = new ArrayList<String>();
    String korFullMeaning = "";

    public ArrayList<String> getEngMeaningUnit() {
        return engMeaningUnit;
    }

    public String getKorFullMeaning() {
        return korFullMeaning;
    }

    public ArrayList<String> getKorMeaningUnit() {
        return korMeaningUnit;
    }

    public void addKorMeaningUnit(String meaningUnit ){
        korMeaningUnit.add(meaningUnit);
    }

    public void addEngMeaningUnit(String meaningUnit ){
        engMeaningUnit.add(meaningUnit);
    }

    public void setKorMeaningUnit(ArrayList<String> korMeaningUnit) {
        this.korMeaningUnit = korMeaningUnit;
    }

    public void setEngMeaningUnit(ArrayList<String> engMeaningUnit) {
        this.engMeaningUnit = engMeaningUnit;
    }

    public void setKorFullMeaning(String korFullMeaning) {
        this.korFullMeaning = korFullMeaning;
    }

    public int getKorMeaningUnitCounts(){
        return korMeaningUnit.size();
    }
    public int getEngMeaningUnitCounts(){
        return engMeaningUnit.size();
    }
}
