delete from posts;

insert into posts (id, topic, text, user_id, created) values
(1, 'topic', 'first topic', 1, '2021-04-13 14:15:00.675000'),
(2, 'new topic', 'new topic', 2, '2021-04-13 14:15:01.675000'),
(3, 'topic', 'second topic', 2, '2021-04-13 14:15:02.675000'),
(4, 'topic', 'third topic', 1, '2021-04-13 14:15:03.675000');
