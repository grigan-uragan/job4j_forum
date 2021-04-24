insert into users(id, username, password)
values (1, 'admin', '$2a$10$yX7Eam8nv5axtddlVpJeEOj7ozBdI89d1rdDE92VdynCGJCyv4Dbi'),
       (2, 'user', '$2a$10$x6uQNvqpJRR9Mdzuk5My7.pdH.LajBOswFRzJzwsQbSXlu0TVo.NW');

insert into user_role (user_id, roles) values
(1, 'ROLE_ADMIN'), (1, 'ROLE_USER'), (2, 'ROLE_USER');

insert into posts (id, topic, text, user_id, created) values
(1, 'topic', 'first topic', 1, '2021-04-13 14:15:00.675000'),
(2, 'new topic', 'new topic', 2, '2021-04-13 14:15:01.675000'),
(3, 'topic', 'second topic', 2, '2021-04-13 14:15:02.675000'),
(4, 'topic', 'third topic', 1, '2021-04-13 14:15:03.675000');