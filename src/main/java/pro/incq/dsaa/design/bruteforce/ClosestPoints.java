package pro.incq.dsaa.design.bruteforce;

import pro.incq.dsaa.design.common.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 平面集合上的最近点 O(n^2)
 *
 * @author pro.incq
 * @date 2021-03-18
 */
public class ClosestPoints {
    public List<Point> closestPoints(List<Point> points) {
        Point p1 = null;
        Point p2 = null;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            Point tempI = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                Point tempJ = points.get(j);
                int d = (tempI.x - tempJ.x) * (tempI.x - tempJ.x) + (tempI.y - tempJ.y) * (tempI.y - tempJ.y);
                if (d < minDistance) {
                    minDistance = d;
                    p1 = tempI;
                    p2 = tempJ;
                }
            }
        }
        return Arrays.asList(p1, p2);
    }

    public static void main(String[] args) {
        ClosestPoints cp = new ClosestPoints();
        List<Point> points = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            points.add(new Point(i, 2 * i));
        }
        System.out.println(cp.closestPoints(points));
    }
}
