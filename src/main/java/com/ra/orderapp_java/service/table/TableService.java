package com.ra.orderapp_java.service.table;
import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.table.BatchCreateTableDto;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.entity.Order;
import com.ra.orderapp_java.model.entity.TableEntity;



import java.util.List;

public interface TableService{
    List<TableEntity> findAllByCondition(Long areaId,Boolean active);
    List<TableEntity> findAllForManagement(Long areaId);
    TableEntity assignOrderToTable(Order order, TableEntity table) throws CustomException;
    void moveTable(Long fromId, Long toId) throws CustomException;
    TableEntity mergeTable(Long destination_table_id, List<Long> idList) throws CustomException;
    void splitItem(Long fromId, Long toId) throws CustomException;
    TableEntity create(Long id,TableRequestDTO dto) throws CustomException;
    List<TableEntity> batchCreate(BatchCreateTableDto dto) throws CustomException;
    TableEntity findById(Long id) throws CustomException;
    void delete(long id);
}
