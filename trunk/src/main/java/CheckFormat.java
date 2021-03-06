import java.util.ArrayList;

/**
 * Created by Panda on 2015-12-07.
        */
public class CheckFormat {
    String errorList = "";
    /**
     * isExistDoubleQuotationMarks(string)
     * if text has twoDoubleQuotationMarks return true
     * else false
     * @param text
     * @return boolean
     */
    public boolean isExistDQ_Marks(String text) {
        int flag = countCharacterInSentence(text,'"');
        if((flag != 0) && (flag % 2 == 0))
            return true;
        else
            return false;
    }

    public int countCharacterInSentence(String text, char one_char){
        int textLength = text.length();
        int result = 0;
        for(int i=0;i<textLength;i++){
            if(text.charAt(i) == one_char){
                result++;
            }
        }

        return result;
    }


    public boolean isSameCountSlashInTwoSentence(String first, String second) {
        // 두문장의 slash의 갯수가 일치할때 true
        if( countCharacterInSentence(first, '/') ==
            countCharacterInSentence(second, '/')){
            return true;
        }
        else{
            return false;
        }
    }

    public int getLineCount(String text){
        String sample = text.trim();
        return countCharacterInSentence(sample, '\n');
    }

    public boolean isExistDQ_Marks_AllLine(String korText){
        int textLength = korText.length();
        int result = 0;
        int startIdx = 0;
        int lastIdx = -1;
        String tempString = "";
        for(int i=0;i<textLength;i++){
            if(korText.charAt(i) == '\n' || i == textLength-1){
                lastIdx = i;
                tempString = korText.substring(startIdx,lastIdx);
                startIdx = lastIdx+1;
                if(!isExistDQ_Marks(tempString)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isExistSlash_AllLine(String text){
        int textLength = text.length();
        int result = 0;
        int startIdx = 0;
        int lastIdx = -1;
        String tempString = "";
        for(int i=0;i<textLength;i++){
            if(text.charAt(i) == '\n'|| i == textLength-1){
                lastIdx = i;
                tempString = text.substring(startIdx,lastIdx);
                startIdx = lastIdx+1;
                if(countCharacterInSentence(tempString,'/') == 0 ){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean checkFormat(String engText, String korText){
        // 줄수(Scene의 갯수가 같은지 확인)
        if (getLineCount(engText) != getLineCount(korText)){
            this.setErrorList("영어리소스와 한글리소스의 줄수가 맞지 않습니다.");
            return false;
        }
        // 각 한글의 줄별로 ""가 짝에 맞게 있는지 확인
        else if (!isExistDQ_Marks_AllLine(korText)){
            this.setErrorList("한글리소스에서 따옴표가 없는 문장이 있습니다.");
            return false;
        }
        // 한글리소스에 줄별로 /가 있는지 확인
        else if (!isExistSlash_AllLine(engText)){
            this.setErrorList("영어리소스에서 '/'가 없는 문장이 있습니다.");
            return false;
        }
        // 영어리소스에 줄별로 /가 있는지 확인
        else if (!isExistSlash_AllLine(korText)){
            this.setErrorList("한글리소스에서 '/'가 없는 문장이 있습니다.");
            return false;
        }
        // slash의 갯수가 맞는지 확인
        else if (!isSameCountSlashInTwoSentence(engText, korText)){
            this.setErrorList("/ 의 갯수가 일치하지 않습니다.");
            return false;
        }
        // 다맞으면 트루 하나라도 틀리면 false
        else{
            this.setErrorList("양식에 맞습니다. 이제 출력이 가능합니다.");
            return true;
        }
    }

//    public String getTextLine(String text, int idx){
//        int textLength = text.length();
//        int flag = 0;
//        int startIdx = 0;
//        int lastIdx = -1;
//        for(int i = 0 ; i <= textLength ; i++){
//            if(i == textLength || text.charAt(i) == '\n'){
//                flag++;
//                startIdx = lastIdx+1;
//                lastIdx = i;
//            }
//            if (flag == idx){
//                break;
//            }
//        }
//        return text.substring(startIdx,lastIdx);
//    }

    public ArrayList<String> divideTextLine(String text){
        int textLength = text.length();
        int startIdx = 0;
        int lastIdx = -1;
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0 ; i <= textLength ; i++){
            if(i == textLength || text.charAt(i) == '\n'){
                lastIdx = i;
                result.add(text.substring(startIdx,lastIdx));
                startIdx = lastIdx+1;
            }
        }
        return result;
    }

    public ArrayList<Scene> toScenes(String engText, String korText){
        ArrayList<String> engTexts = divideTextLine(engText);
        ArrayList<String> korTexts = divideTextLine(korText);
        ArrayList<Scene> result = new ArrayList<Scene>();

        int sceneSize = engTexts.size();
        for(int i=0;i<sceneSize;i++){
            result.add(toScene(engTexts.get(i), korTexts.get(i)));
        }

        return result;
    }

    public Scene toScene(String engText, String korText){
        int textLength = korText.length();
        Scene result = new Scene();
        int startIdx = -1;
        int lastIdx = -1;
        int startDQIdx = -1;
        int endDQIdx = -1;
        ArrayList<Integer> delimeterIdx = new ArrayList<Integer>();

        for(int i = 0 ; i < textLength ; i++){
            if(korText.charAt(i) == '['){
                startIdx = i;
            }
            else if(korText.charAt(i) == '/'){
                delimeterIdx.add(i);
            }
            else if(korText.charAt(i) == '"'){
                if (startDQIdx == -1){
                    startDQIdx = i;
                }else if(endDQIdx == -1){
                    endDQIdx = i;
                }else {
                    startDQIdx = endDQIdx;
                    endDQIdx = i;
                }
            }
//            if(korText.charAt(i) == ']'){
//                lastIdx = i;
//            }
        }
        int delimeterSize = delimeterIdx.size();
        result.addKorMeaningUnit(
                korText.substring(startIdx + 1,delimeterIdx.get(0)).trim());
        for(int i = 0 ; i < delimeterSize - 1 ; i++){
            result.addKorMeaningUnit(
                    korText.substring(delimeterIdx.get(i) + 1,delimeterIdx.get(i+1)).trim());
        }
        result.addKorMeaningUnit(
                korText.substring(delimeterIdx.get(delimeterSize - 1) + 1,startDQIdx).trim()
                );
        result.setKorFullMeaning(korText.substring(startDQIdx+1,endDQIdx).trim());

        textLength = engText.length();
        delimeterIdx.clear();
        for(int i = 0 ; i < textLength ; i++){
            if(engText.charAt(i) == '['){
                startIdx = i;
            }
            if(engText.charAt(i) == '/'){
                delimeterIdx.add(i);
            }
            if(engText.charAt(i) == ']'){
                lastIdx = i;
            }
        }

        delimeterSize = delimeterIdx.size();
        result.addEngMeaningUnit(
                engText.substring(startIdx + 1,delimeterIdx.get(0)).trim());
        for(int i = 0 ; i < delimeterSize - 1 ; i++){
            result.addEngMeaningUnit(
                    engText.substring(delimeterIdx.get(i) + 1,delimeterIdx.get(i+1)).trim());
        }
        result.addEngMeaningUnit(
                engText.substring(delimeterIdx.get(delimeterSize - 1) + 1,lastIdx).trim()
        );

        return result;
    }

    public void setErrorList(String cause){
        this.errorList = cause;
    }
    public String getErrorList(){
        return errorList;
    }
}
