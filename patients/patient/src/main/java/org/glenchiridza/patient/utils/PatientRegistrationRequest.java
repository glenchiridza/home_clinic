package org.glenchiridza.patient.utils;

public record PatientRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String phone,
        String nationalId,
        String address
) {
}
