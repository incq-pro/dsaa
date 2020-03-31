package me.zqpro.dsaa.hash;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class MyHashMapTest {
    @Test
    public void test() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        assertNull(myHashMap.get(""));
        assertNull(myHashMap.get("1"));

        String k1 = "1";
        String v1 = "1";
        myHashMap.put(k1, v1);
        assertEquals(v1, myHashMap.get(k1));
        myHashMap.remove(k1);
        assertNull(myHashMap.get(k1));

        for (int i = 0; i < 100; i++) {
            myHashMap.put("" + i, "" + i);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(myHashMap.get("" + i));
        }
    }
}