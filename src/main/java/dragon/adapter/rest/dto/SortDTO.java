//package dragon.adapter.rest.dto;
//
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//
//import java.time.OffsetDateTime;
//import java.util.List;
//
//public class SortDTO {
//    private final String by;
//    private final String order;
//
//    public SortDTO(String by, String order) {
//        this.by = by;
//        this.order = order;
//    }
//
//    public String getBy() {
//        return by;
//    }
//
//    public String getOrder() {
//        return order;
//    }
//
//    public class DragonSearchRequestDTO {
//        private final DragonSearchFilters filters;
//        private final List<SortDTO> sort; // Изменено с List<String> на List<SortDTO>
//        @Min(1)
//        private final Integer page;
//        @Min(1)
//        @Max(100)
//        private final Integer size;
//
//        public DragonSearchRequestDTO(DragonSearchFilters filters, List<SortDTO> sort, Integer page, Integer size) {
//            this.filters = filters;
//            this.sort = sort;
//            this.page = page;
//            this.size = size;
//        }
//
//        public DragonSearchFilters getFilters() {
//            return filters;
//        }
//
//        public List<SortDTO> getSort() { // Изменен возвращаемый тип
//            return sort;
//        }
//
//        public Integer getPage() {
//            return page;
//        }
//
//        public Integer getSize() {
//            return size;
//        }
//
//        public static class DragonSearchFilters {
//            private final Long id;
//            private final Long idGt;
//            private final Long idLt;
//            private final String idRange;
//
//            private final String name;
//            private final String nameContains;
//
//            private final Integer age;
//            private final Integer ageGt;
//            private final Integer ageLt;
//            private final String ageRange;
//
//            private final Long coordinatesX;
//            private final Long coordinatesXGt;
//            private final Long coordinatesXLt;
//            private final String coordinatesXRange;
//
//            private final Double coordinatesY;
//            private final Double coordinatesYGt;
//            private final Double coordinatesYLt;
//            private final String coordinatesYRange;
//
//            private final String color;
//            private final String type;
//
//            private final OffsetDateTime creationDateGt;
//            private final OffsetDateTime creationDateLt;
//            private final String creationDateRange;
//
//            public DragonSearchFilters(Long id, Long idGt, Long idLt, String idRange,
//                                       String name, String nameContains,
//                                       Integer age, Integer ageGt, Integer ageLt, String ageRange,
//                                       Long coordinatesX, Long coordinatesXGt, Long coordinatesXLt, String coordinatesXRange,
//                                       Double coordinatesY, Double coordinatesYGt, Double coordinatesYLt, String coordinatesYRange,
//                                       String color, String type,
//                                       OffsetDateTime creationDateGt, OffsetDateTime creationDateLt, String creationDateRange) {
//                this.id = id;
//                this.idGt = idGt;
//                this.idLt = idLt;
//                this.idRange = idRange;
//                this.name = name;
//                this.nameContains = nameContains;
//                this.age = age;
//                this.ageGt = ageGt;
//                this.ageLt = ageLt;
//                this.ageRange = ageRange;
//                this.coordinatesX = coordinatesX;
//                this.coordinatesXGt = coordinatesXGt;
//                this.coordinatesXLt = coordinatesXLt;
//                this.coordinatesXRange = coordinatesXRange;
//                this.coordinatesY = coordinatesY;
//                this.coordinatesYGt = coordinatesYGt;
//                this.coordinatesYLt = coordinatesYLt;
//                this.coordinatesYRange = coordinatesYRange;
//                this.color = color;
//                this.type = type;
//                this.creationDateGt = creationDateGt;
//                this.creationDateLt = creationDateLt;
//                this.creationDateRange = creationDateRange;
//            }
//
//            public Long getId() { return id; }
//            public Long getIdGt() { return idGt; }
//            public Long getIdLt() { return idLt; }
//            public String getIdRange() { return idRange; }
//            public String getName() { return name; }
//            public String getNameContains() { return nameContains; }
//            public Integer getAge() { return age; }
//            public Integer getAgeGt() { return ageGt; }
//            public Integer getAgeLt() { return ageLt; }
//            public String getAgeRange() { return ageRange; }
//            public Long getCoordinatesX() { return coordinatesX; }
//            public Long getCoordinatesXGt() { return coordinatesXGt; }
//            public Long getCoordinatesXLt() { return coordinatesXLt; }
//            public String getCoordinatesXRange() { return coordinatesXRange; }
//            public Double getCoordinatesY() { return coordinatesY; }
//            public Double getCoordinatesYGt() { return coordinatesYGt; }
//            public Double getCoordinatesYLt() { return coordinatesYLt; }
//            public String getCoordinatesYRange() { return coordinatesYRange; }
//            public String getColor() { return color; }
//            public String getType() { return type; }
//            public OffsetDateTime getCreationDateGt() { return creationDateGt; }
//            public OffsetDateTime getCreationDateLt() { return creationDateLt; }
//            public String getCreationDateRange() { return creationDateRange; }
//        }
//}}
//
//

