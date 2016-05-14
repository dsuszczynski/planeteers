package pl.suszczynski.planeteers.utility;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.enemy.Enemy;
import pl.suszczynski.planeteers.data.enemy.NegativeCharacterType;

/**
 * Created by daniel on 14.05.16.
 */
public class EnemyUtil {

    private static final Logger LOGGER = Logger.getLogger(EnemyUtil.class);

    private EnemyUtil() {
    }

    public static Enemy create(NegativeCharacterType characterType) {
        return new Enemy(characterType);
    }
}
