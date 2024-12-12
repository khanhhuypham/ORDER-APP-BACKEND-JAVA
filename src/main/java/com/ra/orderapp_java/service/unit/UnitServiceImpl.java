package com.ra.orderapp_java.service.unit;

import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.dto.unit.UnitRequestDTO;
import com.ra.orderapp_java.model.dto.unit.UnitResponseDTO;
import com.ra.orderapp_java.model.entity.TableEntity;
import com.ra.orderapp_java.model.entity.Unit;
import com.ra.orderapp_java.repository.TableRepository;
import com.ra.orderapp_java.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService{
    public final UnitRepository unitRepo;

    public UnitServiceImpl(UnitRepository unitRepo) {
        this.unitRepo = unitRepo;
    }


    @Override
    public List<UnitResponseDTO> findAll() {
        List<UnitResponseDTO> list = new ArrayList();
        for(Unit unit : unitRepo.findAll()) {
            list.add(new UnitResponseDTO(unit));
        }

        return list;
    }

    @Override
    public UnitResponseDTO create(Long id, UnitRequestDTO dto) {
        Unit unit = unitRepo.save(Unit.builder()
                .id(id)
                .name(dto.getName())
                .build());
        return new UnitResponseDTO(unit);
    }

    @Override
    public UnitResponseDTO findById(Long id) {
        Unit unit = unitRepo.findById(id).orElse(null);
        return unit == null ? null : new UnitResponseDTO(unit);
    }

    @Override
    public void delete(long id) {
        unitRepo.deleteById(id);
    }
}