package dragon.adapter.rest.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.OffsetDateTime;
import java.util.List;

public class SortDTO {
    private String by;
    private String order;

    // Конструктор по умолчанию
    public SortDTO() {}

    public SortDTO(String by, String order) {
        this.by = by;
        this.order = order;
    }

    public String getBy() { return by; }
    public void setBy(String by) { this.by = by; }

    public String getOrder() { return order; }
    public void setOrder(String order) { this.order = order; }

    // Сделать статическим
    public static class DragonSearchRequestDTO {
        private DragonSearchFilters filters;
        private List<SortDTO> sort;

        @Min(1)
        private Integer page;

        @Min(1)
        @Max(100)
        private Integer size;

        // Конструктор по умолчанию
        public DragonSearchRequestDTO() {}

        public DragonSearchRequestDTO(DragonSearchFilters filters, List<SortDTO> sort, Integer page, Integer size) {
            this.filters = filters;
            this.sort = sort;
            this.page = page;
            this.size = size;
        }

        // Геттеры и сеттеры
        public DragonSearchFilters getFilters() { return filters; }
        public void setFilters(DragonSearchFilters filters) { this.filters = filters; }

        public List<SortDTO> getSort() { return sort; }
        public void setSort(List<SortDTO> sort) { this.sort = sort; }

        public Integer getPage() { return page; }
        public void setPage(Integer page) { this.page = page; }

        public Integer getSize() { return size; }
        public void setSize(Integer size) { this.size = size; }
    }

    // Сделать статическим
    public static class DragonSearchFilters {
        private Long id;
        private Long idGt;
        private Long idLt;
        private String idRange;
        private String name;
        private String nameContains;
        private Integer age;
        private Integer ageGt;
        private Integer ageLt;
        private String ageRange;
        private Long coordinatesX;
        private Long coordinatesXGt;
        private Long coordinatesXLt;
        private String coordinatesXRange;
        private Double coordinatesY;
        private Double coordinatesYGt;
        private Double coordinatesYLt;
        private String coordinatesYRange;
        private String color;
        private String type;
        private OffsetDateTime creationDateGt;
        private OffsetDateTime creationDateLt;
        private String creationDateRange;

        // Конструктор по умолчанию
        public DragonSearchFilters() {}

