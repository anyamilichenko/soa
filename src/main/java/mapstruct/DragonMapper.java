//package mapstruct;
//
//import com.soa_service_a.jooq.tables.records.DragonRecord;
//import configuration.MapperConfiguration;
//import coordinates.adapter.rest.dto.CoordinatesDTO;
//import dragon.adapter.rest.dto.DragonRequestDTO;
//import dragon.adapter.rest.dto.DragonResponseDTO;
//import dragon.domain.Dragon;
//import dragonHead.adapter.rest.dto.DragonHeadDTO;
//import org.mapstruct.Mapper;
//
//
//
////@Mapper(componentModel = "spring")
//@Mapper(config = MapperConfiguration.class)
//public interface DragonMapper {
//    DragonRecord toRecord(Dragon domain);
//    Dragon fromRecord(DragonRecord record);
//
//    Dragon fromRequest(
//            DragonRequestDTO request,
//            Long coordinatesId,
//            Long HeadId
//    );
//
//    DragonResponseDTO toResponse(
//            Dragon domain,
//            CoordinatesDTO coordinates,
//            DragonHeadDTO head
//    );
//}


package mapstruct;

import com.soa_service_a.jooq.tables.records.DragonRecord;
import configuration.MapperConfiguration;
import coordinates.adapter.rest.dto.CoordinatesDTO;
import dragon.adapter.rest.dto.DragonRequestDTO;
import dragon.adapter.rest.dto.DragonResponseDTO;
import dragon.domain.Dragon;
import dragonHead.adapter.rest.dto.DragonHeadDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface DragonMapper {
    DragonRecord toRecord(Dragon domain);
    Dragon fromRecord(DragonRecord record);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "coordinatesId", source = "coordinatesId")
    @Mapping(target = "headId", source = "headId")
    Dragon fromRequest(
            DragonRequestDTO request,
            Long coordinatesId,
            Long headId
    );

    @Mapping(target = "id", source = "domain.id")
    @Mapping(target = "name", source = "domain.name")
    @Mapping(target = "creationDate", source = "domain.creationDate")
    @Mapping(target = "age", source = "domain.age")
    @Mapping(target = "description", source = "domain.description")
    @Mapping(target = "color", source = "domain.color")
    @Mapping(target = "type", source = "domain.type")
    DragonResponseDTO toResponse(
            Dragon domain,
            CoordinatesDTO coordinates,
            DragonHeadDTO head
    );
}