create table travels
(
    id integer primary key not null auto_increment
    ,travel_name varchar (200)
    ,number_of_seats integer
    ,number_occupied_seats integer
    ,price_per_seat integer
    ,start_date date
    ,finish_date date
)