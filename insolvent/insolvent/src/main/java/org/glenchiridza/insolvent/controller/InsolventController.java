package org.glenchiridza.insolvent.controller;

import lombok.AllArgsConstructor;
import org.glenchiridza.insolvent.service.api.InsolventCheckService;
import org.glenchiridza.insolvent.util.InsolventCheckResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/insolvents")
@AllArgsConstructor
public class InsolventController {

    private final InsolventCheckService insolventCheckService;

    @GetMapping("{patientId")
    public InsolventCheckResponse isInsolvent(
            @PathVariable("patientId") Integer patientId
    ){
        boolean isInsolventPatient = insolventCheckService
                .isInsolventPatient(patientId);
        return new InsolventCheckResponse(isInsolventPatient);

    }
}
