import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Panda on 2015-12-07.
 */
public class CheckFormatTest {

    @Test
    public void checkTest1(){
        CheckFormat checkFormat = new CheckFormat();
        String sampleText = "한국어의 경우에는 끝에 큰 따옴표가 있어야 합니다. \"결론\"";
        Assert.assertEquals(true,checkFormat.isExistDQ_Marks(sampleText));
        sampleText = "큰 따옴표가 없는 경우 false를 출력합니다.";
        Assert.assertEquals(false,checkFormat.isExistDQ_Marks(sampleText));
        sampleText = "큰 따옴표가 두 개가 아닌경우 false를 출력합니다. 결론\"";
        Assert.assertEquals(false,checkFormat.isExistDQ_Marks(sampleText));
    }

    @Test
    public void checkTest2(){
        CheckFormat checkFormat = new CheckFormat();
        String korText = "#1[나는 보았다. /보아뱀의 그림을 /동물을 삼키는 /책에서 "+
                "/내가 여섯 살일 때 \"여섯 살 때, 나는 책에서 동물을 삼키는 보아뱀의 그림을 보았다.\"]";
        String engText = "#1[I saw /a picture of a boa snake /swallowing an animal /in a book /when I was six years old.]";
        boolean result = checkFormat.isSameCountSlashInTwoSentence(korText,engText);
        Assert.assertEquals(true, result);

        String engText2 = "#1[I saw a picture of a boa snake /swallowing an animal /in a book /when I was six years old.]";
        result = checkFormat.isSameCountSlashInTwoSentence(korText,engText2);
        Assert.assertEquals(false, result);
    }

    @Test
    public void checkDivideTextLineTest(){
        CheckFormat checkFormat = new CheckFormat();
        String sampleText = "첫번째 문장\n" +
                "두번째 문장\n" +
                "세번째 문장\n" +
                "네번째 문장";
        ArrayList<String> result = checkFormat.divideTextLine(sampleText);
        Assert.assertEquals("첫번째 문장", result.get(0));
        Assert.assertEquals("두번째 문장", result.get(1));
        Assert.assertEquals("네번째 문장", result.get(3));
    }


    @Test
    public void toSceneTest(){
        CheckFormat checkFormat = new CheckFormat();
        String korText = "#1[나는 보았다. /보아뱀의 그림을 /동물을 삼키는 /책에서 "+
                "/내가 여섯 살일 때 \"여섯 살 때, 나는 책에서 동물을 삼키는 보아뱀의 그림을 보았다.\"]";
        String engText = "#1[I saw /a picture of a boa snake /swallowing an animal /in a book /when I was six years old.]";
        Scene scene = checkFormat.toScene(engText, korText);

        Assert.assertEquals("나는 보았다.", scene.getKorMeaningUnit().get(0));
        Assert.assertEquals("보아뱀의 그림을", scene.getKorMeaningUnit().get(1));
        Assert.assertEquals("동물을 삼키는", scene.getKorMeaningUnit().get(2));
        Assert.assertEquals("책에서", scene.getKorMeaningUnit().get(3));
        Assert.assertEquals("내가 여섯 살일 때", scene.getKorMeaningUnit().get(4));
        Assert.assertEquals("여섯 살 때, 나는 책에서 동물을 삼키는 보아뱀의 그림을 보았다.", scene.getKorFullMeaning());

        Assert.assertEquals("I saw", scene.getEngMeaningUnit().get(0));
        Assert.assertEquals("a picture of a boa snake", scene.getEngMeaningUnit().get(1));
        Assert.assertEquals("swallowing an animal", scene.getEngMeaningUnit().get(2));
        Assert.assertEquals("in a book", scene.getEngMeaningUnit().get(3));
        Assert.assertEquals("when I was six years old.", scene.getEngMeaningUnit().get(4));
    }

    @Test
    public void checkFormatTest(){
        CheckFormat checkFormat = new CheckFormat();
        String korText = "#1[나는 보았다. /보아뱀의 그림을 /동물을 삼키는 /책에서 /내가 여섯 살일 때 \"여섯 살 때, 나는 책에서 동물을 삼키는 보아뱀의 그림을 보았다.\"]\n" +
                "#2[보아뱀들은 잠을 잔다. /여섯달동안 /소화를 위해 /음식을 삼킨 뒤에 /씹지도 않고 \"보아뱀들은 음식을 씹지도 않고 삼킨 뒤에, 소화를 위해서 여섯달 동안 잠만 잔다.\"]\n" +
                "#3[나는 그렸다. /내 첫 번째 그림을 /색연필로 \"나는 색연필로 내 첫 번째 그림을 그렸다.\"]\n" +
                "#4[나는 보여주었다. /내 걸작을 /어른들에게 /그리고 그들에게 물었다. /그 그림이 그들을 두렵게 하는지를 \"나는 내 걸작을 어른들에게 보여주고, 그 그림이 그들을 두렵게 하는지 물어보았다.\"]\n" +
                "#5[하지만 그들은 대답했다. /아무도 두려워하지 않을 것이라고 /모자 때문에 \"하지만 그들은 아무도 모자 때문에 두려워하지는 않을 것이라고 대답했다.\"]\n" +
                "#6[내 그림은 /모자 그림이 아니라, /보아뱀의 그림이었다. /코끼리를 소화하고 있는\"내 그림은 모자의 그림이 아니라. 코끼리를 소화하고 있는 보아뱀의 그림이었다.\"]\n" +
                "#7[나는 다른 그림을 그렸다. /어른들이 할 수 없었기 때문에 /그것을 이해하는 것을 \"어른들이 그것을 이해할 수 없었기 때문에 나는 다른 그림을 그렸다.\"]\n";

        String engText = "#1[I saw /a picture of a boa snake /swallowing an animal /in a book /when I was six years old.]\n" +
                "#2[Boas sleep /through the six months /for digestion /after they swallow their food /without chewing it.]\n" +
                "#3[I drew /my first drawing /with a colored pencil.]\n" +
                "#4[I showed /my masterpiece /to the grown-ups, /and asked them /whether the drawing frightened them.]\n" +
                "#5[But they answered /that no one would be frightened /by a hat.]\n" +
                "#6[My drawing /was not a picture of a hat /but a picture of a boa /digesting an elephant.]\n" +
                "#7[I drew another drawing /since the grown-ups were not able /to understand it.]\n";

        Assert.assertTrue(checkFormat.checkFormat(engText, korText));
    }


}
