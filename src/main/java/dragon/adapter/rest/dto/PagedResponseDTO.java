package dragon.adapter.rest.dto;

import java.util.List;

public class PagedResponseDTO<T> {
    private final List<T> items;
    private final PageInfoDTO page;

    public PagedResponseDTO(List<T> items, PageInfoDTO page) {
        this.items = items;
        this.page = page;
    }
}
