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
                .nameSurname("Rachel Green")
                .isCitizen(true)
                .id(100001L)
                .hasDrivingLicense(true)
                .build();
        habitantService.save(habitant1);
         Habitant habitant2=Habitant.builder()
                .nameSurname("Phoebe Buffay")
                .isCitizen(false)
                .id(100002L)
                .hasDrivingLicense(true)
                .build();
        habitantService.save(habitant2);
         Habitant habitant3=Habitant.builder()
                .nameSurname("Chandler Bing")
                .isCitizen(true)
                .id(100003L)
                .hasDrivingLicense(false)
                .build();
        habitantService.save(habitant3);
         Habitant habitant4=Habitant.builder()
                .nameSurname("Monica Geller")
                .isCitizen(false)
                .id(100004L)
                .hasDrivingLicense(false)
                .build();
        habitantService.save(habitant4);
         Habitant habitant5=Habitant.builder()
                .nameSurname("Rose Galler")
                .isCitizen(true)
                .id(100005L)
                .hasDrivingLicense(true)
                .build();
        habitantService.save(habitant5);
         Habitant habitant6=Habitant.builder()
                .nameSurname("Joey Tribbiani")
                .isCitizen(true)
                .id(100006L)
                .hasDrivingLicense(true)
                .build();
        habitantService.save(habitant6);
    }

}
