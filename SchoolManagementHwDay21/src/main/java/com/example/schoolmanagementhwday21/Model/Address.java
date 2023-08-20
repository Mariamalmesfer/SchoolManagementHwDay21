package com.example.schoolmanagementhwday21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "Not empty")
    @Column(columnDefinition="varchar(20) not null")
    private String area;

    @NotEmpty(message = "Not empty")
    @Column(columnDefinition="varchar(20) not null")
    private String street;

    @NotNull(message = "Not null")
    private Integer buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    Teacher teacher;




}


