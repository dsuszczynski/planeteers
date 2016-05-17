package pl.suszczynski.planeteers.data.game;

import pl.suszczynski.planeteers.data.character.CharacterType;
import pl.suszczynski.planeteers.data.character.Characterable;
import pl.suszczynski.planeteers.data.character.positive.*;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

/**
 * Created by daniel on 14.05.16.
 */
public class Game implements Serializable, Observer {

    private static final int PLANETEERS_NUMBER = 5;

    private Map<PositiveCharacterType, PositiveCharacter> positiveCharacters = new LinkedHashMap<>();
    private Integer level = 1;
    private Integer mission = 1;
    private GameDifficultyType difficultyType;

    private transient Player player;
    private transient CaptainPlanet captainPlanet;
    private transient boolean saved;

    /**
     * Return full list of active {@link Planeteer}s in a game.
     *
     * Order by life value decreasing.
     *
     * @return
     */
    public Map<PositiveCharacterType, Planeteer> getPlaneteers() {
        Map<PositiveCharacterType, Planeteer> planeteers = new LinkedHashMap<>();

        // pick up Planeteers
        for (Map.Entry<PositiveCharacterType, PositiveCharacter> entry : positiveCharacters.entrySet()) {

            if (entry.getValue() instanceof Planeteer && entry.getValue().getLife() > 0) {
                planeteers.put(entry.getKey(), (Planeteer) entry.getValue());
            }
        }

        // order Planeteers by life decreasing
        getCharactersSortedByLife(planeteers);

        return planeteers;
    }

    /**
     * Return {@link Player} of a game.
     *
     * @return main Player
     */
    public Player getPlayer() {

        if (player == null) {
            for (Map.Entry<PositiveCharacterType, PositiveCharacter> entry : positiveCharacters.entrySet()) {
                if (entry.getValue() instanceof Player) {
                    player = (Player) entry.getValue();
                    break;
                }
            }
        }

        return player;
    }

    /**
     * Return {@link CaptainPlanet} if {@link Planeteer}s "call him" and it was possible to initialize him.
     *
     * The condition to initialize {@link CaptainPlanet} is that all {@link Planeteer}s are alive.
     *
     * @return
     */
    public CaptainPlanet getCaptainPlanet() {

        if (getPlaneteers().size() == PLANETEERS_NUMBER) {
            if (captainPlanet == null) {
                for (Map.Entry<PositiveCharacterType, PositiveCharacter> entry : positiveCharacters.entrySet()) {
                    if (entry.getValue() instanceof CaptainPlanet) {
                        captainPlanet = (CaptainPlanet) entry.getValue();
                        break;
                    }
                }
            }

        } else {
            captainPlanet = null;
        }

        return captainPlanet;
    }

    /**
     * Update when Planeteer got hit.
     *
     * @param o {@link Planeteer}
     * @param force {@link Integer}
     */
    @Override
    public void update(Observable o, Object force) {
        if (o instanceof Planeteer && force instanceof Integer) {
            Planeteer planeteer = (Planeteer) o;

            positiveCharacters.remove(planeteer.getCharacterType());

            if (planeteer.getLife() > 0) {
                positiveCharacters.put(planeteer.getCharacterType(), planeteer);
            }
        }
    }

    /**
     * Order map decreasing.
     *
     * @param characters
     * @return
     */
    private static <K extends CharacterType, V extends Characterable> Map<K, V> getCharactersSortedByLife(final Map<K, V> characters) {

        return characters.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue().getLife() - e2.getValue().getLife())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

    public Map<PositiveCharacterType, PositiveCharacter> getPositiveCharacters() {
        return positiveCharacters;
    }

    public void setPositiveCharacters(Map<PositiveCharacterType, PositiveCharacter> positiveCharacters) {
        this.positiveCharacters = positiveCharacters;
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

    public GameDifficultyType getDifficultyType() {
        return difficultyType;
    }

    public void setDifficultyType(GameDifficultyType difficultyType) {
        this.difficultyType = difficultyType;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}
