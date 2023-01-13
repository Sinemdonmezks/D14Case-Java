package com.sinem.service;

import com.sinem.dto.request.CreateHabitantRequestDto;
import com.sinem.dto.request.UpdateHabitantDetailRequestDto;
import com.sinem.dto.request.UpdateHabitantRequestDto;
import com.sinem.dto.response.CreateHabitantResponseDto;
import com.sinem.dto.response.MyChildrenResponseDto;
import com.sinem.dto.response.UpdateHabitantResponseDto;
import com.sinem.exception.ErrorType;
import com.sinem.exception.ManagerException;
import com.sinem.mapper.IHabitantMapper;
import com.sinem.repository.IHabitantRepository;
import com.sinem.repository.entity.Habitant;
import com.sinem.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitantService extends ServiceManager<Habitant, Long> {

    private final IHabitantRepository habitantRepository;

    public HabitantService(IHabitantRepository habitantRepository) {
        super(habitantRepository);
        this.habitantRepository = habitantRepository;
    }

    public CreateHabitantResponseDto saveHabitant(CreateHabitantRequestDto dto) {
        try {
            Habitant habitant = IHabitantMapper.INSTANCE.toHabitant(dto);
            save(habitant);
            return IHabitantMapper.INSTANCE.toCreateHabitantResponseDto(habitant);
        } catch (Exception e) {
            throw new ManagerException(ErrorType.HABITANT_NOT_CREATED);
        }
    }

    public UpdateHabitantResponseDto updateHabitant(UpdateHabitantRequestDto dto) {
        Optional<Habitant> habitant = findById(dto.getParentid());
        if (habitant.isPresent()) {
            Optional<Habitant> children = findById(dto.getChildrenid());
            if (children.isPresent()) {
                habitant.get().getChildren().add(children.get());
                save(habitant.get());
                return IHabitantMapper.INSTANCE.toUpdateHabitantResponseDto(habitant.get());
            } else {
                throw new ManagerException(ErrorType.HABITANT_NOT_FOUND);
            }
        } else {
            throw new ManagerException(ErrorType.HABITANT_NOT_UPDATED);
        }
    }

    public List<UpdateHabitantResponseDto> findAllByIsCitizen() {
        List<Habitant> habitants = habitantRepository.findAllByIsCitizen(true);
        return IHabitantMapper.INSTANCE.toUpdateHabitantResponseDtoList(habitants);
    }

    public List<UpdateHabitantResponseDto> findAllByNameSurname(String nameSurname) {
        List<Habitant> habitants = habitantRepository.findAllByNameSurnameContainingIgnoreCase(nameSurname);
        return IHabitantMapper.INSTANCE.toUpdateHabitantResponseDtoList(habitants);
    }

    public List<UpdateHabitantResponseDto> findAllByHasDrivingLicense() {
        List<Habitant> habitants = habitantRepository.findAllByHasDrivingLicense(true);
        return IHabitantMapper.INSTANCE.toUpdateHabitantResponseDtoList(habitants);
    }

    /*
    public List<UpdateHabitantResponseDto> findAllByChildren(Integer children) {
        List<Habitant> habitants = habitantRepository.findAllByChildren(children);
        return IHabitantMapper.INSTANCE.toHabitantResponseDtoList(habitants);
    }
    */


    public UpdateHabitantResponseDto getById(Long id) {
        Optional<Habitant> habitant = habitantRepository.findOptionalById(id);
        if (habitant.isPresent()) {
            return IHabitantMapper.INSTANCE.toUpdateHabitantResponseDto(habitant.get());
        } else {
            throw new ManagerException(ErrorType.HABITANT_NOT_FOUND);
        }
    }

    public List<Habitant> getAll() {
        return habitantRepository.findAll();
    }

    public Optional<Habitant> findOptionalById(Long id) {
        return habitantRepository.findOptionalById(id);
    }
    public MyChildrenResponseDto findChildrenById(Long id) {
        Optional<Habitant> habitant= habitantRepository.findOptionalById(id);
        if(habitant.isPresent()){
            List<Habitant> children = habitant.get().getChildren();
            return MyChildrenResponseDto.builder()
                    .children(children)
                    .build() ;
        }else {
            throw new ManagerException(ErrorType.HABITANT_NOT_FOUND);
        }

    }

    public UpdateHabitantResponseDto updateDetailHabitant(UpdateHabitantDetailRequestDto dto) {
        Optional<Habitant> habitant = findById(dto.getId());
        if (habitant.isPresent()){
                habitant.get().setHasDrivingLicense(dto.getHasDrivingLicense());
                habitant.get().setIsCitizen(dto.getIsCitizen());
                save(habitant.get());
                return IHabitantMapper.INSTANCE.toUpdateHabitantResponseDto(habitant.get());
            } else {
                throw new ManagerException(ErrorType.HABITANT_NOT_UPDATED);
        }
    }
}


