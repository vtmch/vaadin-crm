package com.vaadin.tutorial.crm.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Employee extends AbstractEntity implements Cloneable {

    public enum Status {
        Employee, Director, Manager
    }

    @NotNull
    @NotEmpty
    private String firstName = "";

    @NotNull
    @NotEmpty
    private String lastName = "";

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_trips", joinColumns = @JoinColumn(name = "employees_id"),
    inverseJoinColumns = @JoinColumn(name = "trips_id"))
    private List<Trip> trips = new LinkedList<>();

    @Enumerated(EnumType.STRING)
    @NotNull
    private Employee.Status status;

    @Email
    @NotNull
    @NotEmpty
    private String email = "";

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}