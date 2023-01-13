package com.sinem.mapper;


import com.sinem.dto.request.CreateHabitantRequestDto;
import com.sinem.dto.response.CreateHabitantResponseDto;
import com.sinem.dto.response.UpdateHabitantResponseDto;
import com.sinem.repository.entity.Habitant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IHabitantMapper {
    IHabitantMapper INSTANCE = Mappers.getMapper(IHabitantMapper.class);

    Habitant toHabitant(final CreateHabitantRequestDto dto);

    UpdateHabitantResponseDto toUpdateHabitantResponseDto(final Habitant habitant);

    List<UpdateHabitantResponseDto> toUpdateHabitantResponseDtoList(final List<Habitant> habitants);
    CreateHabitantResponseDto toCreateHabitantResponseDto(final Habitant habitant);

}