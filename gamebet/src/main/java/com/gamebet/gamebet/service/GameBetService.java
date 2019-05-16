package com.gamebet.gamebet.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class GameBetService {

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

    public int normalBet() {
        int gain = 0;
        int randonValue = ThreadLocalRandom.current().nextInt(1,100);
        if (randonValue <= gainLikelihood) {
            gain += valueWin;
        }
        gain += freeBet();

        return gain;
    }
}
