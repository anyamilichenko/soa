package dragon.adapter.rest.dto;

import coordinates.adapter.rest.dto.CoordinatesDTO;
import dragon.domain.Dragon;
import dragonHead.adapter.rest.dto.DragonHeadDTO;

import java.time.OffsetDateTime;

public class DragonResponseDTO {
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private CoordinatesDTO coordinates; //Поле не может быть null
    private OffsetDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int age; //Значение поля должно быть больше 0
    private String description; //Поле может быть null
    private Dragon.Color color; //Поле не может быть null
    private Dragon.DragonType type; //Поле может быть null
    private DragonHeadDTO head;
}
