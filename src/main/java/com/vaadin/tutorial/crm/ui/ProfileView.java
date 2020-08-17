package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

@Route(value="profile", layout = MainLayout.class)
@PageTitle("My profile")
public class ProfileView extends VerticalLayout {

    public ProfileView() {

        addClassName("profile-view");

        setSizeFull();

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Label id = new Label("ID: " + user.getId());
        Label username = new Label("Username: " + user.getUsername());
        Label email = new Label("Email: " + user.getEmail());
        Label roles = new Label("Roles: " + user.getRoles());

        add(id, username, email, roles);

    }
}
