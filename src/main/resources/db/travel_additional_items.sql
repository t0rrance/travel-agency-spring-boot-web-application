create table travel_additional_items
(
     travel_id INTEGER NOT NULL
    ,FOREIGN KEY (travel_id) REFERENCES travels(id) ON DELETE CASCADE

     ,additional_item_id INTEGER NOT NULL
     ,FOREIGN KEY (additional_item_id) REFERENCES additional_items(id) ON DELETE CASCADE

     ,PRIMARY KEY (travel_id, additional_item_id)
)