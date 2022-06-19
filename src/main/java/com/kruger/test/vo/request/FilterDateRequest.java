package com.kruger.test.vo.request;

import lombok.*;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FilterDateRequest {
    private Date start_date;
    private Date end_date;
}
