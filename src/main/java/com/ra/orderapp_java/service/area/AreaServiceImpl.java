package com.ra.orderapp_java.service.area;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.area.AreaRequestDTO;
import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService{
    private final AreaRepository areaRepo;


    @Override
    public List<Area> findAll(Boolean active) throws CustomException{


        return active != null
            ? areaRepo.findActiveArea(active)
            : areaRepo.findAll();
    }


    @Override
    public Area create(Long id,AreaRequestDTO dto) throws CustomException{

        Area savedArea = areaRepo.save(Area.builder()
                .id(id)
                .name(dto.getName())
                .active(dto.getActive())
                .build());

        return savedArea;
    }

    @Override
    public Area findById(Long id) throws CustomException{
        Area area = areaRepo.findById(id).orElse(null);

        if (area == null){
            throw new CustomException("Area not found", HttpStatus.NOT_FOUND);
        }

        return area;
    }

    @Override
    public void delete(long id) throws CustomException {
        areaRepo.deleteById(id);
    }
}
