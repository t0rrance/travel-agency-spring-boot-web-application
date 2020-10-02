create table travel_accommodations
(
     travel_id INTEGER NOT NULL
    ,FOREIGN KEY (travel_id) REFERENCES travels(id) ON DELETE CASCADE
     ,accommodation_id INTEGER NOT NULL
     ,FOREIGN KEY (accommodation_id) REFERENCES accommodations(id) ON DELETE CASCADE

     ,PRIMARY KEY (travel_id, accommodation_id)
)