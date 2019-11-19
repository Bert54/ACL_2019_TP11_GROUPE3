package exceptions;

public class TeleportNegativeCoordinatesException extends RuntimeException {

    public TeleportNegativeCoordinatesException() {

        super("Coordinates of teleport destination must both be positive");
    }

}
