package org.glenchiridza.restclients.util;

public record NotificationRequest(
        Integer toPatientId,
        String toPatientEmail,
        String message
){

}