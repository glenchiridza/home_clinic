package org.glenchiridza.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@SpringBootApplication(
        scanBasePackages = {
                "org.glenchiridza.notification",
                "org.glenchiridza.amqp",
        },exclude = {
        RabbitAutoConfiguration.class,
}
)
@Slf4j
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);

    }

//    @Bean
//    CommandLineRunner runner(RabbitMQMessageProducer producer,
//                             NotificationConfig notificationConfig) {
//        return args -> producer.publish(
//                new Person("Glen","Chiridza","Machine Learning Engineer"),
//                notificationConfig.getInternalExchange(),
//                notificationConfig.getInternalNotificationRoutingKey());
//    }
//
//    record Person(String name,String surname,String jobTitle){}

}
