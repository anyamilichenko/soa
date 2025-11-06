package coordinates.adapter.rest.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class CoordinatesDTO {

    @NotNull
    private final Long x;

    @NotNull
    @DecimalMin("-892")
    private final Double y;

    public CoordinatesDTO(Long x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() { return x; }
    public Double getY() { return y; }
}