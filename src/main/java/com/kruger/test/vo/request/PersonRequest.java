package com.kruger.test.vo.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonRequest {
    private String dni;
    private String first_name;
    private String last_name;
    private String email;
    private Integer role_id;
}
