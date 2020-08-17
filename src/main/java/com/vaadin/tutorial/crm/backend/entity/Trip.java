package com.vaadin.tutorial.crm.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Trip extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String startPoint;

    @NotNull
    @NotEmpty
    private String tripPoint;

    @NotNull
    private LocalDate tripDate;

    @NotNull
    private LocalDate returnDate;

    @ManyToMany(mappedBy = "trips", fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();

}