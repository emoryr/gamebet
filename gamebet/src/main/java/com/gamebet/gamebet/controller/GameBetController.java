package com.gamebet.gamebet.controller;

import com.gamebet.gamebet.dto.GameRound;
import com.gamebet.gamebet.dto.Player;
import com.gamebet.gamebet.dto.PlayerDto;
import com.gamebet.gamebet.service.GameBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/bet")
public class GameBetController {

    @Autowired
    private GameBetService gameBetService;

    @RequestMapping(path = "/{id}/bet", method = RequestMethod.GET)
    public ResponseEntity bet(@PathVariable("id") Long id) {

        Player player = gameBetService.searchPlayer(id);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.OK).body("User not found");
        }
        player = gameBetService.normalBet(player);
        GameResponse<Player> response = new GameResponse<>(player);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody PlayerDto playerDto) {
        Player player = this.gameBetService.save(playerDto);
        GameResponse<Player> response = new GameResponse<>(player);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(path = "/round/{id}", method = RequestMethod.GET)
    public ResponseEntity loadRound(@PathVariable("id") Long id) {

        GameRound gameRound = gameBetService.searchRound(id);
        if (gameRound == null) {
            return ResponseEntity.status(HttpStatus.OK).body("Round not found");
        }
        GameResponse<GameRound> response = new GameResponse<>(gameRound);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
