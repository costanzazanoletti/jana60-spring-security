INSERT INTO `role`(id, name) VALUES (1,'ADMIN');
INSERT INTO `role`(id, name) VALUES (2,'USER');
INSERT INTO `user`(id, username, `password`) VALUES (1,'user', '{noop}user');
INSERT INTO `user`(id, username, `password`) VALUES (2,'admin', '{noop}admin');
INSERT INTO user_roles(user_id, roles_id) VALUES (1, 2);
INSERT INTO user_roles(user_id, roles_id) VALUES (2, 1);
INSERT INTO user_roles(user_id, roles_id) VALUES (2, 2);