package errorhandling.domain;

public class CoordinatesCreateException extends RuntimeException {
    public CoordinatesCreateException() {
        super("Не удалось создать coordinates");
    }
}