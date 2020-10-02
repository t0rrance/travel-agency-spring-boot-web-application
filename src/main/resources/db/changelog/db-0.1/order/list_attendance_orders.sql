create table list_attendance_orders
(
     travel_order_id integer not null
    ,client_id integer not null
    ,foreign key(travel_order_id) references travel_orders(id)
    ,foreign key(client_id) references clients(id)
)