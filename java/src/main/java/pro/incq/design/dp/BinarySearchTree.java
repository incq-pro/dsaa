package pro.incq.design.dp;

import org.apache.commons.lang3.tuple.Pair;
import pro.incq.design.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author incq-pro
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        int[] nodes = new int[]{1, 2, 3, 4};
        double[] probability = new double[]{0.1, 0.2, 0.4, 0.3};
//        System.out.println(calcAvgSearchSteps(nodes, probability, root));

        System.out.println(bestBinarySearchTree(nodes, probability));
    }


    public static double calcAvgSearchSteps(int[] nodes, double[] probability, TreeNode root) {
        Map<Integer, Double> keyProbabilityMap = new HashMap<>(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            keyProbabilityMap.put(nodes[i], probability[i]);
        }

        return doCalcAvgSearchSteps(root, 1, keyProbabilityMap);
    }

    public static double doCalcAvgSearchSteps(TreeNode root, int level, Map<Integer, Double> keyProbabilityMap) {
        if (root == null) {
            return 0.0;
        }
        Double p = keyProbabilityMap.get(root.val);
        return p * level
                + doCalcAvgSearchSteps(root.left, level + 1, keyProbabilityMap)
                + doCalcAvgSearchSteps(root.right, level + 1, keyProbabilityMap);
    }

    public static Pair<Double, TreeNode> bestBinarySearchTree(int[] nodes, double[] probability) {
        int n = nodes.length;
        double[][] c = new double[n][n];
        for (int i = 0; i < n; i++) {
            c[i][i] = probability[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                double minDistance = Double.MAX_VALUE;
                int minIndex = -1;
                for (int k = i; k <= j + i; k++) {
                    double d = c[i][k-1] + c[k+1][j+i];
                    if (d < minDistance) {
                        minDistance = d;
                        minIndex = k;
                    }
                }
                double sum = 0.0;
                for (int m = i; m <= i + j; m++) {
                    sum += probability[m];
                }
                c[i][i+j] = minDistance + sum;
            }
        }
        return null;
    }


}
