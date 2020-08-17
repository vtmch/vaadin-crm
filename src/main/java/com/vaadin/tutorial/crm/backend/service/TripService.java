package com.vaadin.tutorial.crm.backend.service;

import com.vaadin.tutorial.crm.backend.entity.Trip;
import com.vaadin.tutorial.crm.backend.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public List<Trip> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return tripRepository.findAll();
        } else {
            return tripRepository.search(stringFilter);
        }
    }

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }
}