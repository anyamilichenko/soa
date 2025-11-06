package errorhandling.domain;

public class DragonCreateException extends RuntimeException {
    public DragonCreateException() {
        super("Не удалось создать dragon");
    }
}