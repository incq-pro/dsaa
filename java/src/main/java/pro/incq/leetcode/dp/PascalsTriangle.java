package pro.incq.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> row = new ArrayList<>(1);
        row.add(1);
        result.add(row);
        for(int i = 1; i < numRows; i++) {
            List<Integer> preRow = result.get(i - 1);
            row = new ArrayList<>(i + 1);
            row.add(1);
            for(int j = 1; j < i; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt.generate(5));
    }
}
