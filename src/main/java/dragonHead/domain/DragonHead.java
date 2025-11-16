package dragonHead.domain;

public class DragonHead {
    private final Long id;
    private Integer eyesCount;

    public DragonHead(Long id, Integer eyesCount) {
        this.id = id;
        this.eyesCount = eyesCount;

    }
    public Long getId() {
        return id;
    }
    public Integer getEyesCount() {
        return eyesCount;
    }
}