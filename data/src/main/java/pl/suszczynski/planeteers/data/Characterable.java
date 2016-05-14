package pl.suszczynski.planeteers.data;

import java.util.Map;

/**
 * Created by daniel on 14.05.16.
 */
public interface Characterable {

    String getName();
    ColorType getColorType();

    /**
     * Life value. The higher than better.
     * 0 - dead!
     *
     * @return
     */
    Integer getLife();
    CharacterType getCharacterType();
}