        public DragonSearchFilters(Long id, Long idGt, Long idLt, String idRange,
                                   String name, String nameContains,
                                   Integer age, Integer ageGt, Integer ageLt, String ageRange,
                                   Long coordinatesX, Long coordinatesXGt, Long coordinatesXLt, String coordinatesXRange,
                                   Double coordinatesY, Double coordinatesYGt, Double coordinatesYLt, String coordinatesYRange,
                                   String color, String type,
                                   OffsetDateTime creationDateGt, OffsetDateTime creationDateLt, String creationDateRange) {
            this.id = id;
            this.idGt = idGt;
            this.idLt = idLt;
            this.idRange = idRange;
            this.name = name;
            this.nameContains = nameContains;
            this.age = age;
            this.ageGt = ageGt;
            this.ageLt = ageLt;
            this.ageRange = ageRange;
            this.coordinatesX = coordinatesX;
            this.coordinatesXGt = coordinatesXGt;
            this.coordinatesXLt = coordinatesXLt;
            this.coordinatesXRange = coordinatesXRange;
            this.coordinatesY = coordinatesY;
            this.coordinatesYGt = coordinatesYGt;
            this.coordinatesYLt = coordinatesYLt;
            this.coordinatesYRange = coordinatesYRange;
            this.color = color;
            this.type = type;
            this.creationDateGt = creationDateGt;
            this.creationDateLt = creationDateLt;
            this.creationDateRange = creationDateRange;
        }

        // Геттеры и сеттеры для всех полей
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public Long getIdGt() { return idGt; }
        public void setIdGt(Long idGt) { this.idGt = idGt; }

        public Long getIdLt() { return idLt; }
        public void setIdLt(Long idLt) { this.idLt = idLt; }

        public String getIdRange() { return idRange; }
        public void setIdRange(String idRange) { this.idRange = idRange; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getNameContains() { return nameContains; }
        public void setNameContains(String nameContains) { this.nameContains = nameContains; }

        public Integer getAge() { return age; }
        public void setAge(Integer age) { this.age = age; }

        public Integer getAgeGt() { return ageGt; }
        public void setAgeGt(Integer ageGt) { this.ageGt = ageGt; }

        public Integer getAgeLt() { return ageLt; }
        public void setAgeLt(Integer ageLt) { this.ageLt = ageLt; }

        public String getAgeRange() { return ageRange; }
        public void setAgeRange(String ageRange) { this.ageRange = ageRange; }

        public Long getCoordinatesX() { return coordinatesX; }
        public void setCoordinatesX(Long coordinatesX) { this.coordinatesX = coordinatesX; }

        public Long getCoordinatesXGt() { return coordinatesXGt; }
        public void setCoordinatesXGt(Long coordinatesXGt) { this.coordinatesXGt = coordinatesXGt; }

        public Long getCoordinatesXLt() { return coordinatesXLt; }
        public void setCoordinatesXLt(Long coordinatesXLt) { this.coordinatesXLt = coordinatesXLt; }

        public String getCoordinatesXRange() { return coordinatesXRange; }
        public void setCoordinatesXRange(String coordinatesXRange) { this.coordinatesXRange = coordinatesXRange; }

        public Double getCoordinatesY() { return coordinatesY; }
        public void setCoordinatesY(Double coordinatesY) { this.coordinatesY = coordinatesY; }

        public Double getCoordinatesYGt() { return coordinatesYGt; }
        public void setCoordinatesYGt(Double coordinatesYGt) { this.coordinatesYGt = coordinatesYGt; }

        public Double getCoordinatesYLt() { return coordinatesYLt; }
        public void setCoordinatesYLt(Double coordinatesYLt) { this.coordinatesYLt = coordinatesYLt; }

        public String getCoordinatesYRange() { return coordinatesYRange; }
        public void setCoordinatesYRange(String coordinatesYRange) { this.coordinatesYRange = coordinatesYRange; }

        public String getColor() { return color; }
        public void setColor(String color) { this.color = color; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public OffsetDateTime getCreationDateGt() { return creationDateGt; }
        public void setCreationDateGt(OffsetDateTime creationDateGt) { this.creationDateGt = creationDateGt; }

        public OffsetDateTime getCreationDateLt() { return creationDateLt; }
        public void setCreationDateLt(OffsetDateTime creationDateLt) { this.creationDateLt = creationDateLt; }

        public String getCreationDateRange() { return creationDateRange; }
        public void setCreationDateRange(String creationDateRange) { this.creationDateRange = creationDateRange; }
    }
}
