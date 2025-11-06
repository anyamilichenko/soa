package mapstruct;

import com.soa_service_a.jooq.tables.records.DragonRecord;
import configuration.MapperConfiguration;
import coordinates.adapter.rest.dto.CoordinatesDTO;
import dragon.adapter.rest.dto.DragonRequestDTO;
import dragon.adapter.rest.dto.DragonResponseDTO;
import dragon.domain.Dragon;
import dragonHead.adapter.rest.dto.DragonHeadDTO;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DragonMapper {
    DragonRecord toRecord(Dragon domain);
    Dragon fromRecord(DragonRecord record);

    Dragon fromRequest(
            DragonRequestDTO request,
            Long coordinatesId,
            Long HeadId
    );

    DragonResponseDTO toResponse(
            Dragon domain,
            CoordinatesDTO coordinates,
            DragonHeadDTO head
    );
}