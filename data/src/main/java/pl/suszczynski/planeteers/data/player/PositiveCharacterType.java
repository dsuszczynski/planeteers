package pl.suszczynski.planeteers.data.player;


import pl.suszczynski.planeteers.data.CharacterType;
import pl.suszczynski.planeteers.data.Characterable;
import pl.suszczynski.planeteers.data.ColorType;
import pl.suszczynski.planeteers.data.PowerType;

/**
 * In a whole game are 7 positive characters.
 * @see Player - every positive character can be initialized as Player.
 *
 * Created by daniel on 14.05.16.
 */
public enum PositiveCharacterType implements CharacterType {
    CAPTAIN_PLANET("Captain Planet", "CP", 5, null, ColorType.WHITE),

    KWAME("Kwame", "K", 1, PowerType.EARTH, ColorType.GREEN),
    WHEELER("Wheeler", "W", 1, PowerType.FIRE, ColorType.YELLOW),
    LINKA("Linka", "L", 1, PowerType.WIND, ColorType.CYAN),
    GI("Gi", "G", 1, PowerType.WATER, ColorType.BLUE),
    MATI("Ma-Ti", "M", 1, PowerType.HEART, ColorType.RED);

    private String name;
    private Integer strength;
    private String cliShortcut;

    /* One of a five powers given by Gaia */
    private PowerType powerType;

    /* ColorType used for display on CLI */
    private ColorType colorType;

    PositiveCharacterType(String name, String cliShortcut, Integer strength, PowerType powerType, ColorType colorType) {
        this.name = name;
        this.cliShortcut = cliShortcut;
        this.strength = strength;
        this.powerType = powerType;
        this.colorType = colorType;
    }

    /**
     * @return default character name
     */
    @Override
    public String getName() {
        return name;
    }

    public PowerType getPowerType() {
        return powerType;
    }

    @Override
    public ColorType getColorType() {
        return colorType;
    }

    @Override
    public String getCliShortcut() {
        return cliShortcut;
    }

    @Override
    public Integer getStrength() {
        return strength;
    }
}
