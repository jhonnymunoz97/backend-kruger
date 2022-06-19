package com.kruger.test.vo.request;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonUpdateRequest {
    private String phone;
    private Date date_birth;
    private String direction;
}
