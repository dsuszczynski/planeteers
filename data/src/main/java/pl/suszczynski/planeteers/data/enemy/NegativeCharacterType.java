package pl.suszczynski.planeteers.data.enemy;


import pl.suszczynski.planeteers.data.CharacterType;
import pl.suszczynski.planeteers.data.Characterable;
import pl.suszczynski.planeteers.data.ColorType;
import pl.suszczynski.planeteers.data.PowerType;
import pl.suszczynski.planeteers.data.player.Player;

/**
 * In a whole game are 7 positive characters.
 * @see Player - every positive character can be initialized as Player.
 *
 * Created by daniel on 14.05.16.
 */
public enum NegativeCharacterType implements CharacterType {
    HOGGISH_GREEDLY("Hoggish Greedly", "-HG", PowerType.EARTH, 1, 6),
    RIGGER("Rigger", "-R", PowerType.FIRE, 1, 3),

    VERMINOUS_SKUMM("Verminous Skumm", "-VS", PowerType.WATER, 2, 20),
    THE_RAT_PACK("The Rat Pack", "-TRP", PowerType.WIND, 1, 20),

    DR_BLIGHT("Dr. Blight", "-DB", PowerType.HEART, 3, 15),
    MAL("mal", "-M", PowerType.FIRE, 3, 5),

    DUKE_NUKEM("Duke Nukem", "-DN", PowerType.EARTH, 3, 20),
    LEADSUIT("Leadsuit", "-L", PowerType.HEART, 1, 20),

    LOOTEN_PLUNDER("Looten Plunder", "-LP", PowerType.WATER, 3, 30),
    ARGOS_BLEAK("Argos Bleak", "-AB", PowerType.FIRE, 2, 10),
    PINEHEAD_BROTHERS("Pinehead Brothers", "-PB", PowerType.WIND, 2, 5),

    SLY_SLUDGE("Sly Sludge", "-SS", PowerType.WIND, 4, 40),
    OOZE("Ooze", "-O", PowerType.EARTH, 1, 20),
    TANK_FLUSHER_III("Tank Flusher III", "-TF", PowerType.HEART, 1, 10),

    ZARM("Zarm", "-Z", PowerType.WATER, 5, 50);

    private String name;
    private String cliShortcut;
    private Integer strength;
    private Integer life;

    /* Weakness of one of a five powers given by Gaia */
    private PowerType weaknessOfPowerType;

    NegativeCharacterType(String name, String cliShortcut, PowerType weaknessOfPowerType, Integer strength, Integer life) {
        this.name = name;
        this.cliShortcut = cliShortcut;
        this.weaknessOfPowerType = weaknessOfPowerType;
        this.strength = strength;
        this.life = life;
    }

    /**
     * @return default character name
     */
    @Override
    public String getName() {
        return name;
    }

    public PowerType getWeaknessOfPowerType() {
        return weaknessOfPowerType;
    }

    @Override
    public Integer getStrength() {
        return strength;
    }

    public Integer getLife() {
        return life;
    }

    @Override
    public ColorType getColorType() {
        return ColorType.MAGENTA;
    }

    @Override
    public String getCliShortcut() {
        return cliShortcut;
    }
}
