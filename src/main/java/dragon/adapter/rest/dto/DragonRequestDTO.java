package dragon.adapter.rest.dto;

import coordinates.adapter.rest.dto.CoordinatesDTO;
import dragon.domain.Dragon;
import dragonHead.adapter.rest.dto.DragonHeadDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DragonRequestDTO {
    @NotNull
    @NotBlank
    private String name; //Поле не может быть null, Строка не может быть пустой

    @NotNull
    @Valid
    private CoordinatesDTO coordinates; //Поле не может быть null

    @Min(1)
    private int age; //Значение поля должно быть больше 0

    @NotNull
    private String description; //Поле может быть null

    @NotNull
    private Dragon.Color color; //Поле не может быть null

    @NotNull
    private Dragon.DragonType type; //Поле может быть null

    @Valid
    private DragonHeadDTO head;


    public String getName() {
        return name;
    }

    public CoordinatesDTO getCoordinates() {
        return coordinates;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public Dragon.Color getColor() {
        return color;
    }

    public Dragon.DragonType getType() {
        return type;
    }

    public DragonHeadDTO getHead() {
        return head;
    }
}
