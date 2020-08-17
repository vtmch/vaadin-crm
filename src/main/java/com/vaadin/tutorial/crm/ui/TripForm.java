package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.tutorial.crm.backend.entity.Employee;
import com.vaadin.tutorial.crm.backend.entity.Trip;
import com.vaadin.tutorial.crm.backend.service.EmployeeService;
import com.vaadin.tutorial.crm.backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.vaadin.gatanaso.MultiselectComboBox;

/**
 * Form for registration trips
 */
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TripForm extends FormLayout {

    TextField startPoint = new TextField("From");
    TextField tripPoint = new TextField("To");
    DatePicker tripDate = new DatePicker("Departure");
    DatePicker returnDate = new DatePicker("Return");
    MultiselectComboBox<Employee> employees = new MultiselectComboBox<>("Members");

    Button save = new Button("Save");


    private TripService tripService;
    private EmployeeService employeeService;

    @Autowired
    public TripForm(EmployeeService employeeService, TripService tripService) {
        addClassName("contact-form");
        employees.setItems(employeeService.findAll());
        add(startPoint, tripPoint, tripDate, returnDate, employees, createButtonsLayout());
        this.tripService = tripService;
        this.employeeService = employeeService;
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.addClickListener(event -> validateAndSave());
        return new HorizontalLayout(save);
    }


    public void validateAndSave() {
        try {
            Trip trip = new Trip();
            trip.setTripPoint(tripPoint.getValue());
            trip.setStartPoint(startPoint.getValue());
            trip.setReturnDate(returnDate.getValue());
            trip.setTripDate(tripDate.getValue());

            Trip save = tripService.save(trip);

            employees.getSelectedItems().forEach(employee -> {
                employee.getTrips().add(save);
                employeeService.save(employee);
            });

            UI.getCurrent().getPage().reload();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
