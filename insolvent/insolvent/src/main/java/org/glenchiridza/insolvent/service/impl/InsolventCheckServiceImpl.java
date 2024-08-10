package org.glenchiridza.insolvent.service.impl;

import lombok.AllArgsConstructor;
import org.glenchiridza.insolvent.model.InsolventCheckHistory;
import org.glenchiridza.insolvent.repository.InsolventCheckHistoryRepository;
import org.glenchiridza.insolvent.service.api.InsolventCheckService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class InsolventCheckServiceImpl implements InsolventCheckService {

    private final InsolventCheckHistoryRepository insolventCheckHistoryRepository;

    @Override
    public boolean isInsolventPatient(Integer patientId) {
        insolventCheckHistoryRepository.save(
                InsolventCheckHistory.builder()
                        .patientId(patientId)
                        .isInsolvent(false)
                        .createdAt(LocalDateTime.now())
                        .build()

        );
        return false;
    }
}
