package ru.geekbrains.handler;

import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.SocketService;

abstract class MethodHandlerImpl implements MethodHandler{

    private final String method;

    private final MethodHandler next;

    protected final SocketService socketService;

    protected final ResponseSerializer responseSerializer;


    public MethodHandlerImpl(String method, MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer) {
        this.method = method;
        this.next = next;
        this.socketService = socketService;
        this.responseSerializer = responseSerializer;
    }

    @Override
    public void handel(HttpRequest request) {
        HttpResponse httpResponse;
        if (method.equals(request.getMethod())){
            httpResponse = handleInternal(request);
        } else if (next != null){
            next.handel(request);
            return;
        } else {
            httpResponse = HttpResponse.createBuilder()
                    .withStatusCode(405)
                    .withStatusCodeName("METHOD_NOT_ALLOWED")
                    .withHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<h1>Метод не поддерживается!</h1>")
                    .build();
        }
        String rawResponse = responseSerializer.serialize(httpResponse);
        socketService.writeResponse(rawResponse);
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
