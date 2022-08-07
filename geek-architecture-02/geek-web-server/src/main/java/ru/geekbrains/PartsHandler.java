package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;

public class PartsHandler {

   private final String[] parts;


    public PartsHandler(BufferedReader input) throws IOException {
        this.parts = input.readLine().split(" ");
    }

    public String getPart() {
        for (String part : parts) {
            System.out.println("Parts -> " + part);
        }
        return parts[1];
    }
}
