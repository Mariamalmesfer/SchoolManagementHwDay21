package com.example.schoolmanagementhwday21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Not empty")
    @Column(columnDefinition="varchar(20) not null")
    private String name;

    @NotNull(message = "Not null")
    @Min(value = 22 , message = "must be older than 22")
    private Integer age;

    @NotEmpty(message = "Not empty")
    @Email
    private String email;

    @NotNull(message = "Not null")
    @Min(value = 5000 , message = "must be more than 5000")
    private Integer salary;


    @OneToOne(cascade =CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    Address address;
}
