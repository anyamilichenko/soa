//package dragon.adapter.rest.dto;
//
//public class PageInfoDTO {
//    private final int page;
//    private final long totalElements;
//    private final int totalPages;
//
//    public PageInfoDTO(int page, long totalElements, int totalPages) {
//        this.page = page;
//        this.totalElements = totalElements;
//        this.totalPages = totalPages;
//    }
//}

package dragon.adapter.rest.dto;

public class PageInfoDTO {
    private int page;
    private long totalElements;
    private int totalPages;

    // Конструктор по умолчанию
    public PageInfoDTO() {}

    public PageInfoDTO(int page, long totalElements, int totalPages) {
        this.page = page;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    // Геттеры и сеттеры
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public long getTotalElements() { return totalElements; }
    public void setTotalElements(long totalElements) { this.totalElements = totalElements; }

    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
}
