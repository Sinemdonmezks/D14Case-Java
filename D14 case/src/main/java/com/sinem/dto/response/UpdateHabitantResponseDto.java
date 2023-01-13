package com.sinem.dto.response;

import com.sinem.repository.entity.Habitant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateHabitantResponseDto {
    private Long id;
    private String nameSurname;
    private Boolean isCitizen;
    private Boolean hasDrivingLicense;
    List<Habitant> children;
}
