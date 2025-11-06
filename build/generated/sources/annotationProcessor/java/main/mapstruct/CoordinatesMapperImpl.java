package mapstruct;

import com.soa_service_a.jooq.tables.records.CoordinatesRecord;
import coordinates.adapter.rest.dto.CoordinatesDTO;
import coordinates.domain.Coordinates;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-06T21:37:52+0300",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class CoordinatesMapperImpl implements CoordinatesMapper {

    @Override
    public CoordinatesRecord toRecord(Coordinates domain) {
        if ( domain == null ) {
            return null;
        }

        CoordinatesRecord coordinatesRecord = new CoordinatesRecord();

        if ( domain.getId() != null ) {
            coordinatesRecord.setId( domain.getId() );
        }
        if ( domain.getX() != null ) {
            coordinatesRecord.setX( domain.getX() );
        }
        if ( domain.getY() != null ) {
            coordinatesRecord.setY( domain.getY() );
        }

        return coordinatesRecord;
    }

    @Override
    public Coordinates fromRecord(CoordinatesRecord record) {
        if ( record == null ) {
            return null;
        }

        Long id = null;
        Long x = null;
        Double y = null;

        if ( record.getId() != null ) {
            id = record.getId();
        }
        if ( record.getX() != null ) {
            x = record.getX();
        }
        if ( record.getY() != null ) {
            y = record.getY();
        }

        Coordinates coordinates = new Coordinates( id, x, y );

        return coordinates;
    }

    @Override
    public CoordinatesDTO toDTO(Coordinates domain) {
        if ( domain == null ) {
            return null;
        }

        Long x = null;
        Double y = null;

        if ( domain.getX() != null ) {
            x = domain.getX();
        }
        if ( domain.getY() != null ) {
            y = domain.getY();
        }

        CoordinatesDTO coordinatesDTO = new CoordinatesDTO( x, y );

        return coordinatesDTO;
    }

    @Override
    public Coordinates fromDTO(CoordinatesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Long x = null;
        Double y = null;

        if ( dto.getX() != null ) {
            x = dto.getX();
        }
        if ( dto.getY() != null ) {
            y = dto.getY();
        }

        Long id = null;

        Coordinates coordinates = new Coordinates( id, x, y );

        return coordinates;
    }
}
