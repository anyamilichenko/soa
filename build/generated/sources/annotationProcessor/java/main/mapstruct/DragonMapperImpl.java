package mapstruct;

import com.soa_service_a.jooq.tables.records.DragonRecord;
import coordinates.adapter.rest.dto.CoordinatesDTO;
import dragon.adapter.rest.dto.DragonRequestDTO;
import dragon.adapter.rest.dto.DragonResponseDTO;
import dragon.domain.Dragon;
import dragonHead.adapter.rest.dto.DragonHeadDTO;
import java.time.OffsetDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-16T18:11:15+0300",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class DragonMapperImpl implements DragonMapper {

    @Override
    public DragonRecord toRecord(Dragon domain) {
        if ( domain == null ) {
            return null;
        }

        DragonRecord dragonRecord = new DragonRecord();

        if ( domain.getId() != null ) {
            dragonRecord.setId( domain.getId() );
        }
        if ( domain.getName() != null ) {
            dragonRecord.setName( domain.getName() );
        }
        if ( domain.getCoordinatesId() != null ) {
            dragonRecord.setCoordinatesId( domain.getCoordinatesId() );
        }
        if ( domain.getCreationDate() != null ) {
            dragonRecord.setCreationDate( domain.getCreationDate() );
        }
        dragonRecord.setAge( domain.getAge() );
        if ( domain.getDescription() != null ) {
            dragonRecord.setDescription( domain.getDescription() );
        }
        if ( domain.getColor() != null ) {
            dragonRecord.setColor( domain.getColor().name() );
        }
        if ( domain.getType() != null ) {
            dragonRecord.setType( domain.getType().name() );
        }
        if ( domain.getHeadId() != null ) {
            dragonRecord.setHeadId( domain.getHeadId() );
        }

        return dragonRecord;
    }

    @Override
    public Dragon fromRecord(DragonRecord record) {
        if ( record == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Long coordinatesId = null;
        OffsetDateTime creationDate = null;
        int age = 0;
        String description = null;
        Dragon.Color color = null;
        Dragon.DragonType type = null;
        Long headId = null;

        if ( record.getId() != null ) {
            id = record.getId();
        }
        if ( record.getName() != null ) {
            name = record.getName();
        }
        if ( record.getCoordinatesId() != null ) {
            coordinatesId = record.getCoordinatesId();
        }
        if ( record.getCreationDate() != null ) {
            creationDate = record.getCreationDate();
        }
        if ( record.getAge() != null ) {
            age = record.getAge();
        }
        if ( record.getDescription() != null ) {
            description = record.getDescription();
        }
        if ( record.getColor() != null ) {
            color = Enum.valueOf( Dragon.Color.class, record.getColor() );
        }
        if ( record.getType() != null ) {
            type = Enum.valueOf( Dragon.DragonType.class, record.getType() );
        }
        if ( record.getHeadId() != null ) {
            headId = record.getHeadId();
        }

        Dragon dragon = new Dragon( id, name, coordinatesId, creationDate, age, description, color, type, headId );

        return dragon;
    }

    @Override
    public Dragon fromRequest(DragonRequestDTO request, Long coordinatesId, Long headId) {
        if ( request == null && coordinatesId == null && headId == null ) {
            return null;
        }

        String name = null;
        int age = 0;
        String description = null;
        Dragon.Color color = null;
        Dragon.DragonType type = null;
        if ( request != null ) {
            if ( request.getName() != null ) {
                name = request.getName();
            }
            age = request.getAge();
            if ( request.getDescription() != null ) {
                description = request.getDescription();
            }
            if ( request.getColor() != null ) {
                color = request.getColor();
            }
            if ( request.getType() != null ) {
                type = request.getType();
            }
        }
        Long coordinatesId1 = null;
        if ( coordinatesId != null ) {
            coordinatesId1 = coordinatesId;
        }
        Long headId1 = null;
        if ( headId != null ) {
            headId1 = headId;
        }

        Long id = null;
        OffsetDateTime creationDate = null;

        Dragon dragon = new Dragon( id, name, coordinatesId1, creationDate, age, description, color, type, headId1 );

        return dragon;
    }

    @Override
    public DragonResponseDTO toResponse(Dragon domain, CoordinatesDTO coordinates, DragonHeadDTO head) {
        if ( domain == null && coordinates == null && head == null ) {
            return null;
        }

        DragonResponseDTO dragonResponseDTO = new DragonResponseDTO();

        if ( domain != null ) {
            if ( domain.getId() != null ) {
                dragonResponseDTO.setId( domain.getId() );
            }
            if ( domain.getName() != null ) {
                dragonResponseDTO.setName( domain.getName() );
            }
            if ( domain.getCreationDate() != null ) {
                dragonResponseDTO.setCreationDate( domain.getCreationDate() );
            }
            dragonResponseDTO.setAge( domain.getAge() );
            if ( domain.getDescription() != null ) {
                dragonResponseDTO.setDescription( domain.getDescription() );
            }
            if ( domain.getColor() != null ) {
                dragonResponseDTO.setColor( domain.getColor() );
            }
            if ( domain.getType() != null ) {
                dragonResponseDTO.setType( domain.getType() );
            }
        }
        if ( coordinates != null ) {
            dragonResponseDTO.setCoordinates( coordinates );
        }
        if ( head != null ) {
            dragonResponseDTO.setHead( head );
        }

        return dragonResponseDTO;
    }
}
