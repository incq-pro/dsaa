package me.zqpro.dsaa.linear.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author yun.516@gmail.com
 */
public class SimpleBrowserTest {
    @Test
    public void test() {
        String url1 = "http://www.google.com";
        String url2 = "http://www.qq.com";
        String url3 = "http://www.bing.com";
        String url4 = "http://www.github.com";
        String url5 = "http://www.infoq.cn";

        SimpleBrowser b1 = new SimpleBrowser();
        // url1
        b1.open(url1);
        assertEquals(url1, b1.current());

        // url1->url2
        b1.open(url2);
        assertEquals(url2, b1.current());

        // url1->url2->url3
        b1.open(url3);
        assertEquals(url3, b1.current());

        // url1->url2
        b1.goBack();
        assertEquals(url2, b1.current());

        // url1
        b1.goBack();
        assertEquals(url1, b1.current());

        // url1->url2
        b1.goForward();
        assertEquals(url2, b1.current());

        // url1->url2->url4
        b1.open(url4);
        assertEquals(url4, b1.current());

        // url1->url2
        b1.goBack();
        assertEquals(url2, b1.current());

        b1.goForward();
        assertEquals(url4, b1.current());

    }

}