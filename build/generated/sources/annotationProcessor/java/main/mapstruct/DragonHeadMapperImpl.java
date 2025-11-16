package mapstruct;

import com.soa_service_a.jooq.tables.records.DragonHeadRecord;
import dragonHead.adapter.rest.dto.DragonHeadDTO;
import dragonHead.domain.DragonHead;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-16T17:41:20+0300",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class DragonHeadMapperImpl implements DragonHeadMapper {

    @Override
    public DragonHeadRecord toRecord(DragonHead domain) {
        if ( domain == null ) {
            return null;
        }

        DragonHeadRecord dragonHeadRecord = new DragonHeadRecord();

        if ( domain.getId() != null ) {
            dragonHeadRecord.setId( domain.getId() );
        }
        if ( domain.getEyesCount() != null ) {
            dragonHeadRecord.setEyesCount( domain.getEyesCount() );
        }

        return dragonHeadRecord;
    }

    @Override
    public DragonHead fromRecord(DragonHeadRecord record) {
        if ( record == null ) {
            return null;
        }

        Long id = null;
        Integer eyesCount = null;

        if ( record.getId() != null ) {
            id = record.getId();
        }
        if ( record.getEyesCount() != null ) {
            eyesCount = record.getEyesCount();
        }

        DragonHead dragonHead = new DragonHead( id, eyesCount );

        return dragonHead;
    }

    @Override
    public DragonHeadDTO toDTO(DragonHead domain) {
        if ( domain == null ) {
            return null;
        }

        DragonHeadDTO dragonHeadDTO = new DragonHeadDTO();

        if ( domain.getEyesCount() != null ) {
            dragonHeadDTO.setEyesCount( domain.getEyesCount() );
        }

        return dragonHeadDTO;
    }

    @Override
    public DragonHead fromDTO(DragonHeadDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Integer eyesCount = null;

        if ( dto.getEyesCount() != null ) {
            eyesCount = dto.getEyesCount();
        }

        Long id = null;

        DragonHead dragonHead = new DragonHead( id, eyesCount );

        return dragonHead;
    }
}
