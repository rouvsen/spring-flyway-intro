CREATE TABLE cars (
    car_id SERIAL PRIMARY KEY,
    car_name varchar(100) not null,
    car_speed integer not null,
    car_year integer not null
);