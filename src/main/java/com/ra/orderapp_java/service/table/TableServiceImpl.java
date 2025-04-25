package com.ra.orderapp_java.service.table;
import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.dto.ItemOnOrder.ItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.order.OrderRequestDTO;
import com.ra.orderapp_java.model.dto.order.OrderResponseDTO;
import com.ra.orderapp_java.model.dto.table.BatchCreateTableDto;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;

import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;
import com.ra.orderapp_java.model.entity.Order;
import com.ra.orderapp_java.model.entity.TableEntity;

import com.ra.orderapp_java.repository.TableRepository;

import com.ra.orderapp_java.service.area.AreaService;
import com.ra.orderapp_java.service.itemOnOrder.ItemOnOrderService;
import com.ra.orderapp_java.service.itemOnOrder.ItemOnOrderServiceImpl;
import com.ra.orderapp_java.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService{
    private final TableRepository tableRepo;
    private final AreaService areaService;
    private final OrderService orderService;
    private final ItemOnOrderService itemOnOrderService;

    @Override
    public List<TableEntity> findAllByCondition(Long areaId,Boolean active) {
        return tableRepo.findAllByCondition(areaId,active);
    }

    @Override
    public List<TableEntity> findAllForManagement(Long areaId) {
        return tableRepo.findAllForManagement(areaId);
    }

    @Override
    public TableEntity assignOrderToTable(Order order, TableEntity table) throws CustomException {
        return null;
    }

    @Override
    public void moveTable(Long fromId, Long toId) throws CustomException{
        Order order = orderService.findIncompleteOrderByTableId(fromId);
        Order orderOfDestinationTable = orderService.findIncompleteOrderByTableId(toId);
        TableEntity table = this.findById(toId);

        if (order == null){
            throw new CustomException(
                String.format("Không tìm thấy đơn hàng nào trên bàn %s",table.getName())
                ,HttpStatus.BAD_REQUEST
            );
        }else if (orderOfDestinationTable != null){
            throw new CustomException(
                String.format("Bàn (%s) chuyển đến đang được sử dụng",table.getName()),
                HttpStatus.BAD_REQUEST
            );
        }

        order.setTable(table);
        OrderRequestDTO dto = new OrderRequestDTO();
        dto.setTable_id(order.getTable().getId());
        dto.setUser_id(order.getUser().getId());
        dto.setOrder_type(order.getType());
        orderService.create(order.getId(),dto);
    }

    @Override
    public TableEntity mergeTable(Long destination_table_id, List<Long> idList) throws CustomException {
        Order order = orderService.findIncompleteOrderByTableId(destination_table_id);
        TableEntity table = this.findById(destination_table_id);
        if (order == null){
            throw new CustomException("No any order in this table",HttpStatus.BAD_REQUEST);
        }

        for (Long id : idList){

            Order orderOfTargetTable =  orderService.findIncompleteOrderByTableId(id);

            if (orderOfTargetTable != null){
                for (ItemOnOrder element : itemOnOrderService.findItemsByOrderId(orderOfTargetTable.getId())) {
                    itemOnOrderService.reassignOrderItemToOrder(order, element);
                }
            }
        }

        table.setMerge_tables(idList);
        return tableRepo.save(table);
    }

    @Override
    public void splitItem(Long fromId, Long toId) throws CustomException {

    }


    public Boolean checkTableAvailable(Long id) {
        TableEntity table = tableRepo.findById(id).orElse(null);
        if (table == null) {
            return false;
        }else{
            /*
            * if there is any table which has one order with status of != complete.
            * this means that table is unavailable
             * */
            if (table.getOrders().stream().anyMatch(order -> order.getStatus() != ORDER_STATUS.COMPLETE)) {
                return false;
            }else{
                return true;
            }

        }

    }


    @Override
    public TableEntity create(Long id, TableRequestDTO dto) throws CustomException {
        Area area = areaService.findById(dto.getArea_id());

        TableEntity table = id != null
        ? this.findById(id)
        : TableEntity.builder().build();

        table.setName(dto.getName());
        table.setActive(dto.getActive());
        table.setArea(area);

        return tableRepo.save(table);
    }

    @Override
    public List<TableEntity> batchCreate(BatchCreateTableDto dto) throws CustomException {

        List<TableEntity> entities = dto.getTables().stream().map(table -> {

            Area area = null;
            try {
                area = areaService.findById(table.getArea_id());
            } catch (CustomException e) {
                throw new RuntimeException(e);
            }

            return TableEntity.builder()
                .name(table.getName())
                .active(table.getActive())
                .area(area) // Uncomment and assign area value if needed
                .build();

        }).collect(Collectors.toList());

        return tableRepo.saveAll(entities);
    }


    @Override
    public TableEntity findById(Long id) throws CustomException {
        TableEntity table = tableRepo.findById(id).orElse(null);

        if (table == null){
            throw new CustomException("Table Not found", HttpStatus.NOT_FOUND);
        }

        return table;
    }

    @Override
    public void delete(long id) {
        tableRepo.deleteById(id);
    }
}
