package com.sinem.mapper;

import com.sinem.dto.request.CreateHabitantRequestDto;
import com.sinem.dto.response.CreateHabitantResponseDto;
import com.sinem.dto.response.UpdateHabitantResponseDto;
import com.sinem.repository.entity.Habitant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T10:31:43+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class IHabitantMapperImpl implements IHabitantMapper {

    @Override
    public Habitant toHabitant(CreateHabitantRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Habitant.HabitantBuilder habitant = Habitant.builder();

        habitant.nameSurname( dto.getNameSurname() );
        habitant.isCitizen( dto.getIsCitizen() );
        habitant.hasDrivingLicense( dto.getHasDrivingLicense() );

        return habitant.build();
    }

    @Override
    public UpdateHabitantResponseDto toUpdateHabitantResponseDto(Habitant habitant) {
        if ( habitant == null ) {
            return null;
        }

        UpdateHabitantResponseDto.UpdateHabitantResponseDtoBuilder updateHabitantResponseDto = UpdateHabitantResponseDto.builder();

        updateHabitantResponseDto.id( habitant.getId() );
        updateHabitantResponseDto.nameSurname( habitant.getNameSurname() );
        updateHabitantResponseDto.isCitizen( habitant.getIsCitizen() );
        updateHabitantResponseDto.hasDrivingLicense( habitant.getHasDrivingLicense() );
        List<Habitant> list = habitant.getChildren();
        if ( list != null ) {
            updateHabitantResponseDto.children( new ArrayList<Habitant>( list ) );
        }

        return updateHabitantResponseDto.build();
    }

    @Override
    public List<UpdateHabitantResponseDto> toUpdateHabitantResponseDtoList(List<Habitant> habitants) {
        if ( habitants == null ) {
            return null;
        }

        List<UpdateHabitantResponseDto> list = new ArrayList<UpdateHabitantResponseDto>( habitants.size() );
        for ( Habitant habitant : habitants ) {
            list.add( toUpdateHabitantResponseDto( habitant ) );
        }

        return list;
    }

    @Override
    public CreateHabitantResponseDto toCreateHabitantResponseDto(Habitant habitant) {
        if ( habitant == null ) {
            return null;
        }

        CreateHabitantResponseDto.CreateHabitantResponseDtoBuilder createHabitantResponseDto = CreateHabitantResponseDto.builder();

        createHabitantResponseDto.id( habitant.getId() );
        createHabitantResponseDto.nameSurname( habitant.getNameSurname() );
        createHabitantResponseDto.isCitizen( habitant.getIsCitizen() );
        createHabitantResponseDto.hasDrivingLicense( habitant.getHasDrivingLicense() );
        List<Habitant> list = habitant.getChildren();
        if ( list != null ) {
            createHabitantResponseDto.children( new ArrayList<Habitant>( list ) );
        }

        return createHabitantResponseDto.build();
    }
}
