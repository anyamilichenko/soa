package dragon.adapter.rest.dto;

public class PageInfoDTO {
    private final int page;
    private final long totalElements;
    private final int totalPages;

    public PageInfoDTO(int page, long totalElements, int totalPages) {
        this.page = page;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }
}
