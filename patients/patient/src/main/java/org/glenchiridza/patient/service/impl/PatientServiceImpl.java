package org.glenchiridza.patient.service.impl;

import lombok.AllArgsConstructor;
import org.glenchiridza.patient.model.Patient;
import org.glenchiridza.patient.repository.PatientRepository;
import org.glenchiridza.patient.service.api.PatientService;
import org.glenchiridza.patient.utils.PatientRegistrationRequest;
import org.glenchiridza.restclients.insolvent.InsolventClient;
import org.glenchiridza.restclients.insolvent.util.InsolventCheckResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
//    private final RestTemplate restTemplate;
    private final InsolventClient insolventClient;

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


        //todo: check if email is valid
        //todo: check if email not taken


        patientRepository.saveAndFlush(patient);

//        InsolventCheckResponse insolventCheckResponse =restTemplate.getForObject(
//                "http://INSOLVENT/api/insolvents/{patientId}",
//                InsolventCheckResponse.class,
//                patient.getId()
//        );

        InsolventCheckResponse insolventCheckResponse = insolventClient.isInsolvent(patient.getId());

        if(insolventCheckResponse !=null && insolventCheckResponse.isInsolvent()){
            throw new IllegalStateException("This patient doesn't settle debts and currently has other debts");
        }

        //todo: send notification


    }
}
