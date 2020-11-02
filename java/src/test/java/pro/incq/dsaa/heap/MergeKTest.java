package pro.incq.dsaa.heap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class MergeKTest {

    @Test
    public void merge() {
        int[][] datas = {
                {0, 1, 4, 7},
                {2, 5, 8, 9},
                {3, 6},
        };
        MergeK mergeK = new MergeK();
        int[] ret = mergeK.merge(datas);
        for (int i = 0; i < 10; i++) {
            assertEquals(i, ret[i]);
        }
    }
}