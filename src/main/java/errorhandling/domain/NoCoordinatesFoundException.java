package errorhandling.domain;

public class NoCoordinatesFoundException extends RuntimeException {
    public NoCoordinatesFoundException(Long id) {
        super("Coordinates с " + id + " не найден в базе данных");
    }
}