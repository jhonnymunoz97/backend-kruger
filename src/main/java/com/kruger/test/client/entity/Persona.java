package com.kruger.test.client.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "person")
public class Persona {
    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_person;

    @Column(nullable = false,length = 10)
    private String dni;

    @Column(nullable = false,length = 50)
    private String first_name;

    @Column(nullable = false,length = 50)
    private String last_name;

    @Column(nullable = false,length = 50)
    private String email;

    @Column(nullable = true)
    private Date date_birth;

    @Column(nullable = true)
    private String direction;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private Boolean status_vaccination;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String user_password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Rol role;

}
