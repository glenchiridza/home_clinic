package org.glenchiridza.patient.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Patient {

    @Id
    @SequenceGenerator(
            name = "patient_id_sequence",
            sequenceName = "patient_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String nationalId;
    private String address;

    //later add next of kin
}



//example payload
//{
//        "firstName":"Glen",
//        "lastName":"Chiridza",
//        "email":"glenchiridz@gmail.com",
//        "phone":"0774291926",
//        "nationalId":"43-232323f23",
//        "address":"11 Marble Street"
//        }