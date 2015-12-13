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
        String sampleText = "�ѱ����� ��쿡�� ���� ū ����ǥ�� �־�� �մϴ�. \"���\"";
        Assert.assertEquals(true,checkFormat.isExistDQ_Marks(sampleText));
        sampleText = "ū ����ǥ�� ���� ��� false�� ����մϴ�.";
        Assert.assertEquals(false,checkFormat.isExistDQ_Marks(sampleText));
        sampleText = "ū ����ǥ�� �� ���� �ƴѰ�� false�� ����մϴ�. ���\"";
        Assert.assertEquals(false,checkFormat.isExistDQ_Marks(sampleText));
    }

    @Test
    public void checkTest2(){
        CheckFormat checkFormat = new CheckFormat();
        String korText = "#1[���� ���Ҵ�. /���ƹ��� �׸��� /������ ��Ű�� /å���� "+
                "/���� ���� ���� �� \"���� �� ��, ���� å���� ������ ��Ű�� ���ƹ��� �׸��� ���Ҵ�.\"]";
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
        String sampleText = "ù��° ����\n" +
                "�ι�° ����\n" +
                "����° ����\n" +
                "�׹�° ����";
        ArrayList<String> result = checkFormat.divideTextLine(sampleText);
        Assert.assertEquals("ù��° ����", result.get(0));
        Assert.assertEquals("�ι�° ����", result.get(1));
        Assert.assertEquals("�׹�° ����", result.get(3));
    }


    @Test
    public void toSceneTest(){
        CheckFormat checkFormat = new CheckFormat();
        String korText = "#1[���� ���Ҵ�. /���ƹ��� �׸��� /������ ��Ű�� /å���� "+
                "/���� ���� ���� �� \"���� �� ��, ���� å���� ������ ��Ű�� ���ƹ��� �׸��� ���Ҵ�.\"]";
        String engText = "#1[I saw /a picture of a boa snake /swallowing an animal /in a book /when I was six years old.]";
        Scene scene = checkFormat.toScene(engText, korText);

        Assert.assertEquals("���� ���Ҵ�.", scene.getKorMeaningUnit().get(0));
        Assert.assertEquals("���ƹ��� �׸���", scene.getKorMeaningUnit().get(1));
        Assert.assertEquals("������ ��Ű��", scene.getKorMeaningUnit().get(2));
        Assert.assertEquals("å����", scene.getKorMeaningUnit().get(3));
        Assert.assertEquals("���� ���� ���� ��", scene.getKorMeaningUnit().get(4));
        Assert.assertEquals("���� �� ��, ���� å���� ������ ��Ű�� ���ƹ��� �׸��� ���Ҵ�.", scene.getKorFullMeaning());

        Assert.assertEquals("I saw", scene.getEngMeaningUnit().get(0));
        Assert.assertEquals("a picture of a boa snake", scene.getEngMeaningUnit().get(1));
        Assert.assertEquals("swallowing an animal", scene.getEngMeaningUnit().get(2));
        Assert.assertEquals("in a book", scene.getEngMeaningUnit().get(3));
        Assert.assertEquals("when I was six years old.", scene.getEngMeaningUnit().get(4));
    }

    @Test
    public void checkFormatTest(){
        CheckFormat checkFormat = new CheckFormat();
        String korText = "#1[���� ���Ҵ�. /���ƹ��� �׸��� /������ ��Ű�� /å���� /���� ���� ���� �� \"���� �� ��, ���� å���� ������ ��Ű�� ���ƹ��� �׸��� ���Ҵ�.\"]\n" +
                "#2[���ƹ���� ���� �ܴ�. /�����޵��� /��ȭ�� ���� /������ ��Ų �ڿ� /������ �ʰ� \"���ƹ���� ������ ������ �ʰ� ��Ų �ڿ�, ��ȭ�� ���ؼ� ������ ���� �Ḹ �ܴ�.\"]\n" +
                "#3[���� �׷ȴ�. /�� ù ��° �׸��� /�����ʷ� \"���� �����ʷ� �� ù ��° �׸��� �׷ȴ�.\"]\n" +
                "#4[���� �����־���. /�� ������ /��鿡�� /�׸��� �׵鿡�� ������. /�� �׸��� �׵��� �ηư� �ϴ����� \"���� �� ������ ��鿡�� �����ְ�, �� �׸��� �׵��� �ηư� �ϴ��� ����Ҵ�.\"]\n" +
                "#5[������ �׵��� ����ߴ�. /�ƹ��� �η������� ���� ���̶�� /���� ������ \"������ �׵��� �ƹ��� ���� ������ �η��������� ���� ���̶�� ����ߴ�.\"]\n" +
                "#6[�� �׸��� /���� �׸��� �ƴ϶�, /���ƹ��� �׸��̾���. /�ڳ����� ��ȭ�ϰ� �ִ�\"�� �׸��� ������ �׸��� �ƴ϶�. �ڳ����� ��ȭ�ϰ� �ִ� ���ƹ��� �׸��̾���.\"]\n" +
                "#7[���� �ٸ� �׸��� �׷ȴ�. /����� �� �� ������ ������ /�װ��� �����ϴ� ���� \"����� �װ��� ������ �� ������ ������ ���� �ٸ� �׸��� �׷ȴ�.\"]\n";

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
