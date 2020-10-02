create table travel_order_attendances
(
     travel_order_id INTEGER NOT NULL
    ,FOREIGN KEY (travel_order_id) REFERENCES travel_orders(id) ON DELETE CASCADE

     ,client_id INTEGER NOT NULL
     ,FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE

     ,PRIMARY KEY (travel_order_id, client_id)
)
