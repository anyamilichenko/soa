package dragonHead.service;

import dragonHead.adapter.jdbc.DragonHeadDAO;
import dragonHead.adapter.rest.dto.DragonHeadDTO;
import dragonHead.domain.DragonHead;
import errorhandling.domain.DragonHeadCreateException;
import errorhandling.domain.NoDragonHeadFoundException;
import mapstruct.DragonHeadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DragonHeadService {

    private final DragonHeadDAO dragonHeadDAO;
    private final DragonHeadMapper dragonHeadMapper;

    public DragonHeadService(DragonHeadDAO dragonHeadDAO, DragonHeadMapper dragonHeadMapper) {
        this.dragonHeadDAO = dragonHeadDAO;
        this.dragonHeadMapper = dragonHeadMapper;
    }

    @Transactional
    public DragonHead createDragonHead(DragonHeadDTO dto) {
        DragonHead dragonHead = dragonHeadMapper.fromDTO(dto);
        DragonHead result = dragonHeadDAO.insert(dragonHead);
        if (result == null) {
            throw new DragonHeadCreateException();
        }
        return result;
    }

    public DragonHead findById(Long id) {
        DragonHead address = dragonHeadDAO.findById(id);
        if (address == null) {
            throw new NoDragonHeadFoundException(id);
        }
        return address;
    }

    @Transactional
    public DragonHead updateById(Long id, DragonHeadDTO dto) {
        DragonHead existing = findById(id);
        DragonHead updatedAddress = new DragonHead(
                existing.getId(),
                dto.getEyesCount()
        );
        DragonHead result = dragonHeadDAO.updateById(updatedAddress);
        if (result == null) {
            throw new NoDragonHeadFoundException(id);
        }
        return result;
    }
}
