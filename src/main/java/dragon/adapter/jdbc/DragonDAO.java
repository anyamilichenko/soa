package dragon.adapter.jdbc;
import com.soa_service_a.jooq.Tables;
import dragon.adapter.rest.dto.SortDTO;
import dragon.domain.Dragon;
import mapstruct.DragonMapper;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.avg;

@Repository
public class DragonDAO {

    private final DSLContext dsl;
    private final DragonMapper dragonMapper;

    public DragonDAO(DSLContext dsl, DragonMapper dragonMapper) {
        this.dsl = dsl;
        this.dragonMapper = dragonMapper;
    }

    public Dragon insert(Dragon dragon) {
        var record = dsl.insertInto(Tables.DRAGON)
                .set(dragonMapper.toRecord(dragon))
                .returning()
                .fetchOne();
        return record != null ? dragonMapper.fromRecord(record) : null;
    }

    public Dragon updateById(Dragon dragon) {
        var record = dsl.update(Tables.DRAGON)
                .set(dragonMapper.toRecord(dragon))
                .where(Tables.DRAGON.ID.eq(dragon.getId()))
                .returning()
                .fetchOne();
        return record != null ? dragonMapper.fromRecord(record) : null;
    }

    public Dragon findById(Long id) {
        var record = dsl.selectFrom(Tables.DRAGON)
                .where(Tables.DRAGON.ID.eq(id))
                .fetchOne();
        return record != null ? dragonMapper.fromRecord(record) : null;
    }

    public int deleteById(Long id) {
        return dsl.deleteFrom(Tables.DRAGON)
                .where(Tables.DRAGON.ID.eq(id))
                .execute();
    }

    public boolean deleteOneByColor(Dragon.Color color) {
        int deletedCount = dsl.deleteFrom(Tables.DRAGON)
                .where(Tables.DRAGON.COLOR.eq(color.toString()))
                .limit(1)
                .execute();
        return deletedCount > 0;
    }

    public Double getAverageAge() {
        return dsl.select(avg(Tables.DRAGON.AGE))
                .from(Tables.DRAGON)
                .fetchOneInto(Double.class);
    }

    public Integer countOlderThan(Integer age) {
        return dsl.selectCount()
                .from(Tables.DRAGON)
                .where(Tables.DRAGON.AGE.gt(age))
                .fetchOneInto(Integer.class);
    }



