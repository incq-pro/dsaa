package me.zqpro.dsaa.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * @author yun.516@gmail.com
 */
public class ACAutoMata2Test {

    @Test
    public void test() {
        ACAutoMata2 autoMata = new ACAutoMata2();
        autoMata.addAll(Arrays.asList("at", "art", "oars", "soar", "Fxtec Pro1", "谷歌Pixel"));
        String text1 = "soarsoars";
        assertTrue(autoMata.match(text1));
        String text2 = "一家总部位于伦敦的公司Fxtex在MWC上就推出了一款名为Fxtec Pro1的手机，该机最大的亮点就是采用了侧滑式全键盘设计。DxOMark年度总榜发布 华为P20 Pro/谷歌Pixel 3争冠";
        assertTrue(autoMata.match(text2));
    }
}