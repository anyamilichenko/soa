package dragonHead.domain;

public class DragonHead {
    private final Long id;
    private Float eyesCount;

    public DragonHead(Long id, Float eyesCount) {
        this.id = id;
        this.eyesCount = eyesCount;

    }
    public Long getId() {
        return id;
    }
}