    public Object[] search(SortDTO.DragonSearchRequestDTO request) {
        List<Condition> conditions = new ArrayList<>();

        var f = request.getFilters();

        if (f != null) {
            if (f.getId() != null) {
                conditions.add(Tables.DRAGON.ID.eq(f.getId()));
            }
            if (f.getIdGt() != null) {
                conditions.add(Tables.DRAGON.ID.gt(f.getIdGt()));
            }
            if (f.getIdLt() != null) {
                conditions.add(Tables.DRAGON.ID.lt(f.getIdLt()));
            }
            if (f.getIdRange() != null) {
                String[] range = f.getIdRange().split(",");
                if (range.length == 2) {
                    try {
                        Long min = Long.parseLong(range[0]);
                        Long max = Long.parseLong(range[1]);
                        conditions.add(Tables.DRAGON.ID.between(min, max));
                    } catch (NumberFormatException e) {
                        // Игнорируем невалидный диапазон
                    }
                }
            }

            // Обработка фильтров по имени
            if (f.getName() != null) {
                conditions.add(Tables.DRAGON.NAME.eq(f.getName()));
            }
            if (f.getNameContains() != null) {
                conditions.add(Tables.DRAGON.NAME.likeIgnoreCase("%" + f.getNameContains() + "%"));
            }

            // Обработка фильтров по возрасту
            if (f.getAge() != null) {
                conditions.add(Tables.DRAGON.AGE.eq(f.getAge()));
            }
            if (f.getAgeGt() != null) {
                conditions.add(Tables.DRAGON.AGE.gt(f.getAgeGt()));
            }
            if (f.getAgeLt() != null) {
                conditions.add(Tables.DRAGON.AGE.lt(f.getAgeLt()));
            }
            if (f.getAgeRange() != null) {
                String[] range = f.getAgeRange().split(",");
                if (range.length == 2) {
                    try {
                        int min = Integer.parseInt(range[0]);
                        int max = Integer.parseInt(range[1]);
                        conditions.add(Tables.DRAGON.AGE.between(min, max));
                    } catch (NumberFormatException e) {
                        // Игнорируем невалидный диапазон
                    }
                }
            }

            // Обработка фильтров по координате X
            if (f.getCoordinatesX() != null) {
                conditions.add(Tables.COORDINATES.X.eq(f.getCoordinatesX()));
            }
            if (f.getCoordinatesXGt() != null) {
                conditions.add(Tables.COORDINATES.X.gt(f.getCoordinatesXGt()));
            }
            if (f.getCoordinatesXLt() != null) {
                conditions.add(Tables.COORDINATES.X.lt(f.getCoordinatesXLt()));
            }
            if (f.getCoordinatesXRange() != null) {
                String[] range = f.getCoordinatesXRange().split(",");
                if (range.length == 2) {
                    try {
                        Long min = Long.parseLong(range[0]);
                        Long max = Long.parseLong(range[1]);
                        conditions.add(Tables.COORDINATES.X.between(min, max));
                    } catch (NumberFormatException e) {
                        // Игнорируем невалидный диапазон
                    }
                }
            }

            // Обработка фильтров по координате Y
            if (f.getCoordinatesY() != null) {
                conditions.add(Tables.COORDINATES.Y.eq(f.getCoordinatesY()));
            }
            if (f.getCoordinatesYGt() != null) {
                conditions.add(Tables.COORDINATES.Y.gt(f.getCoordinatesYGt()));
            }
            if (f.getCoordinatesYLt() != null) {
                conditions.add(Tables.COORDINATES.Y.lt(f.getCoordinatesYLt()));
            }
            if (f.getCoordinatesYRange() != null) {
                String[] range = f.getCoordinatesYRange().split(",");
                if (range.length == 2) {
                    try {
                        float min = Float.parseFloat(range[0]);
                        float max = Float.parseFloat(range[1]);
                        conditions.add(Tables.COORDINATES.Y.between((double) min, (double) max));
                    } catch (NumberFormatException e) {
                        // Игнорируем невалидный диапазон
                    }
                }
            }

            // Обработка фильтров по цвету и типу
            if (f.getColor() != null) {
                conditions.add(Tables.DRAGON.COLOR.eq(String.valueOf(Dragon.Color.valueOf(f.getColor().toUpperCase()))));
            }
            if (f.getType() != null) {
                conditions.add(Tables.DRAGON.TYPE.eq(String.valueOf(Dragon.DragonType.valueOf(f.getType().toUpperCase()))));
            }

            // Обработка фильтров по дате создания
            if (f.getCreationDateGt() != null) {
                conditions.add(Tables.DRAGON.CREATION_DATE.gt(f.getCreationDateGt()));
            }
            if (f.getCreationDateLt() != null) {
                conditions.add(Tables.DRAGON.CREATION_DATE.lt(f.getCreationDateLt()));
            }
            if (f.getCreationDateRange() != null) {
                String[] range = f.getCreationDateRange().split(",");
                if (range.length == 2) {
                    try {
                        OffsetDateTime start = OffsetDateTime.parse(range[0]);
                        OffsetDateTime end = OffsetDateTime.parse(range[1]);
                        conditions.add(Tables.DRAGON.CREATION_DATE.between(start, end));
                    } catch (DateTimeParseException e) {
                        // Игнорируем невалидный диапазон
                    }
                }
            }
        }

        // Построение основного запроса
        var query = dsl.select(Tables.DRAGON.fields())
                .from(Tables.DRAGON)
                .join(Tables.COORDINATES).on(Tables.DRAGON.COORDINATES_ID.eq(Tables.COORDINATES.ID))
                .leftJoin(Tables.DRAGON_HEAD).on(Tables.DRAGON.HEAD_ID.eq(Tables.DRAGON_HEAD.ID))
                .where(conditions);

        // Обработка сортировки
        if (request.getSort() != null) {
            request.getSort().forEach(sort -> {
                var field = switch (sort.getBy()) {
                    case "id" -> Tables.DRAGON.ID;
                    case "name" -> Tables.DRAGON.NAME;
                    case "age" -> Tables.DRAGON.AGE;
                    case "creationDate" -> Tables.DRAGON.CREATION_DATE;
                    case "coordinates.x" -> Tables.COORDINATES.X;
                    case "coordinates.y" -> Tables.COORDINATES.Y;
                    case "head.eyesCount" -> Tables.DRAGON_HEAD.EYES_COUNT;
                    default -> Tables.DRAGON.ID;
                };

                if ("desc".equalsIgnoreCase(sort.getOrder())) {
                    query.orderBy(field.desc());
                } else {
                    query.orderBy(field.asc());
                }
            });
        }

        // Пагинация
        int offset = (request.getPage() - 1) * request.getSize();
        var items = query.offset(offset)
                .limit(request.getSize())
                .fetchInto(Dragon.class);

        // Подсчет общего количества
        var total = dsl.selectCount()
                .from(Tables.DRAGON)
                .join(Tables.COORDINATES).on(Tables.DRAGON.COORDINATES_ID.eq(Tables.COORDINATES.ID))
                .leftJoin(Tables.DRAGON_HEAD).on(Tables.DRAGON.HEAD_ID.eq(Tables.DRAGON_HEAD.ID))
                .where(conditions)
                .fetchOne(0, Long.class);

        return new Object[]{items, total != null ? total : 0L};
    }
}
