package org.glenchiridza.notification;

import org.glenchiridza.amqp.config.RabbitMQMessageProducer;
import org.glenchiridza.notification.config.NotificationConfig;
import org.glenchiridza.notification.model.Notification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "org.glenchiridza.notification",
                "org.glenchiridza.amqp"
        },exclude = {
        RabbitAutoConfiguration.class,
}
)
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
