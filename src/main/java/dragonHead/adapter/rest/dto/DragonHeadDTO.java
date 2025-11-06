package dragonHead.adapter.rest.dto;

import jakarta.validation.constraints.NotNull;

public class DragonHeadDTO {
    @NotNull
    private final Float eyesCount;


    public DragonHeadDTO(Float eyesCount) {
        this.eyesCount = eyesCount;
    }

    public Float getEyesCount() {
        return eyesCount;
    }

}
