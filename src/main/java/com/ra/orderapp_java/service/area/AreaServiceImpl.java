package com.ra.orderapp_java.service.area;

import com.ra.orderapp_java.model.dto.area.AreaRequestDTO;
import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService{
    private final AreaRepository areaRepo;


    @Override
    public List<AreaResponseDTO> findAll() {

        List<AreaResponseDTO> list = new ArrayList();
        for(Area area : areaRepo.findAll()) {
            list.add(new AreaResponseDTO(area));
        }
        return list;
    }


    @Override
    public AreaResponseDTO create(Long id,AreaRequestDTO dto) {
        System.out.println(id);

        Area savedArea = areaRepo.save(Area.builder()
                .id(id)
                .name(dto.getName())
                .active(dto.getActive())
                .build());
        return new AreaResponseDTO(savedArea);
    }

    @Override
    public AreaResponseDTO findById(Long id){
        Area area = areaRepo.findById(id).orElse(null);
        return area == null ? null : new AreaResponseDTO(area);
    }

    @Override
    public void delete(long id) {
        areaRepo.deleteById(id);
    }
}
