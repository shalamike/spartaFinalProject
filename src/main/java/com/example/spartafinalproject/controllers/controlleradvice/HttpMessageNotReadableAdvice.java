package com.example.spartafinalproject.controllers.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class HttpMessageNotReadableAdvice {
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String httpMessageNotReadableHandler(HttpMessageNotReadableException e){
        String message = "Parameter is not of the correct type";
        if(e.toString().contains("java.lang.Integer")){
            message+=", should be an integer e.g. 2023: ";
        } else if (e.toString().contains("java.util.Date")) {
            SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSX");
            message+=", should be a date e.g. "+formatter.format(System.currentTimeMillis())+": ";
        } else if (e.toString().contains("java.util.ArrayList")) {
            message+=", should be a collection e.g. [\"French\",\"Chinese\"] or [-76.512016, 38.29697]: ";
        } else if (e.toString().contains("com.example.spartafinalproject.model.dtos.moviessupport.Awards")) {
            message+=", should be have the following format: \n"+
                        "\"awards\": {\n" +
                    "    \"wins\": 1,\n" +
                    "    \"text\": \"1 win.\",\n" +
                    "    \"nominations\": 0\n" +
                    "  } \n";
        } else if (e.toString().contains("com.example.spartafinalproject.model.dtos.moviessupport.Imdb")) {
            message+=", should be have the following format: \n" +
                    "\"imdb\": {\n" +
                    "    \"rating\": 10,\n" +
                    "    \"votes\": 1000,\n" +
                    "    \"id\": 1\n" +
                    "  } \n";
        } else if (e.toString().contains("com.example.spartafinalproject.model.dtos.moviessupport.Tomatoes")) {
            message+=", should be have the following format: \n" +
            "\"tomatoes\": {\n" +
                    "    \"viewer\": {\n" +
                    "      \"meter\": 8,\n" +
                    "      \"rating\": 8,\n" +
                    "      \"numReviews\": 8\n" +
                    "    },\n" +
                    "    \"lastUpdated\": \"2023-06-15T14:50:48.025+01\"\n" +
                    "  } \n";
        } else if (e.toString().contains("com.example.spartafinalproject.model.dtos.moviessupport.Viewer")) {
            message+=", should be have the following format: \n" +
            "\"viewer\": {\n" +
                    "      \"meter\": 8,\n" +
                    "      \"rating\": 8,\n" +
                    "      \"numReviews\": 8\n" +
                    "    } \n";
        }
        return message+e;
    }
}
