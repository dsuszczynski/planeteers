package pl.suszczynski.planeteers.data;


/**
 * In a whole game are 7 positive characters.
 * @see Player - every positive character can be initialized as Player.
 *
 * Created by daniel on 14.05.16.
 */
public enum PositiveCharacterType implements Characterable {
    CAPTAIN_PLANET("Captain Planet", "CP", null, ColorType.WHITE),

    KWAME("Kwame", "K",PowerType.EARTH, ColorType.GREEN),
    WHEELER("Wheeler", "W", PowerType.FIRE, ColorType.YELLOW),
    LINKA("Linka", "L", PowerType.WIND, ColorType.CYAN),
    GI("Gi", "G", PowerType.WATER, ColorType.BLUE),
    MATI("Ma-Ti", "M", PowerType.HEART, ColorType.RED);

    private String name;

    private String cliShortcut;

    /* One of a five powers given by Gaia */
    private PowerType powerType;

    /* ColorType used for display on CLI */
    private ColorType colorType;

    PositiveCharacterType(String name, String cliShortcut, PowerType powerType, ColorType colorType) {
        this.name = name;
        this.cliShortcut = cliShortcut;
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

    public String getCliShortcut() {
        return cliShortcut;
    }
}
