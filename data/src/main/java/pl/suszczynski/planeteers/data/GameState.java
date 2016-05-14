package pl.suszczynski.planeteers.data;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 14.05.16.
 */
public class GameState implements Serializable {

    private List<Player> players = new ArrayList<>();
    private Integer level = 1;
    private Integer mission = 1;
    private DifficultyLevelType difficultyLevelType;

    private transient Player mainPlayer;

    /**
     * Return main player of a game.
     *
     * @return main player
     */
    public Player getMainPlayer() {

        if (mainPlayer == null) {
            for (Player player : players) {
                if (player.getName() != null) {
                    mainPlayer = player;
                    break;
                }
            }
        }

        return mainPlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
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
}
