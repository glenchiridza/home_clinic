package org.glenchiridza.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "org.glenchiridza.patient",
                "org.glenchiridza.amqp",
        },
        exclude = {
                RabbitAutoConfiguration.class
        }
)
@EnableFeignClients(
        basePackages = "org.glenchiridza.restclients"
)
public class PatientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }
}
