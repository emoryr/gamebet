package com.gamebet.gamebet.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class GameRoundDto implements Serializable {

    private static final long serialVersionUID = -8105241933692707649L;

    private Long id;

    @NotNull
    private Long playerId;

    private int coins;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
