package pro.incq.dsaa.introduction;

import java.io.*;

/**
 * excise 1.4
 */
public class ProcessInclude {
    public static void processFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("#include")) {
                    // get file from include
                    String includedFileName = line.replace("#include", "").trim();
                    processFile(includedFileName);
                } else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        processFile(args[0]);
    }
}
