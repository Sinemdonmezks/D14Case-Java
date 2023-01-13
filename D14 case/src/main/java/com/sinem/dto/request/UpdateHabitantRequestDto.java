package com.sinem.dto.request;

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
public class UpdateHabitantRequestDto {
    private Long parentid;
    private Long childrenid;


}
