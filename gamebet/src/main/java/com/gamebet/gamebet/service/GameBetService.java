package com.gamebet.gamebet.service;

import com.gamebet.gamebet.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameBetService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRoundRepository gameRoundRepository;

    public Player normalBet(Player player) {
        player.normalBet();

        GameRound gameRound = new GameRound();
        gameRound.setCoins(player.getCoins());
        gameRound.setPlayerId(player.getId());
        gameRoundRepository.save(gameRound);

        return playerRepository.save(player);
    }

    public Player save(PlayerDto playerDto) {
        Player player = new Player();

        player.setName(playerDto.getName());
        player.setCoins(playerDto.getCoins());
        return playerRepository.save(player);
    }

    public Player searchPlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player == null ? null : player.get();
    }

    public GameRound searchRound(Long id) {
        Optional<GameRound> gameRound = gameRoundRepository.findById(id);
        return gameRound == null ? null : gameRound.get();
    }

    public List<GameRound> searchRoundByPlayer(Long playerId) {
        return gameRoundRepository.findAllByPlayerId(playerId);
    }
}
