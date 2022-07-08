package com.basketteamapi.basketteam.components.player;

import com.basketteamapi.basketteam.components.player.exceptions.NotActivePlayersException;
import com.basketteamapi.basketteam.components.player.exceptions.PlayerNotFoundException;
import com.basketteamapi.basketteam.models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getList(Long userId) {
        return playerRepository.findAllByUserId(userId);
    }
    public List<Player> getActivePlayers(Long userId) {
        List<Player> players = playerRepository.findByUserIdAndActive(userId, true);

        if (players.isEmpty()) {
            throw new NotActivePlayersException("Not active players by userId" + userId);
        }

        return players;
    }

    public void deletePlayer(Player player) {
        if (!this.isExistPlayer(player)) {
            throw new PlayerNotFoundException("Player not found playerId:" + player.getId());
        }

        playerRepository.delete(player);
    }

    public void updatePlayer(Player player) {
        if (!this.isExistPlayer(player)) {
            throw new PlayerNotFoundException("Player not found playerId:" + player.getId());
        }

        playerRepository.save(player);
    }

    private boolean isExistPlayer(Player player) {
        return playerRepository.existsById(player.getId());
    }

    public int getTotalNumberActivePlayers(Long userId) {
        return playerRepository.countByUserIdAndActive(userId, true);
    }
}
