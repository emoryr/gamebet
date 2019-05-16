package com.gamebet.gamebet.controller;

import com.gamebet.gamebet.service.GameBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bet")
public class GameBetController {

    @Autowired
    private GameBetService gameBetService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity bet() {

        int gain = gameBetService.normalBet();

        return ResponseEntity.status(HttpStatus.FOUND).body("You won " + gain + " coins");
    }
}
