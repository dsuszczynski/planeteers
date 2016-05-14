package pl.suszczynski.planeteers.data;

import java.io.Serializable;

/**
 * Created by daniel on 14.05.16.
 */
public class Player implements Serializable {

    /* Name of a player */
    private String name;

    private PositiveCharacterType characterType;

    private Integer strength = 0;

    public Player(String name, PositiveCharacterType characterType) {
        this(characterType);

        this.name = name;
    }

    public Player(PositiveCharacterType characterType) {
        this.characterType = characterType;
    }

    public String getName() {
        return name;
    }

    public PositiveCharacterType getCharacterType() {
        return characterType;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }
}
