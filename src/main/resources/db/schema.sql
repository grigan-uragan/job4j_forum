create table users (
  id serial primary key ,
  username varchar(255),
  password varchar(255)
);

create table user_role
(
    user_id int not null,
    roles   varchar(255)
);

create table posts (
    id serial primary key,
    topic text,
    text text,
    user_id int references users(id),
    created timestamp with time zone not null default now()
);