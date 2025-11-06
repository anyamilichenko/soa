package coordinates.domain;

import java.util.Objects;

public class Coordinates {
    private final Long id;
    private final Long x;
    private final Double y;

    public Coordinates(Long id, Long x, Double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public Long getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

}
