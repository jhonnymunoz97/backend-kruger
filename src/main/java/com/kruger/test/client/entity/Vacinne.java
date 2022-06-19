package com.kruger.test.client.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "vaccine")
public class Vacinne {
    @Id
    @Column(name = "id_vaccine")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_vaccine;

    @Column(nullable = false,length = 50)
    private String type;
}
