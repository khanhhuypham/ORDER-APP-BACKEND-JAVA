package com.ra.orderapp_java.service.table;
import com.ra.orderapp_java.model.dto.table.BatchCreateTableDto;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.TableEntity;
import com.ra.orderapp_java.repository.AreaRepository;
import com.ra.orderapp_java.repository.TableRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService{

    private final TableRepository tableRepo;
    private final AreaRepository areaRepo;


    @Override
    public List<TableResponseDTO> findAllByCondition(Long areaId,Boolean active) {
        List<TableResponseDTO> list = new ArrayList();

        for(TableEntity table : tableRepo.findAllByCondition(areaId,active)) {
            list.add(new TableResponseDTO(table));
        }

        return list;
    }

    @Override
    public List<TableResponseDTO> findAllForManagement(Long areaId) {
        List<TableResponseDTO> list = new ArrayList();

        for(TableEntity table : tableRepo.findAllForManagement(areaId)) {
            TableResponseDTO dto = new TableResponseDTO(table);
            dto.setOrder(null);
            list.add(dto);
        }

        return list;
    }



    @Override
    public TableResponseDTO create(Long id,TableRequestDTO dto) {
        Area area = areaRepo.findById(dto.getArea_id()).orElse(null);
        System.out.println(area == null);
        if(area == null) {
            return null;
        }

        TableEntity table = null;

        if (id != null){
            TableEntity foundTable = tableRepo.findById(id).orElse(null);

            table = tableRepo.save(TableEntity.builder()
                .id(id)
                .name(dto.getName())
                .active(dto.getActive())
                .area(area)
                .build());
        }else{
            table = tableRepo.save(TableEntity.builder()
                .name(dto.getName())
                .active(dto.getActive())
                .area(area)
                .build());
        }

        return new TableResponseDTO(table);
    }

    @Override
    public List<TableResponseDTO> batchCreate(BatchCreateTableDto dto) {

        List<TableEntity> entities = dto.getTables().stream().map(table -> {
            Area area = areaRepo.findById(table.getArea_id()).orElse(null);
            return TableEntity.builder()
                .name(table.getName())
                .active(table.getActive())
                .area(area) // Uncomment and assign area value if needed
                .build();
        }).collect(Collectors.toList());

        List<TableEntity> savedEntities = tableRepo.saveAll(entities);

        return savedEntities.stream()
            .map(table -> new TableResponseDTO(table))
            .collect(Collectors.toList());

    }


    @Override
    public TableResponseDTO findById(Long id) {
        TableEntity table = tableRepo.findById(id).orElse(null);

        return table == null ? null : new TableResponseDTO(table);
    }

    @Override
    public void delete(long id) {
        tableRepo.deleteById(id);
    }
}
