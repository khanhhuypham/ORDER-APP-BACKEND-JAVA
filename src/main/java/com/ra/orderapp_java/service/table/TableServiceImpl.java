package com.ra.orderapp_java.service.table;

import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.dto.table.BatchCreateTableDto;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.TableEntity;
import com.ra.orderapp_java.repository.AreaRepository;
import com.ra.orderapp_java.repository.TableRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService{

    private  final TableRepository tableRepo;
    private  final AreaRepository areaRepo;


    @Override
    public List<TableResponseDTO> findAll(Long areaId) {
        List<TableResponseDTO> list = new ArrayList();

        if (areaId == -1){
            for(TableEntity table : tableRepo.findAll()) {
                list.add(new TableResponseDTO(table));
            }
        }else{
            for(TableEntity table : tableRepo.findAllByAreaId(areaId)) {
                list.add(new TableResponseDTO(table));
            }
        }

        return list;
    }




    @Override
    public TableResponseDTO create(Long id,TableRequestDTO dto) {

        Area area = areaRepo.findById(dto.getArea_id()).orElse(null);

        System.out.println(areaRepo.findAll());
        if(area != null) {
            TableEntity table = tableRepo.save(TableEntity.builder()
                .id(id)
                .name(dto.getName())
                .active(dto.getActive())
                .area(area)
                .build());
            return new TableResponseDTO(table);
        }else{
            return null;
        }
    }

    @Override
    public List<TableResponseDTO> batchCreate(BatchCreateTableDto dto) {

        List<TableEntity> entities = dto.getTables().stream()
                .map(table -> {
                    Area area = areaRepo.findById(table.getArea_id()).orElse(null);
                    return TableEntity.builder()
                            .name(table.getName())
                            .active(table.getActive())
                            .area(area) // Uncomment and assign area value if needed
                            .build();
                })
                .collect(Collectors.toList());

        List<TableEntity> savedEntities = tableRepo.saveAll(entities);

        return savedEntities.stream()
                .map(TableResponseDTO::new)
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
