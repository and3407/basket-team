package com.basketteamapi.basketteam.components.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    public List<Player> findAllByUserId(long userId);
}
