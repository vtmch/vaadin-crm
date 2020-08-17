package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.entity.Employee;
import com.vaadin.tutorial.crm.backend.entity.Trip;
import com.vaadin.tutorial.crm.backend.service.EmployeeService;
import com.vaadin.tutorial.crm.backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Main page with form for registration trips
 * and list of trips
 */
@Route(value="", layout = MainLayout.class)
@PageTitle("Trips")
public class TripsView extends VerticalLayout {
    private TripService tripService;

    Grid<Trip> grid = new Grid<>(Trip.class);
    private TextField filterText = new TextField();

    @Autowired
    public TripsView(TripService tripService, TripForm tripForm, EmployeeService employeeService) {

        this.tripService = tripService;

        addClassName("last-view");

        setSizeFull();

        configureFilter();
        configureGrid();

        VerticalLayout layout1 = new VerticalLayout();
        layout1.add(new H3("Business trips"), filterText, grid);

        VerticalLayout layout2 = new VerticalLayout();
        layout2.add(new H3("Add new trip"), tripForm);

        HorizontalLayout content = new HorizontalLayout(layout1, layout2);
        content.addClassName("content");
        content.setSizeFull();

        add(content);
        updateList();

    }


    private void configureFilter() {
        filterText.setPlaceholder("Search by city...");

        filterText.setClearButtonVisible(true);

        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        filterText.addValueChangeListener(e -> updateList());
    }

    private void configureGrid() {
        grid.addClassName("trip-grid");
        grid.setSizeFull();
        grid.setColumns("startPoint", "tripPoint", "tripDate", "returnDate");

        grid.addColumn(trip -> {
            Set<Employee> employees = trip.getEmployees();
            return employees.isEmpty() ? "-" : trip.getEmployees();
        }).setHeader("Members");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));

    }

    private void updateList() {
        grid.setItems(tripService.findAll(filterText.getValue()));
    }

}
