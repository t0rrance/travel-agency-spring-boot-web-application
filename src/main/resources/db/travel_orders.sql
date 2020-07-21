create table travel_orders
(
    id integer primary key not null auto_increment
    ,travel_id integer not null
    ,client_id integer not null
    ,user_id integer not null
    ,number_of_seats integer
    ,order_date date
    ,payment_date date
    ,foreign key(travel_id) references travels(id)
    ,foreign key(client_id) references clients(id)
    ,foreign key(user_id) references users(id)
)