package com.example.schoolmanagementhwday21.DTO;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Valid
public class AddressDTO {

    @NotNull(message = "Not null")
    private Integer teacher_id;
    @NotEmpty(message = "Not empty")
    @Column(columnDefinition="varchar(20) not null")
    private String area;

    @NotEmpty(message = "Not empty")
    @Column(columnDefinition="varchar(20) not null")
    private String street;

    @NotNull(message = "Not null")
    private Integer buildingNumber;
}
