package dragonHead.adapter.jdbc;

import dragonHead.domain.DragonHead;
import mapstruct.DragonHeadMapper;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.soa_service_a.jooq.Tables.DRAGON_HEAD;
import com.soa_service_a.jooq.tables.records.DragonHeadRecord;

@Repository
public class DragonHeadDAO {

    private final DSLContext dsl;
    private final DragonHeadMapper dragonHeadMapper;

    public DragonHeadDAO(DSLContext dsl, DragonHeadMapper dragonHeadMapper) {
        this.dsl = dsl;
        this.dragonHeadMapper = dragonHeadMapper;
    }

    public DragonHead insert(DragonHead dragonHead) {
        DragonHeadRecord record = dsl.insertInto(DRAGON_HEAD)
                .set(dragonHeadMapper.toRecord(dragonHead))
                .returning()
                .fetchOne();
        return record != null ? dragonHeadMapper.fromRecord(record) : null;
    }

    public DragonHead updateById(DragonHead dragonHead) {
        DragonHeadRecord record = dsl.update(DRAGON_HEAD)
                .set(dragonHeadMapper.toRecord(dragonHead))
                .where(DRAGON_HEAD.ID.eq(dragonHead.getId()))
                .returning()
                .fetchOne();
        return record != null ? dragonHeadMapper.fromRecord(record) : null;
    }

    public DragonHead findById(Long id) {
        DragonHeadRecord record = dsl.selectFrom(DRAGON_HEAD)
                .where(DRAGON_HEAD.ID.eq(id))
                .fetchOne();
        return record != null ? dragonHeadMapper.fromRecord(record) : null;
    }
}