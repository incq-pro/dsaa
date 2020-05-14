package  me.zqpro.dsaa.string;

/**
 * @author yun.516@gmail.com
 */
public class Trie2 {
    private static final int SIZE = 'z' - 'a' + 1;

    TrieNode root = new TrieNode('/');

    public void add(char[] word) {
        TrieNode p = root;
        for (char c : word) {
            int i = index(c);
            if (p.children[i] == null) {
                p.children[i] = new TrieNode(c);
            }
            p = p.children[i];
        }
        p.isEnd = true;
    }

    public boolean contains(char[] word) {
        TrieNode p = root;
        for (char c : word) {
            p = p.children[index(c)];
            if (p == null) {
                return false;
            }
        }
        return p.isEnd;
    }

    public void remove(char[] word) {
        TrieNode[] path = new TrieNode[word.length + 1];
        TrieNode p = root;
        int k = 0;
        path[k++] = p;
        for (char c : word) {
            p = p.children[index(c)];
            if (p == null) {
                return;
            }
            path[k++] = p;
        }
        p.isEnd = false;
        --k;
        while (k > 0) {
            p = path[k];
            boolean canBeDelete = true;
            for (TrieNode n : p.children) {
                if (n != null) {
                    canBeDelete = false;
                    break;
                }
            }
            if (canBeDelete) {
                path[k - 1].children[index(p.c)] = null;
            }
            --k;
        }
    }

    int index(char c) {
        return c - 'a';
    }

    private static class TrieNode {
        char c;
        TrieNode[] children;
        boolean isEnd;

        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[SIZE];
        }
    }
}
