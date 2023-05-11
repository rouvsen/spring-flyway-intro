CREATE TABLE if not exists users (
      id SERIAL PRIMARY KEY,
      username varchar(100) not null,
      first_name varchar(50) not null,
      last_name varchar(50) not null
);
