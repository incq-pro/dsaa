package pro.incq.dsaa.design.bruteforce;

import pro.incq.dsaa.design.common.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 凸包
 *
 * @author pro.incq
 * @date 2021-03-18
 */
public class ConvexHull {
    public Set<Point> convexHull(List<Point> points) {
        Set<Point> result = new HashSet<>();
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (check(i, j, points)) {
                    result.add(points.get(i));
                    result.add(points.get(j));
                }
            }
        }
        return result;
    }

    private boolean check(int i, int j, List<Point> points) {
        Point pi = points.get(i);
        Point pj = points.get(j);
        if (i == j || pi.equals(pj)) {
            return false;
        }
        int a = pj.y - pi.y;
        int b = pi.x - pj.x;
        int c = pi.x * pj.y - pj.x * pi.y;
        Boolean flag = null;
        for (int k = 0; k < points.size(); k++) {
            if (k == i || k == j) {
                continue;
            }
            Point pk = points.get(k);
            if (flag == null) {
                flag = (a * pk.x + b * pk.y) > c;
            } else {
                if (flag != ((a * pk.x + b * pk.y) > c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 5));
        points.add(new Point(4, 3));
        points.add(new Point(5, 5));
        points.add(new Point(9, 9));
        points.add(new Point(10, 0));

        points.add(new Point(1, 1));
        points.add(new Point(1, 2));
        points.add(new Point(1, 3));
        points.add(new Point(1, 4));
        points.add(new Point(2, 1));
        points.add(new Point(2, 2));
        points.add(new Point(2, 3));
        points.add(new Point(2, 4));
        points.add(new Point(3, 1));

        ConvexHull ch = new ConvexHull();
        long now = System.currentTimeMillis();
        System.out.println(ch.convexHull(points));
        System.out.println(System.currentTimeMillis() - now);
    }
}
