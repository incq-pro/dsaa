package me.zqpro.dsaa.tree;

import java.io.File;

public class E10 {
    public static void main(String[] args) {
        E10 e10 = new E10();
        e10.list(".");
    }

    public void list(String path) {
        list(new File(path), 0);
    }

    private long list(File f, int intent) {
        if (f == null) {
            return 0;
        }
        long size = 0;
        File []files = null;
        if (f.isDirectory() && (files = f.listFiles()) != null) {
            for (File item : files) {
                size += list(item, intent + 1);
            }
        } else {
            size = f.length();
        }
        display(f, intent, size);
        return size;
    }

    private void display(File f, int indent, long size) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.printf("%s -- %d\n", f.getName(), size);
    }
}
