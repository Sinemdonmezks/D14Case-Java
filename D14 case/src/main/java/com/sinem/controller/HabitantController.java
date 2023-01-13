package com.sinem.controller;

import com.sinem.dto.request.CreateHabitantRequestDto;
import com.sinem.dto.request.UpdateHabitantDetailRequestDto;
import com.sinem.dto.request.UpdateHabitantRequestDto;
import com.sinem.dto.response.CreateHabitantResponseDto;
import com.sinem.dto.response.MyChildrenResponseDto;
import com.sinem.dto.response.UpdateHabitantResponseDto;
import com.sinem.exception.ErrorType;
import com.sinem.exception.ManagerException;
import com.sinem.repository.entity.Habitant;
import com.sinem.service.HabitantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sinem.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(HABITANT)
@CrossOrigin(origins = "*")
public class HabitantController {
    private final HabitantService habitantService;

    @PostMapping(CREATE)

    public ResponseEntity<CreateHabitantResponseDto> saveHabitant(@RequestBody CreateHabitantRequestDto dto) {
        return ResponseEntity.ok(habitantService.saveHabitant(dto));
    }

    @PutMapping(UPDATE)

    public ResponseEntity<UpdateHabitantResponseDto> updateHabitant(@RequestBody UpdateHabitantRequestDto dto) {
        return ResponseEntity.ok(habitantService.updateHabitant(dto));
    }
    @PutMapping(UPDATEBYID)
    public ResponseEntity<UpdateHabitantResponseDto> updateDetailHabitant(@RequestBody UpdateHabitantDetailRequestDto dto) {
        return ResponseEntity.ok(habitantService.updateDetailHabitant(dto));
    }

    @GetMapping(FINDALLBYISCITIZEN)
    public ResponseEntity<List<UpdateHabitantResponseDto>> findAllByIsCitizen() {
        return ResponseEntity.ok(habitantService.findAllByIsCitizen());
    }

    @GetMapping(FINDALLBYNAME)
    public ResponseEntity<List<UpdateHabitantResponseDto>> findAllByName(@PathVariable String nameSurname) {
        return ResponseEntity.ok(habitantService.findAllByNameSurname(nameSurname));
    }

    @GetMapping(FINDALLBYHASDRIVINGLICENSE)
    public ResponseEntity<List<UpdateHabitantResponseDto>> findAllByHasDrivingLicense() {
        return ResponseEntity.ok(habitantService.findAllByHasDrivingLicense());
    }

    @GetMapping(FINDALLNUMBERBYID)
    public ResponseEntity<Integer> NumberOfChildren(@PathVariable Long id) {
        Optional<Habitant> habitant = habitantService.findOptionalById(id);
        if (habitant.isPresent()) {
            return ResponseEntity.ok(habitant.get().getChildren().size());
        } else {
            throw new ManagerException(ErrorType.HABITANT_NOT_FOUND);
        }
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<UpdateHabitantResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(habitantService.getById(id));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Habitant>> findAll() {
        return ResponseEntity.ok(habitantService.getAll());
    }

    @GetMapping(FINDCHILDRENBYID)
    public ResponseEntity<MyChildrenResponseDto> findChildrenById(@PathVariable Long id) {
        return ResponseEntity.ok(habitantService.findChildrenById(id));
    }


}
