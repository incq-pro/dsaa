package tree;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class E10Test {

    @Test
    public void list() throws IOException {
        E10 e = new E10();
        e.list(new File(".").getCanonicalPath());
    }
}