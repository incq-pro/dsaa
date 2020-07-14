package me.zqpro.dsaa.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author yun.516@gmail.com
 */
public class ACAutoMataTest {
    ACAutoMata acAutoMata;
    String[] patterns = {"at", "art", "oars", "soar", "Fxtec Pro1", "谷歌Pixel"};

    @Before
    public void setUp() {
        if (acAutoMata == null) {
            acAutoMata = new ACAutoMata();
            for (String pattern : patterns) {
                acAutoMata.insert(pattern);
            }
            acAutoMata.buildFailurePointer();
        }
    }

    @Test
    public void test() {
        String text1 = "soarsoars";
        assertTrue(acAutoMata.match(text1));
        String text2 = "一家总部位于伦敦的公司Fxtex在MWC上就推出了一款名为Fxtec Pro1的手机，该机最大的亮点就是采用了侧滑式全键盘设计。DxOMark年度总榜发布 华为P20 Pro/谷歌Pixel 3争冠";
        assertTrue(acAutoMata.match(text2));
    }
}