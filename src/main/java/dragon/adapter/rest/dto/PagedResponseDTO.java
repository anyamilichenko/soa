//package dragon.adapter.rest.dto;
//
//import java.util.List;
//
//public class PagedResponseDTO<T> {
//    private final List<T> items;
//    private final PageInfoDTO page;
//
//    public PagedResponseDTO(List<T> items, PageInfoDTO page) {
//        this.items = items;
//        this.page = page;
//    }
//}


package dragon.adapter.rest.dto;

import java.util.List;

public class PagedResponseDTO<T> {
    private List<T> items;
    private PageInfoDTO page;

    // Конструктор по умолчанию
    public PagedResponseDTO() {}

    public PagedResponseDTO(List<T> items, PageInfoDTO page) {
        this.items = items;
        this.page = page;
    }

    // Геттеры и сеттеры
    public List<T> getItems() { return items; }
    public void setItems(List<T> items) { this.items = items; }

    public PageInfoDTO getPage() { return page; }
    public void setPage(PageInfoDTO page) { this.page = page; }
}