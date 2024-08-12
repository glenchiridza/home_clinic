package org.glenchiridza.restclients.util;

public record NotificationRequest(
        String toPatientId,
        String toPatientEmail,
        String message
){

}