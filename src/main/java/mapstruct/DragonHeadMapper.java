package mapstruct;


import com.soa_service_a.jooq.tables.records.DragonHeadRecord;
import configuration.MapperConfiguration;
import dragonHead.adapter.rest.dto.DragonHeadDTO;
import dragonHead.domain.DragonHead;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DragonHeadMapper {
    DragonHeadRecord toRecord(DragonHead domain);
    DragonHead fromRecord(DragonHeadRecord record);

    DragonHeadDTO toDTO(DragonHead domain);
    DragonHead fromDTO(DragonHeadDTO dto);
}