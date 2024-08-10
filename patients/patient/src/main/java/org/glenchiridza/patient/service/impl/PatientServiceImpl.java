package org.glenchiridza.patient.service.impl;

import lombok.AllArgsConstructor;
import org.glenchiridza.patient.model.Patient;
import org.glenchiridza.patient.repository.PatientRepository;
import org.glenchiridza.patient.service.api.PatientService;
import org.glenchiridza.patient.utils.PatientRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public void registerPatient(PatientRegistrationRequest requestDto) {
        Patient patient = Patient.builder()
                .firstName(requestDto.firstName())
                .lastName(requestDto.lastName())
                .email(requestDto.email())
                .phone(requestDto.phone())
                .nationalId(requestDto.nationalId())
                .address(requestDto.address())
                .build();


        //todo check if email is valid
        //todo check if email not taken

        patientRepository.save(patient);

        //ended at :: 0013 course module


    }
}
