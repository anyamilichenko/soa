package coordinates.service;


import coordinates.adapter.jdbc.CoordinatesDAO;
import coordinates.adapter.rest.dto.CoordinatesDTO;
import coordinates.domain.Coordinates;
import errorhandling.domain.CoordinatesCreateException;
import errorhandling.domain.NoCoordinatesFoundException;
import mapstruct.CoordinatesMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoordinatesService {

    private final CoordinatesDAO coordinatesDAO;
    private final CoordinatesMapper coordinatesMapper;

    public CoordinatesService(CoordinatesDAO coordinatesDAO, CoordinatesMapper coordinatesMapper) {
        this.coordinatesDAO = coordinatesDAO;
        this.coordinatesMapper = coordinatesMapper;
    }

    @Transactional
    public Coordinates createCoordinates(CoordinatesDTO dto) {
        Coordinates coordinates = coordinatesMapper.fromDTO(dto);
        Coordinates result = coordinatesDAO.insert(coordinates);
        if (result == null) {
            throw new CoordinatesCreateException();
        }
        return result;
    }

    public Coordinates findById(Long id) {
        Coordinates coordinates = coordinatesDAO.findById(id);
        if (coordinates == null) {
            throw new NoCoordinatesFoundException(id);
        }
        return coordinates;
    }

    @Transactional
    public Coordinates updateById(Long id, CoordinatesDTO dto) {
        Coordinates existing = findById(id);

        Coordinates updatedCoordinates = new Coordinates(
                existing.getId(), //сохраняем тот же ID
                dto.getX(),
                dto.getY()
        );

        Coordinates result = coordinatesDAO.updateById(updatedCoordinates);
        if (result == null) {
            throw new NoCoordinatesFoundException(id);
        }
        return result;
    }
}