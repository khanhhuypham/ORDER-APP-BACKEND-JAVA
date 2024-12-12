package com.ra.orderapp_java.service.table;

import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.TableEntity;
import com.ra.orderapp_java.repository.AreaRepository;
import com.ra.orderapp_java.repository.TableRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements TableService{
    public final TableRepository tableRepo;
    public final AreaRepository areaRepo;


    public TableServiceImpl(TableRepository tableRepo, AreaRepository areaRepo) {
        this.tableRepo = tableRepo;
        this.areaRepo = areaRepo;
    }

    @Override
    public List<TableResponseDTO> findAll() {
        List<TableResponseDTO> list = new ArrayList();
        for(TableEntity table : tableRepo.findAll()) {
            list.add(new TableResponseDTO(table));
        }
        return list;
    }


    @Override
    public TableResponseDTO create(Long id,TableRequestDTO dto) {
        Area area = areaRepo.findById(id).orElse(null);
        System.out.println(dto.toString());
        System.out.println(area);

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
    public TableResponseDTO findById(Long id) {
        TableEntity table = tableRepo.findById(id).orElse(null);
        return table == null ? null : new TableResponseDTO(table);
    }

    @Override
    public void delete(long id) {
        tableRepo.deleteById(id);
    }
}
