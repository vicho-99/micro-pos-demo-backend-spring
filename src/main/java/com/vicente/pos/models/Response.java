package com.vicente.pos.models;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public Response(){};

    public String  message ;



    public Response( String message) {

        this.message = message;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResponseEntity<Response> res ( String message, HttpStatus httpStatus){
        Response res = new Response();
        res.setMessage(message);
        return ResponseEntity.status(httpStatus).body(res);

    }

}
