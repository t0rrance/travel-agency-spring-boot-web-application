create table travel_order_additional_items
(
     travel_order_id INTEGER NOT NULL
    ,FOREIGN KEY (travel_order_id) REFERENCES travel_orders(id) ON DELETE CASCADE

     ,additional_item_id INTEGER NOT NULL
     ,FOREIGN KEY (additional_item_id) REFERENCES additional_items(id) ON DELETE CASCADE

     ,PRIMARY KEY (travel_order_id, additional_item_id)
)