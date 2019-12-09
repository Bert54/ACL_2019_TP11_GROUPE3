package exceptions;

public class TeleportNoDestinationException extends RuntimeException {

    public TeleportNoDestinationException() {

        super("Teleporters may not be used without a destination");

    }


}
