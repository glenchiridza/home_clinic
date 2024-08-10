package org.glenchiridza.insolvent.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.glenchiridza.insolvent.service.api.InsolventCheckService;
import org.glenchiridza.insolvent.util.InsolventCheckResponse;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/insolvents")
@AllArgsConstructor
public class InsolventController {

    private final InsolventCheckService insolventCheckService;

    @GetMapping("{patientId}")
    public InsolventCheckResponse isInsolvent(
            @PathVariable("patientId") Integer patientId
    ){
        boolean isInsolventPatient = insolventCheckService
                .isInsolventPatient(patientId);
        log.info("Insolvent patient check with id :: {}",patientId);
        return new InsolventCheckResponse(isInsolventPatient);

    }
}
