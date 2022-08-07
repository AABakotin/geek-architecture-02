package ru.geekbrains;


public class MessageHandler {


    public String sendOK() {
        return "HTTP/1.1 200 OK\n" +
                "Content-Type: text/html; charset=utf-8\n" +
                "\n";
    }

    public String sendError() {
        return "HTTP/1.1 404 NOT_FOUND\n" +
                "Content-Type: text/html; charset=utf-8\n" +
                "\n" +
                "<h1>Файл не найден!</h1>" +
                "\n";
    }
}
