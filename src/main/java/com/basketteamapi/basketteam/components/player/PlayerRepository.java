package com.basketteamapi.basketteam.components.player;

import com.basketteamapi.basketteam.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    public List<Player> findAllByUserId(long userId);

    public int countByUserIdAndActive(Long userId, boolean active);
}
