//package dragonHead.adapter.rest.dto;
//
//import jakarta.validation.constraints.NotNull;
//
//public class DragonHeadDTO {
//    @NotNull
//    private final Float eyesCount;
//
//
//    public DragonHeadDTO(Float eyesCount) {
//        this.eyesCount = eyesCount;
//    }
//
//    public Float getEyesCount() {
//        return eyesCount;
//    }
//
//}


package dragonHead.adapter.rest.dto;

import jakarta.validation.constraints.NotNull;

public class DragonHeadDTO {
    @NotNull
    private Integer eyesCount;

    public DragonHeadDTO() {
    }

    public DragonHeadDTO(Integer eyesCount) {
        this.eyesCount = eyesCount;
    }

    public Integer getEyesCount() {
        return eyesCount;
    }

    public void setEyesCount(Integer eyesCount) {
        this.eyesCount = eyesCount;
    }
}
