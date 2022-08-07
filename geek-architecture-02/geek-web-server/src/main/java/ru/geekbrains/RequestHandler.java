package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class RequestHandler implements Runnable {

    private final Socket socket;
    private final MessageHandler messageHandler;



    public RequestHandler(Socket socket) {
        this.socket = socket;
        messageHandler = new MessageHandler();
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter output = new PrintWriter(socket.getOutputStream())) {

            while (!input.ready());

            String parts = new PartsHandler(input).getPart();
            Path path = new PathHandler(parts).getPath();
            new ConnectionInfoHandler(input).info();



            try {
                output.println(messageHandler.sendOK());
                Files.newBufferedReader(path).transferTo(output);
                output.flush();
            } catch (AccessDeniedException | NoSuchFileException n) {
                n.printStackTrace();
                output.println(messageHandler.sendError());
                output.flush();
            }
            System.out.println("Client disconnected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
