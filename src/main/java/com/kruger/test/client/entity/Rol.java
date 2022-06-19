package com.kruger.test.client.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "role")
public class Rol {
    @Id
    @Column(name = "id_role")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_role;

    @Column(nullable = false,length = 50)
    private String type;

}
