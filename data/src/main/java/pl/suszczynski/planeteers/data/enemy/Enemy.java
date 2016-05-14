package pl.suszczynski.planeteers.data.enemy;

import pl.suszczynski.planeteers.data.Characterable;
import pl.suszczynski.planeteers.data.ColorType;
import pl.suszczynski.planeteers.data.player.PositiveCharacterType;

import java.io.Serializable;

/**
 * Created by daniel on 14.05.16.
 */
public class Enemy implements Serializable, Characterable {

    private NegativeCharacterType characterType;
    private Integer strength;
    private Integer life;

    public Enemy(NegativeCharacterType characterType) {
        this.characterType = characterType;
        this.strength = characterType.getStrength();
        this.life = characterType.getLife();
    }

    @Override
    public String getName() {
        return characterType.getName();
    }

    @Override
    public ColorType getColorType() {
        return characterType.getColorType();
    }

    @Override
    public Integer getLife() {
        return life;
    }

    @Override
    public NegativeCharacterType getCharacterType() {
        return characterType;
    }

    public Integer getStrength() {
        return strength;
    }
}
