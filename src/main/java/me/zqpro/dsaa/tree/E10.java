package me.zqpro.dsaa.tree;

import java.io.File;

public class E10 {
    public void list(String path) {
        list(new File(path), 0);
    }

    private void list(File f, int intent) {
        if (f == null) {
            return;
        }
        display(f, intent);
        File []files = null;
        if (f.isDirectory() && (files = f.listFiles()) != null) {
            for (File item : files) {
                list(item, intent + 1);
            }
        }
    }

    private void display(File f, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("    ");
        }
        System.out.printf("%s\n", f.getName());
    }
}
