package pl.suszczynski.planeteers.data;

import pl.suszczynski.planeteers.data.enemy.Enemy;
import pl.suszczynski.planeteers.data.player.MainPlayer;
import pl.suszczynski.planeteers.data.player.Player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by daniel on 14.05.16.
 */
public class GameState implements Serializable {

    private Map<String, Player> players = new LinkedHashMap<>();
    private Map<String, Enemy> enemies = new LinkedHashMap<>();
    private Integer level = 1;
    private Integer mission = 1;
    private DifficultyLevelType difficultyLevelType;

    private transient Player mainPlayer;
    private transient boolean saved;

    /**
     * Return main player of a game.
     *
     * @return main player
     */
    public Player getMainPlayer() {

        if (mainPlayer == null) {
            for (Map.Entry<String, Player> entry : players.entrySet()) {
                if (entry.getValue() instanceof MainPlayer) {
                    mainPlayer = entry.getValue();
                    break;
                }
            }
        }

        return mainPlayer;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = players;
    }

    public Map<String, Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(Map<String, Enemy> enemies) {
        this.enemies = enemies;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMission() {
        return mission;
    }

    public void setMission(Integer mission) {
        this.mission = mission;
    }

    public DifficultyLevelType getDifficultyLevelType() {
        return difficultyLevelType;
    }

    public void setDifficultyLevelType(DifficultyLevelType difficultyLevelType) {
        this.difficultyLevelType = difficultyLevelType;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}
