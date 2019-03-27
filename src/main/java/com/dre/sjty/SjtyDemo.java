package com.dre.sjty;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SjtyDemo {
    String regEx1 = "delegate.Online_a";//所有的你的程序打印的日志

    public static void main(String[] args) throws IOException {
        String id = "5c481fdcd50b2";
        SjtyDemo demo = new SjtyDemo();
        demo.getIds("/Users/yuqiuyuan/Downloads/log.txt");

    }

    private Set<String> getIds(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        Set<String> ids = new HashSet<>();
        for (String line : lines) {
            if (line != null && line.indexOf(regEx1) >= 0) {
                ids.add(line.substring(line.indexOf("uv:"), line.indexOf("uv:") + 18));
            }
        }
        return ids;
    }

    private Set<String> getIdContent(String id) throws IOException {
        Set<String> idContents = new HashSet<>();
        List<String> lines = Files.readAllLines(Paths.get("/Users/yuqiuyuan/Downloads/log.txt"), StandardCharsets.UTF_8);
        boolean print = false;
        //结果保存到log-filter.txt上
        Path path = Paths.get("/Users/yuqiuyuan/Downloads/log-filter.txt");
        for (String line : lines) {
            if (line != null && line.indexOf(regEx1) >= 0 && line.indexOf(id) >= 0) {
                print = true;
            } else if (line != null && line.indexOf(regEx1) >= 0) {
                print = false;
            }
            if (print) {
                //Use try-with-resource to get auto-closeable writer instance
                try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                    writer.write(line);
                }
                System.out.println(line);
                idContents.add(line);
            }
        }
        return idContents;
    }
}
