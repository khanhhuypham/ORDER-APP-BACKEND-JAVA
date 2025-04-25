package com.ra.orderapp_java.service.unit;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.dto.unit.UnitRequestDTO;
import com.ra.orderapp_java.model.dto.unit.UnitResponseDTO;
import com.ra.orderapp_java.model.entity.TableEntity;
import com.ra.orderapp_java.model.entity.Unit;
import com.ra.orderapp_java.repository.TableRepository;
import com.ra.orderapp_java.repository.UnitRepository;
import org.springframework.http.HttpStatus;
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
    public List<Unit> findAll() {
        return unitRepo.findAll();
    }

    @Override
    public Unit create(Long id, UnitRequestDTO dto) throws CustomException {

        Unit unit = id == null ? Unit.builder().build() : this.findById(id);

        unit.setName(dto.getName());

        return unitRepo.save(unit);
    }

    @Override
    public Unit findById(Long id) throws CustomException {

        Unit unit = unitRepo.findById(id).orElse(null);
        if (unit == null){
            throw new CustomException("Unit Not found", HttpStatus.NOT_FOUND);
        }

        return unit;
    }

    @Override
    public void delete(long id)  throws CustomException {
        unitRepo.deleteById(id);
    }
}
