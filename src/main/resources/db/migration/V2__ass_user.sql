create table usr (
    id int8 not null primary key ,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255)
);

create table user_role (
    user_id int8 not null,
    roles varchar(255)
);

insert into usr (id, username, password, email)
    values (1, 'veta', '1234', 'vtmch815@gmail.com');

insert into user_role (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');