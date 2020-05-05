package me.zqpro.dsaa.tree;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class E10Test {

    @Test
    public void list() throws IOException {
        tree.E10 e = new tree.E10();
        e.list(new File(".").getCanonicalPath());
    }
}