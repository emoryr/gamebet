package com.gamebet.gamebet.service;

import com.gamebet.gamebet.dto.Player;
import com.gamebet.gamebet.dto.PlayerDto;
import com.gamebet.gamebet.dto.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GameBetService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player normalBet(Player player) {
        player.normalBet();
        return playerRepository.save(player);
    }

    public Player save(PlayerDto playerDto) {
        Player player = new Player();

        player.setName(playerDto.getName());
        player.setCoins(playerDto.getCoins());
        return playerRepository.save(player);
    }

    public Player search(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player == null ? null : player.get();
    }
}
