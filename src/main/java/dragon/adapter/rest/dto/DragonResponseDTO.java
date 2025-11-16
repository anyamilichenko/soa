//package dragon.adapter.rest.dto;
//
//import coordinates.adapter.rest.dto.CoordinatesDTO;
//import dragon.domain.Dragon;
//import dragonHead.adapter.rest.dto.DragonHeadDTO;
//
//import java.time.OffsetDateTime;
//
//public class DragonResponseDTO {
//    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
//    private String name; //Поле не может быть null, Строка не может быть пустой
//    private CoordinatesDTO coordinates; //Поле не может быть null
//    private OffsetDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
//    private int age; //Значение поля должно быть больше 0
//    private String description; //Поле может быть null
//    private Dragon.Color color; //Поле не может быть null
//    private Dragon.DragonType type; //Поле может быть null
//    private DragonHeadDTO head;
//}




package dragon.adapter.rest.dto;

        import coordinates.adapter.rest.dto.CoordinatesDTO;
        import dragon.domain.Dragon;
        import dragonHead.adapter.rest.dto.DragonHeadDTO;

        import java.time.OffsetDateTime;

public class DragonResponseDTO {
    private Long id;
    private String name;
    private CoordinatesDTO coordinates;
    private OffsetDateTime creationDate;
    private int age;
    private String description;
    private Dragon.Color color;
    private Dragon.DragonType type;
    private DragonHeadDTO head;

    // Конструктор по умолчанию
    public DragonResponseDTO() {}

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CoordinatesDTO getCoordinates() { return coordinates; }
    public void setCoordinates(CoordinatesDTO coordinates) { this.coordinates = coordinates; }

    public OffsetDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(OffsetDateTime creationDate) { this.creationDate = creationDate; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Dragon.Color getColor() { return color; }
    public void setColor(Dragon.Color color) { this.color = color; }

    public Dragon.DragonType getType() { return type; }
    public void setType(Dragon.DragonType type) { this.type = type; }

    public DragonHeadDTO getHead() { return head; }
    public void setHead(DragonHeadDTO head) { this.head = head; }
}