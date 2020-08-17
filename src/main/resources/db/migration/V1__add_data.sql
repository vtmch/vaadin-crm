create table employee (
    id bigserial not null primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    status varchar(255) not null,
    email varchar(255) not null
);

create table trip (
    id bigserial not null primary key,
    start_point varchar(255) not null,
    trip_point varchar(255) not null,
    trip_date date not null,
    return_date date not null
);

create table employee_trips (
    id bigserial not null primary key,
    employees_id bigserial not null,
    trips_id bigserial not null
);

insert into employee (id, first_name, last_name, status, email) values
    (1, 'Kilye', 'Jenner', 'Director', 'kylie_jenner@google.com'),
    (2, 'Monica', 'Bianchi', 'Director', 'monica_bianchi@google.com'),
    (3, 'Raffaele', 'Pluxury', 'Manager', 'raffaele_pluxury@google.com'),
    (4, 'Furian', 'Carbone', 'Employee', 'furian_carbone@google.com'),
    (5, 'Anastasia', 'Carbone', 'Employee', 'anastasia_carbone@google.com'),
    (6, 'Iva', 'Raikage', 'Manager', 'iva_raikage@google.com'),
    (7, 'Daniel', 'Costelli', 'Employee', 'daniel_costelli@google.com'),
    (8, 'Stefan', 'Pluxury', 'Employee', 'stefan_pluxury@google.com'),
    (9, 'Kyle', 'Aquila', 'Employee', 'kyle_aquila@google.com'),
    (10, 'Helena', 'Pluxury', 'Manager', 'helena_pluxury@google.com');