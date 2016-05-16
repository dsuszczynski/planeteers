package pl.suszczynski.planeteers.data.character;

/**
 * Created by daniel on 14.05.16.
 */
public enum ColorType {
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    /* ANSI color */
    private String color;

    ColorType(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
