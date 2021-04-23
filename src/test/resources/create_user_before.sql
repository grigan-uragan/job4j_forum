delete from user_role;
delete from users;

insert into users(id, username, password)
values (1, 'admin', '$2a$10$yX7Eam8nv5axtddlVpJeEOj7ozBdI89d1rdDE92VdynCGJCyv4Dbi'),
       (2, 'user', '$2a$10$x6uQNvqpJRR9Mdzuk5My7.pdH.LajBOswFRzJzwsQbSXlu0TVo.NW');

insert into user_role (user_id, roles) values
(1, 'ROLE_ADMIN'), (1, 'ROLE_USER'), (2, 'ROLE_USER');