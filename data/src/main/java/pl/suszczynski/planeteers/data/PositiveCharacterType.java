package pl.suszczynski.planeteers.data;


/**
 * In a whole game are 7 positive characters.
 * @see Player - every positive character can be initialized as Player.
 *
 * Created by daniel on 14.05.16.
 */
public enum PositiveCharacterType implements Characterable {
    GAIA("Gaia", null, ColorType.WHITE),
    CAPTAIN_PLANET("Captain Planet", null, ColorType.WHITE),

    KWAME("Kwame", PowerType.EARTH, ColorType.GREEN),
    WHEELER("Wheeler", PowerType.FIRE, ColorType.YELLOW),
    LINKA("Linka", PowerType.WIND, ColorType.CYAN),
    GI("Kwame", PowerType.WATER, ColorType.BLUE),
    MATI("Ma-Ti", PowerType.HEART, ColorType.RED);

    private String name;

    /* One of a five powers given by Gaia */
    private PowerType powerType;

    /* ColorType used for display on CLI */
    private ColorType colorType;

    PositiveCharacterType(String name, PowerType powerType, ColorType colorType) {
        this.name = name;
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
}
