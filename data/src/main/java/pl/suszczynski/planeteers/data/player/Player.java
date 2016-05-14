package pl.suszczynski.planeteers.data.player;

import pl.suszczynski.planeteers.data.Characterable;
import pl.suszczynski.planeteers.data.ColorType;

import java.io.Serializable;

/**
 * Created by daniel on 14.05.16.
 */
public class Player implements Serializable, Characterable {

    private String name;
    private PositiveCharacterType characterType;
    private Integer strength;
    private Integer life;

    protected Player(String name, PositiveCharacterType characterType) {
        this(characterType);

        this.name = name;
    }

    public Player(PositiveCharacterType characterType) {
        this.characterType = characterType;
        this.strength = characterType.getStrength();
    }

    @Override
    public String getName() {
        if (name == null) {
            return characterType.getName();
        }

        return name;
    }

    @Override
    public ColorType getColorType() {
        return characterType.getColorType();
    }

    @Override
    public PositiveCharacterType getCharacterType() {
        return characterType;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Override
    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }
}
