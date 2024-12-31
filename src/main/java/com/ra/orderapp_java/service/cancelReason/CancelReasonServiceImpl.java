package com.ra.orderapp_java.service.cancelReason;

import com.ra.orderapp_java.model.dto.cancelReason.CancelReasonRequestDTO;
import com.ra.orderapp_java.model.dto.cancelReason.CancelReasonResponseDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import com.ra.orderapp_java.model.entity.CancelReason;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.repository.CancelReasonRepository;
import com.ra.orderapp_java.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CancelReasonServiceImpl implements CancelReasonService{
    private final CancelReasonRepository cancelReasonRepo;

    @Override
    public List<CancelReasonResponseDTO> findAll() {
        List<CancelReasonResponseDTO> list = new ArrayList<>();

        for (CancelReason reason: cancelReasonRepo.findAll()) {
            list.add(new CancelReasonResponseDTO(reason));
        }
        return list;
    }

    @Override
    public CancelReasonResponseDTO create(Long id, CancelReasonRequestDTO dto) {
        CancelReason reason = cancelReasonRepo.save(
            CancelReason.builder()
                .id(id)
                .content(dto.getContent())
                .build()
        );

        return new CancelReasonResponseDTO(reason);
    }

    @Override
    public CancelReasonResponseDTO findById(Long id) {
        CancelReason reason = cancelReasonRepo.findById(id).orElse(null);
        return reason == null ? null : new CancelReasonResponseDTO(reason);
    }

    @Override
    public void delete(long id) {
        cancelReasonRepo.deleteById(id);
    }
}
