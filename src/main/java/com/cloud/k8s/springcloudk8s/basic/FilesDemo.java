package com.cloud.k8s.springcloudk8s.basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesDemo {


    public static void read() throws IOException {
        final Path path = Paths.get("/Users/hudeshun/Downloads/11.txt");
        final Stream<String> lines = Files.lines(path);
        for (String s : lines.collect(Collectors.toList())) {
            System.out.println(s);
        }
    }

    public static void readFilesName() throws IOException {
        final Path path = Paths.get("./");

        final Stream<Path> list = Files.list(path);

        for (Path path1 : list.collect(Collectors.toList())) {
            System.out.println(path1.getFileName());
        }
    }


    public static void main(String[] args) throws IOException {

    }
}
