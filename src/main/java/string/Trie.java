package string;

import java.util.*;

/**
 * @author yun.516@gmail.com
 */
public class Trie {
    TrieNode root = new TrieNode('/');

    public Trie() {

    }

    public void insert(char[] text) {
        TrieNode  p = root;
        for(char c : text) {
            int i = index(c);
            if (p.children[i] == null) {
                p.children[i] = new TrieNode(c);
                p = p.children[i];
            } else {
                p = p.children[i];
            }
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] text) {
        TrieNode p = root;
        for(char c : text) {
            int i = index(c);
            if ((p = p.children[i]) == null) {
                return false;
            }
        }
        return p.isEndingChar;
    }

    public List<String> hint(String prefix) {
        char[] text = prefix.toCharArray();
        TrieNode p = root;
        for(char c : text) {
            int i = index(c);
            if ((p = p.children[i]) == null) {
                return Collections.emptyList();
            }
        }
        Stack<Character> word = new Stack<>();
        List<String> ret = new ArrayList<>();
        hint2(p, word, ret);
        return ret;
    }
    private void hint2(TrieNode p, Stack<Character> word, List<String> ret) {
        for(TrieNode node: p.children) {
            if (node != null) {
                word.push(node.data);
                if (node.isEndingChar) {
                    StringBuilder sb = new StringBuilder();
                    for(Character c: word) {
                        sb.append(c);
                    }
                    ret.add(sb.toString());
                }
                hint2(node, word, ret);
                word.pop();
            }
        }
    }

    private int index(char c) {
        return (int)(c - 'a');
    }
    private static class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isEndingChar;

        TrieNode(char data) {
            this.data = data;
        }
    }
}
