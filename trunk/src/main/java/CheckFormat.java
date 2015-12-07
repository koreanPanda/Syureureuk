/**
 * Created by Panda on 2015-12-07.
        */
public class CheckFormat {

    /**
     * isExistDoubleQuotationMarks(string)
     * if text has twoDoubleQuotationMarks return true
     * else false
     * @param text
     * @return boolean
     */
    public boolean isExistDQ_Marks(String text) {
        int flag = countCharacterInSentence(text,'"');
        if(flag == 2)
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
}
