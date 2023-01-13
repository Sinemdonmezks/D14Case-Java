package com.sinem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateHabitantDetailRequestDto {
    private Long id;
    private Boolean isCitizen;
    private Boolean hasDrivingLicense;



}
