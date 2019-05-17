package com.gamebet.gamebet.service;

import com.gamebet.gamebet.dto.Player;
import com.gamebet.gamebet.dto.PlayerDto;
import com.gamebet.gamebet.dto.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GameBetService {

    @Autowired
    private PlayerRepository playerRepository;

    static final int gainLikelihood = 30;
    static final int freeLikelihood = 10;
    static  final int valueWin = 20;

    /**
     *
     * @return the gain from free rounds
     */
    private int freeBet() {
        int gain = 0;
        int randonValue = ThreadLocalRandom.current().nextInt(1,100);
       while (randonValue <= freeLikelihood) {
            if (randonValue <= gainLikelihood) {
                gain += valueWin;
            }
            randonValue = ThreadLocalRandom.current().nextInt(1,100);
        }

        return gain;
    }

    public Player normalBet(Player player) {
        int gain = 0;
        int randomValue = ThreadLocalRandom.current().nextInt(1,100);
        if (randomValue <= gainLikelihood) {
            gain += valueWin;
        }
        gain += freeBet();

        player.setCoins(gain);
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

        if (player == null) {
            return null;
        } else {
            return player.get();
        }

    }
}
