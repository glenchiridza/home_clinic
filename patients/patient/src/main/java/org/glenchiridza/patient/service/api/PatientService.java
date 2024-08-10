package org.glenchiridza.patient.service.api;

import org.glenchiridza.patient.utils.PatientRegistrationRequest;
import org.springframework.stereotype.Service;

public interface PatientService {

    void registerPatient(PatientRegistrationRequest requestDto);
}
