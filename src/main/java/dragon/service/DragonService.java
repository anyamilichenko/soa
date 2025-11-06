package dragon.service;


import coordinates.adapter.rest.dto.CoordinatesDTO;
import coordinates.domain.Coordinates;
import coordinates.service.CoordinatesService;
import dragon.adapter.jdbc.DragonDAO;
import dragon.adapter.rest.dto.*;
import dragon.domain.Dragon;
import dragonHead.adapter.rest.dto.DragonHeadDTO;
import dragonHead.domain.DragonHead;
import dragonHead.service.DragonHeadService;
import errorhandling.domain.DragonCreateException;
import errorhandling.domain.NoDragonFoundException;
import mapstruct.CoordinatesMapper;
import mapstruct.DragonHeadMapper;
import mapstruct.DragonMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DragonService {

    private final DragonDAO dragonDAO;
    private final DragonHeadService dragonHeadService;
    private final CoordinatesService coordinatesService;
    private final DragonMapper dragonMapper;
    private final DragonHeadMapper dragonHeadMapper;
    private final CoordinatesMapper coordinatesMapper;

    public DragonService(DragonDAO dragonDAO, DragonHeadService dragonHeadService,
                               CoordinatesService coordinatesService, DragonMapper dragonMapper,
                         DragonHeadMapper dragonHeadMapper, CoordinatesMapper coordinatesMapper) {
        this.dragonDAO = dragonDAO;
        this.dragonHeadService = dragonHeadService;
        this.coordinatesService = coordinatesService;
        this.dragonMapper = dragonMapper;
        this.dragonHeadMapper = dragonHeadMapper;
        this.coordinatesMapper = coordinatesMapper;
    }

    @Transactional
    public DragonResponseDTO createDragon(DragonRequestDTO dto) {
        DragonHead dragonHead = null;
        if (dto.getHead() != null) {
            dragonHead = dragonHeadService.createDragonHead(dto.getHead());
        }

        Coordinates coordinates = coordinatesService.createCoordinates(dto.getCoordinates());

        Dragon dragon;
        if (coordinates.getId() != null) {
            Dragon dr = dragonMapper.fromRequest(dto, coordinates.getId(), dragonHead != null ? dragonHead.getId() : null);
            dragon = dragonDAO.insert(dr);
        } else {
            throw new DragonCreateException();
        }

        if (dragon == null) {
            throw new DragonCreateException();
        }

        return dragonMapper.toResponse(
                dragon,
                coordinatesMapper.toDTO(coordinates),
                dragonHead != null ? dragonHeadMapper.toDTO(dragonHead) : null
        );
    }

    public DragonResponseDTO findFullById(Long id) {
        Dragon dragon = dragonDAO.findById(id);
        if (dragon == null) {
            throw new NoDragonFoundException(id);
        }

        DragonHeadDTO addressDTO = null;
        if (dragon.getHeadId() != null) {
            DragonHead dragonHead = dragonHeadService.findById(dragon.getHeadId());
            addressDTO = dragonHeadMapper.toDTO(dragonHead);
        }

        Coordinates coordinates = coordinatesService.findById(dragon.getCoordinatesId());
        CoordinatesDTO coordinatesDTO = coordinatesMapper.toDTO(coordinates);

        return dragonMapper.toResponse(dragon, coordinatesDTO, addressDTO);
    }

    @Transactional
    public DragonResponseDTO updateDragon(Long id, DragonRequestDTO dto) {
        Dragon existing = dragonDAO.findById(id);
        if (existing == null) {
            throw new NoDragonFoundException(id);
        }

        Dragon toUpdate = dragonMapper.fromRequest(
                dto,
                existing.getCoordinatesId(),
                existing.getHeadId()
        );

        Dragon updatedOrganization = dragonDAO.updateById(toUpdate);
        if (updatedOrganization == null) {
            throw new NoDragonFoundException(id);
        }

        DragonHead updatedDragonHead = null;
        if (dto.getHead() != null && existing.getHeadId() != null) {
            updatedDragonHead = dragonHeadService.updateById(existing.getHeadId(), dto.getHead());
        }

        Coordinates updatedCoordinates = coordinatesService.updateById(
                existing.getCoordinatesId(),
                dto.getCoordinates()
        );

        return dragonMapper.toResponse(
                updatedOrganization,
                coordinatesMapper.toDTO(updatedCoordinates),
                updatedDragonHead != null ? dragonHeadMapper.toDTO(updatedDragonHead) : null
        );
    }

    @Transactional
    public void deleteById(Long id) {
        Dragon dragon = dragonDAO.findById(id);
        if (dragon == null) {
            throw new NoDragonFoundException(id);
        }
        dragonDAO.deleteById(id);
    }

    @Transactional
    public void deleteOneByColor(String color) {
        try {
            Dragon.Color dragonColor = Dragon.Color.valueOf(color.toUpperCase());
            boolean deleted = dragonDAO.deleteOneByColor(dragonColor);
            if (!deleted) {
                throw new NoDragonFoundException(color);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неверный цвет: " + color);
        }
    }

    public Double getAverageAge() {
        return dragonDAO.getAverageAge();
    }

    public Integer countOlderThan(Integer age) {
        return dragonDAO.countOlderThan(age);
    }


    @Transactional(readOnly = true)
    public PagedResponseDTO<DragonResponseDTO> search(SortDTO.DragonSearchRequestDTO request) {
        Object[] result = dragonDAO.search(request);

        @SuppressWarnings("unchecked")
        List<Dragon> dragons = (List<Dragon>) result[0];
        Long total = (Long) result[1];

        var items = dragons.stream()
                .map(it -> {
                    Coordinates coordinates = coordinatesService.findById(it.getCoordinatesId());
                    CoordinatesDTO coordinatesDTO = coordinatesMapper.toDTO(coordinates);

                    DragonHeadDTO headDTO = null;
                    if (it.getHeadId() != null) {
                        DragonHead dragonHead = dragonHeadService.findById(it.getHeadId());
                        headDTO = dragonHeadMapper.toDTO(dragonHead);
                    }

                    return dragonMapper.toResponse(it, coordinatesDTO, headDTO);
                })
                .collect(Collectors.toList());

        Integer totalPages = request.getSize() > 0 ? (int) Math.ceil((double) total / request.getSize()) : 1;

        return new PagedResponseDTO<>(
                items,
                new PageInfoDTO(request.getPage(), total, totalPages)
        );
    }
}