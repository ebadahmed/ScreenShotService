package com.ebadahmed.screenshotservice.model;


public class Api_Response<T> {


    private T Response;

    public T getResponse() {
        return Response;
    }

    public void setResponse(T response) {
        Response = response;
    }
}
