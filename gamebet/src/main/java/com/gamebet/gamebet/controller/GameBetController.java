package com.gamebet.gamebet.controller;

import com.gamebet.gamebet.dto.Player;
import com.gamebet.gamebet.service.GameBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bet")
public class GameBetController {

    @Autowired
    private GameBetService gameBetService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity bet(@PathVariable("id") Long id) {

        Player player = gameBetService.search(id);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.OK).body("Not found user");
        }
        player = gameBetService.normalBet(player);
        GameResponse<Player> response = new GameResponse<>(player);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
