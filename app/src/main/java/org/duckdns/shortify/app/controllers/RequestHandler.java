package org.duckdns.shortify.app.controllers;

import org.duckdns.shortify.app.models.CreateRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class RequestHandler {

    private HashMap<String,String> dataStore= new HashMap<>();

    @RequestMapping("/redirect")
    ResponseEntity<Object> redirectToOriginalUrl(@RequestParam String shortUrl) throws URISyntaxException {
        if(dataStore.containsKey(shortUrl)){
            HttpHeaders httpHeaders= new HttpHeaders();
            httpHeaders.setLocation(URI.create(dataStore.get(shortUrl)));
            return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
        }

        return null;


    }


    @PostMapping("/create")
    String createEndpoint(@RequestBody CreateRequest createRequest){
        String shortUrl= UUID.randomUUID().toString();
        dataStore.put(shortUrl,createRequest.getUrl());
        return shortUrl+'\n';
    }
}
