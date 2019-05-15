package com.gamebet.gamebet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bet")
public class GameBetController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity bet() {
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }
}
