package org.glenchiridza.patient.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.glenchiridza.patient.service.api.PatientService;
import org.glenchiridza.patient.utils.PatientRegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public void registerPatient(@RequestBody PatientRegistrationRequest requestDto){
        log.info("New patient registered :: {} ",requestDto);
        patientService.registerPatient(requestDto);
    }

}
