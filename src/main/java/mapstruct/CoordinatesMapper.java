package mapstruct;


import com.soa_service_a.jooq.tables.records.CoordinatesRecord;
import configuration.MapperConfiguration;
import coordinates.adapter.rest.dto.CoordinatesDTO;
import coordinates.domain.Coordinates;
import org.mapstruct.Mapper;


@Mapper(config = MapperConfiguration.class)
public interface CoordinatesMapper {
    CoordinatesRecord toRecord(Coordinates domain);
    Coordinates fromRecord(CoordinatesRecord record);

    CoordinatesDTO toDTO(Coordinates domain);
    Coordinates fromDTO(CoordinatesDTO dto);
}