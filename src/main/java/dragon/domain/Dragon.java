package dragon.domain;

import java.time.OffsetDateTime;

public class Dragon {
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Long coordinatesId; //Поле не может быть null
    private final OffsetDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final int age; //Значение поля должно быть больше 0
    private final String description; //Поле может быть null
    private final Color color; //Поле не может быть null
    private final DragonType type; //Поле может быть null
    private final Long headId;


    public Dragon(Long id, String name, Long coordinatesId, OffsetDateTime creationDate,
                  int age, String description, Color color, DragonType type, Long headId) {
        this.id = id;
        this.name = name;
        this.coordinatesId = coordinatesId;
        this.creationDate = creationDate;
        this.age = age;
        this.description = description;
        this.color = color;
        this.type = type;
        this.headId = headId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getCoordinatesId() {
        return coordinatesId;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public Color getColor() {
        return color;
    }

    public DragonType getType() {
        return type;
    }

    public Long getHeadId() {
        return headId;
    }

    public enum Color {
        GREEN,
        ORANGE,
        BROWN;
    }
    public enum DragonType {
        WATER,
        UNDERGROUND,
        AIR,
        FIRE;
    }

}
