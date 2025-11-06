package errorhandling.domain;

public class NoDragonHeadFoundException extends RuntimeException {
    public NoDragonHeadFoundException(Long id) {
        super("Dragon Head с " + id + " не найден в базе данных");
    }
}