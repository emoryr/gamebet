package com.gamebet.gamebet.dto;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Component
@Table(name = "player")
public class Player implements Serializable {

    private static final long serialVersionUID = -6888542263201514002L;
    static final int gainLikelihood = 30;
    static final int freeLikelihood = 10;
    static  final int valueWin = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "coins", nullable = false)
    private int coins;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     *
     * @return the gain from free rounds
     */
    public int freeBet() {
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

    public void normalBet() {
        int gain = 0;
        int randomValue = ThreadLocalRandom.current().nextInt(1,100);
        if (randomValue <= gainLikelihood) {
            gain += valueWin;
        }
        gain += freeBet();

        coins = gain;
    }
}
