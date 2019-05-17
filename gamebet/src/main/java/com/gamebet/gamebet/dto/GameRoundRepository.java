package com.gamebet.gamebet.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRoundRepository extends JpaRepository<GameRound, Long> {
}
