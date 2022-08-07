package ru.geekbrains;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathHandler {

    private final String folder = "E:\\Java\\geek-architecture-02\\geek-architecture-02\\www\\";

    private String parts;

    public PathHandler(String parts) {
        this.parts = parts;
    }

    public Path getPath() {
        return Paths.get(folder, parts);
    }

}


