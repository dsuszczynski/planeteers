package pl.suszczynski.planeteers.helper;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by daniel on 14.05.16.
 */
public enum ConsoleCommandType {

    DISPLAY_RANKING_PLAYERS("ranking") {
        private boolean isParameterMatching(String parameter) {

            if ("players".equals(parameter)) {
                return true;
            }

            return false;
        }
    },

    DISPLAY_RANKING_ENEMIES("ranking") {
        private boolean isParameterMatching(String parameter) {

            if ("enemies".equals(parameter)) {
                return true;
            }

            return false;
        }
    },

    DISPLAY_INFO_PLAYER("info") {
        private boolean isParameterMatching(String parameter) {
            return true;
        }
    },

    DISPLAY_INFO_ENEMY("info") {
        private boolean isParameterMatching(String parameter) {
            return true;
        }
    },

    DISPLAY_MAP("map"),

    GAME_LOAD("load") {
        private boolean isParameterMatching(String parameter) {
            return true;
        }
    },

    GAME_NEW("new") {
        private boolean isParameterMatching(String parameter) {
            return true;
        }
    },

    GAME_SAVE("save"),
    GAME_EXIT("exit"),
    HELP("help");

    private String command;

    ConsoleCommandType(String command) {
        this.command = command;
    }

    public static ConsoleCommandType find(String commandValue) {
        commandValue = StringUtils.lowerCase(commandValue);
        String[] commandValues = StringUtils.split(commandValue, "\\s");

        if (commandValues.length == 0 || commandValues.length > 2) {
            return null;
        }

        if (StringUtils.isNotBlank(commandValues[0])) {
            String command = commandValues[0];
            String parameter = null;

            if (commandValues.length == 2 && StringUtils.isNotBlank(commandValues[1])) {
                parameter = commandValues[1];
            }

            for (ConsoleCommandType commandType : ConsoleCommandType.values()) {

                if (commandType.command.equals(command) && commandType.isParameterMatching(parameter)) {
                    return commandType;
                }
            }
        }

        return null;
    }


    /**
     * Check if given parameter match to expected values for command.
     * @param parameter
     * @return
     */
    private boolean isParameterMatching(String parameter) {

        if (StringUtils.isEmpty(parameter)) {
            return true;
        }

        return false;
    }
}
