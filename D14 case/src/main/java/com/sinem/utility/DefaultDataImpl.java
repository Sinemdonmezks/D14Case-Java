package com.sinem.utility;


import com.sinem.repository.entity.Habitant;
import com.sinem.service.HabitantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class DefaultDataImpl {
private final HabitantService habitantService;
    @PostConstruct
    private  void create(){
        saveImplToDatabase();
    }

    private void saveImplToDatabase() {
        Habitant habitant1=Habitant.builder()
                .nameSurname("John Doe")
                .isCitizen(true)
                .id(100000L)
                .hasDrivingLicense(true)
                .build();
        habitantService.save(habitant1);
    }

}
