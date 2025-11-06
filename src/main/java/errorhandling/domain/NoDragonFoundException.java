package errorhandling.domain;

public class NoDragonFoundException extends RuntimeException {
    public NoDragonFoundException(Long id) {
        super("Dragon с " + id + " не найден в базе данных");
    }

    public NoDragonFoundException(String color) {
        super("Dragon with color " + color + " not found");
    }
}