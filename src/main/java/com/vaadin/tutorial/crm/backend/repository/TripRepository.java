package com.vaadin.tutorial.crm.backend.repository;

import com.vaadin.tutorial.crm.backend.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("select t from Trip t where t.startPoint = :searchCity or t.tripPoint = :searchCity")
    List<Trip> search(@Param("searchCity") String searchCity);
}
