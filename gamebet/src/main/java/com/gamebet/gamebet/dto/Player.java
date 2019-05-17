package com.gamebet.gamebet.dto;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component
@Table(name = "player")
public class Player implements Serializable {

    private static final long serialVersionUID = -6888542263201514002L;

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
}
