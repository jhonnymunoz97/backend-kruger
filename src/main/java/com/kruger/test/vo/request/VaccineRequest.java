package com.kruger.test.vo.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VaccineRequest {
    private String type;
}
