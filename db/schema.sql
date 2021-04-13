create table users (
  id serial primary key ,
  username varchar(255),
  password varchar(255)
);

create table posts (
    id serial primary key,
    topic text,
    text text,
    user_id int references users(id),
    created timestamp with time zone not null default now()
);

insert into users(username, password)
values ('admin', '$2a$10$7qX6xiYDse27lZczzcG1fOkm/OcK1p4v8E2ne/3CBG25rGFuMg80C');