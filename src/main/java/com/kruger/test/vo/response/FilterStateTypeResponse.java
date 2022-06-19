package com.kruger.test.vo.response;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilterStateTypeResponse {
    private Integer id_person;
    private String dni;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private String date_birth;
    private String direction;
}
