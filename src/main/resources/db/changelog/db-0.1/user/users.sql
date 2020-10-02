create table users
(
    id integer primary key not null auto_increment
    ,user_name varchar (100)
    ,first_name varchar (200)
    ,last_name varchar (200)
    ,password varchar (300)
    ,role varchar(50)
    ,token varchar(300)
)