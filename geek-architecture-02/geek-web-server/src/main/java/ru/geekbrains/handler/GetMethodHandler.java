package ru.geekbrains.handler;

import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

@Handler(method = "GET", order = 0)
public class GetMethodHandler extends MethodHandlerImpl{

    private final FileService fileService;

    public GetMethodHandler(MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, FileService fileService) {
        super("GET", next, socketService, responseSerializer);
        this.fileService = fileService;
    }



    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        if (!fileService.exists(request.getUrl())) {
            return HttpResponse.createBuilder()
                    .withStatusCode(404)
                    .withStatusCodeName("NOT_FOUND")
                    .withHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<h1>FIle not found</h1>").build();
        }
        return HttpResponse.createBuilder()
                .withStatusCode(200)
                .withStatusCodeName("OK")
                .withHeader("Content-Type", "text/html; charset=utf-8")
                .withBody(fileService.readFile(request.getUrl()))
                .build();
    }
}
