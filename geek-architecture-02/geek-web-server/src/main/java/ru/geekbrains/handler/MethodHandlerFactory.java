package ru.geekbrains.handler;

import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

public class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, ResponseSerializer responseSerializer, ServerConfig serverConfig, FileService fileService){
        PutMethodHandler putHandler = new PutMethodHandler(null, socketService, responseSerializer, serverConfig);
        PostMethodHandler postHandler = new PostMethodHandler(putHandler,  socketService, responseSerializer, serverConfig);
        return new GetMethodHandler(postHandler,  socketService, responseSerializer, serverConfig, fileService);
    }
}
