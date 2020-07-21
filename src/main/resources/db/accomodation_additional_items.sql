create table accomodation_additional_items
(
     accomodation_id integer not null
    ,foreign key(accomodation_id) references accomodations(id) on delete cascade
    ,additional_item_id integer not null
    ,foreign key(additional_item_id) references additional_items(id) on delete
   ,PRIMARY KEY (accomodation_id, additional_item_id)
)