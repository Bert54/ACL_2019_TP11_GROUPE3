package exceptions;

public class NoHeroException extends RuntimeException {

    public NoHeroException() {

        super("A hero must be present in order for the game to be played");

    }

}
