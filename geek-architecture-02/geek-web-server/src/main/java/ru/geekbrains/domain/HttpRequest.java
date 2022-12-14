package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private String method;

    private String url;

    private Map<String, String> headers = new HashMap<>();

    private  String body;

    private HttpRequest() {
    }

    public HttpRequest(String method, String url, Map<String, String> headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static Builder createBuilder(){
        return new Builder();
    }

    public static class Builder{
        private final HttpRequest httpRequest;

        public Builder() {
            this.httpRequest = new HttpRequest();
        }

        public Builder withMethod(String method){
            this.httpRequest.method = method;
            return this;
        }

        public Builder withUrl(String url){
            this.httpRequest.url = url;
            return this;
        }

        public Builder withHeader(Map<String, String> headers){
            this.httpRequest.headers = headers;
            return this;
        }

        public Builder withBody(String body){
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build(){
            return httpRequest;
        }

    }
}
