package com.kruger.test.vo.request;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DoseRequest {
    private Date date_vaccination;
    private Integer nro_dose;
    private Integer id_person;
    private Integer id_vaccine;
}
