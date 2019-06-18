package graph;

import java.util.LinkedList;

/**
 * @author yun.516@gmail.com
 */
public class WeightGraph {
    private int v;
    private LinkedList<Edge> adj[];

    public WeightGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i ++) {
            adj[i] = new LinkedList<>();
        }
    }


    public void addEdge(int s, int t, int w) {
        adj[s].add(new Edge(s, t, w));
    }

    public static class Edge {
        int sid;
        int tid;
        int w;
        public Edge(int s, int t, int w) {
            this.sid = s;
            this.tid = t;
            this.w = w;
        }
    }


}
