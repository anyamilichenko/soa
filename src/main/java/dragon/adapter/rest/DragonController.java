package dragon.adapter.rest;


import dragon.adapter.rest.dto.DragonRequestDTO;
import dragon.adapter.rest.dto.DragonResponseDTO;
import dragon.adapter.rest.dto.PagedResponseDTO;
import dragon.adapter.rest.dto.SortDTO;
import dragon.service.DragonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utils.ResponseUtil;

import java.util.Map;

@RestController
@RequestMapping("/dragons")
@Validated
@Tag(
        name = "Dragons",
        description = "Управление коллекцией объектов класса Dragons"
)
public class DragonController {

    private final DragonService dragonService;

    public DragonController(DragonService dragonService) {
        this.dragonService = dragonService;
    }

    @PostMapping
    @Operation(
            summary = "Добавить нового дракона"
    )
    public ResponseEntity<DragonResponseDTO> createDragon(
            @Valid
            @RequestBody
            DragonRequestDTO dragonRequestDTO
    ) {
        DragonResponseDTO dto = dragonService.createDragon(dragonRequestDTO);
        return ResponseUtil.buildCreateResponse(dto);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить дракона по ID"
    )
    public ResponseEntity<DragonResponseDTO> getDragon(@PathVariable Long id) {
        DragonResponseDTO dto = dragonService.findFullById(id);
        return ResponseUtil.buildSuccessResponse(dto);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Обновить дракона по ID"
    )
    public ResponseEntity<DragonResponseDTO> updateDragon(
            @PathVariable Long id,
            @Valid
            @RequestBody DragonRequestDTO dragonRequestDTO
    ) {
        DragonResponseDTO dto = dragonService.updateDragon(id, dragonRequestDTO);
        return ResponseUtil.buildSuccessResponse(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить дракона по ID"
    )
    public ResponseEntity<Void> deleteDragon(@PathVariable Long id) {
        dragonService.deleteById(id);
        return ResponseUtil.buildSuccessResponse(null);
    }

    @DeleteMapping("/delete-by-color/{color}")
    @Operation(
            summary = "Удалить дракона по цвету",
            description = "Удаляет один (любой) дракона с указанным цветом"
    )
    public ResponseEntity<Void> deleteByColor(@PathVariable String color) {
        dragonService.deleteOneByColor(color);
        return ResponseUtil.buildSuccessResponse(null);
    }

    @GetMapping("/average-age")
    @Operation(
            summary = "Средний возраст драконов",
            description = "Возвращает среднее значение поля age для всех драконов"
    )
    public ResponseEntity<Map<String, Double>> getAverageAge() {
        Double averageAge = dragonService.getAverageAge();

        return ResponseUtil.buildSuccessResponse(Map.of("averageAge", averageAge != null ? averageAge : 0.0));
    }




    @GetMapping("/count-older-than/{age}")
    @Operation(
            summary = "Количество драконов старше указанного возраста",
            description = "Возвращает количество драконов, возраст которых больше заданного"
    )
    public ResponseEntity<Map<String, Long>> countOlderThan(@PathVariable Integer age) {
        Integer count = dragonService.countOlderThan(age);

        return ResponseUtil.buildSuccessResponse(Map.of("count", count != null ? count : 0L));
    }



    @PostMapping("/search")
    @Operation(summary = "Поиск организаций с фильтрами, сортировкой и пагинацией")
    public ResponseEntity<PagedResponseDTO<DragonResponseDTO>> search(
            @Valid
            @RequestBody
            SortDTO.DragonSearchRequestDTO request
    ) {
        return ResponseUtil.buildSuccessResponse(dragonService.search(request));
    }
}

