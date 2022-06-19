package com.kruger.test.client.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "dose")
public class Dose {
    @Id
    @Column(name = "id_dose")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_dose;

    @Column(nullable = false)
    private Date date_vaccination;

    @Column(nullable = false)
    private Integer nro_dose;

    @ManyToOne
    @JoinColumn(name = "vacinne_id")
    private Vacinne vacinne;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private Persona person;

}
