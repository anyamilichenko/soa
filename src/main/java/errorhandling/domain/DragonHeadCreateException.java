package errorhandling.domain;

public class DragonHeadCreateException extends RuntimeException {
    public DragonHeadCreateException() {
        super("Не удалось создать dragon head");
    }
}