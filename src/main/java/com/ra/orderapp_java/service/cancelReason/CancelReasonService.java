package com.ra.orderapp_java.service.cancelReason;


import com.ra.orderapp_java.model.dto.cancelReason.CancelReasonRequestDTO;
import com.ra.orderapp_java.model.dto.cancelReason.CancelReasonResponseDTO;

import java.util.List;

public interface CancelReasonService {
    List<CancelReasonResponseDTO> findAll();
    CancelReasonResponseDTO create(Long id, CancelReasonRequestDTO dto);
    CancelReasonResponseDTO findById(Long id);
    void delete(long id);
}
