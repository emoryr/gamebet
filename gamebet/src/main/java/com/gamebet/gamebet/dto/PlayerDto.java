package com.gamebet.gamebet.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PlayerDto implements Serializable {

    private static final long serialVersionUID = -8105241933692707649L;

    private Long id;

    @NotNull
    private String name;

    @NotNull
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

    public PlayerDto() {
    }
}
