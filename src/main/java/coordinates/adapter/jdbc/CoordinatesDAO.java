package coordinates.adapter.jdbc;



import com.soa_service_a.jooq.tables.records.CoordinatesRecord;
import coordinates.domain.Coordinates;
import mapstruct.CoordinatesMapper;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import static com.soa_service_a.jooq.tables.Coordinates.COORDINATES;


@Repository
public class CoordinatesDAO {

    private final DSLContext dsl;
    private final CoordinatesMapper coordinatesMapper;

    public CoordinatesDAO(DSLContext dsl, CoordinatesMapper coordinatesMapper) {
        this.dsl = dsl;
        this.coordinatesMapper = coordinatesMapper;
    }

    public Coordinates insert(Coordinates coordinates) {
        CoordinatesRecord record = dsl.insertInto(COORDINATES)
                .set(coordinatesMapper.toRecord(coordinates))
                .returning()
                .fetchOne();

        return record != null ? coordinatesMapper.fromRecord(record) : null;
    }

    public Coordinates updateById(Coordinates coordinates) {
        CoordinatesRecord record = dsl.update(COORDINATES)
                .set(coordinatesMapper.toRecord(coordinates))
                .where(COORDINATES.ID.eq(coordinates.getId()))
                .returning()
                .fetchOne();

        return record != null ? coordinatesMapper.fromRecord(record) : null;
    }

    public Coordinates findById(Long id) {
        CoordinatesRecord record = dsl.selectFrom(COORDINATES)
                .where(COORDINATES.ID.eq(id))
                .fetchOne();

        return record != null ? coordinatesMapper.fromRecord(record) : null;
    }
}