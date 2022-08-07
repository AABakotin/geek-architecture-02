package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;

public class ConnectionInfoHandler {
    private final BufferedReader input;

    public ConnectionInfoHandler(BufferedReader input) {
        this.input = input;
    }

    public void info() throws IOException {
        while (input.ready()){
            System.out.println("INFO * " + input.readLine());
        }

    }
}
