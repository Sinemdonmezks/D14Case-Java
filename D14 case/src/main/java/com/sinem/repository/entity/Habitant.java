package com.sinem.repository.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Habitant implements Serializable {
    @TableGenerator(name = "HAbitantId_Gen", initialValue = 100000)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "HAbitantId_Gen")
    private Long id;
    private String nameSurname;
    private Boolean isCitizen;
    private Boolean hasDrivingLicense;
    @OneToMany(fetch = FetchType.LAZY)
    List<Habitant> children ;
}
