package org.glenchiridza.insolvent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class InsolventCheckHistory {

    @Id
    @SequenceGenerator(
            name = "insolvent_id_sequence",
            sequenceName = "insolvent_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "insolvent_id_sequence"
    )
    private Integer id;

    private Integer patientId;
    private Boolean isInsolvent;
    private LocalDateTime createdAt;

}
