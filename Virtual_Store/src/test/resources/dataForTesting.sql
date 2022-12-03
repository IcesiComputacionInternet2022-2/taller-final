INSERT INTO user_role(role_id, role_name, description)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', 'admin', 'Base role for admin');
INSERT INTO user_role(role_id, role_name, description)
VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', 'client', 'Base role for client');

INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('ccc7ff73-1989-413a-ab52-9bec7a049e33', '/users', 'create.user', 'POST');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('2a861f86-5e1e-422c-9173-66b79928b346', '/users', 'get.user', 'GET');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('053119f1-5aaf-4259-aabe-5d2bd458c19d', '/login', 'login', 'POST');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('f87e6127-a551-4caa-95ed-a41171ee0aeb', '/orders', 'get.order', 'GET');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('a0b05a09-df8f-4057-b49a-34ddf0b43ffe', '/orders', 'create.order', 'POST');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('08f23e83-cf7d-41ec-97c9-222696a5d6a8', '/orders', 'update.order', 'PUT');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('2b478193-23fe-4647-9978-af031962e2fe', '/orders', 'delete.order', 'DELETE');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('188cfe58-7503-479d-8b76-dbd4f9ba5b95', '/items', 'get.item', 'GET');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('72eb9f65-556f-40a3-bc77-3efada7e5f78', '/items', 'create.item', 'POST');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('46cdb2d3-46d6-45f7-8899-2759fea7c55f', '/items', 'update.item', 'PUT');

INSERT INTO role_permission(role_id, permission_id)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', 'ccc7ff73-1989-413a-ab52-9bec7a049e33');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '2a861f86-5e1e-422c-9173-66b79928b346');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '053119f1-5aaf-4259-aabe-5d2bd458c19d');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', 'f87e6127-a551-4caa-95ed-a41171ee0aeb');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '08f23e83-cf7d-41ec-97c9-222696a5d6a8');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '2b478193-23fe-4647-9978-af031962e2fe');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '188cfe58-7503-479d-8b76-dbd4f9ba5b95');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '72eb9f65-556f-40a3-bc77-3efada7e5f78');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '46cdb2d3-46d6-45f7-8899-2759fea7c55f');

INSERT INTO role_permission(role_id, permission_id)
VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', 'ccc7ff73-1989-413a-ab52-9bec7a049e33');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', '053119f1-5aaf-4259-aabe-5d2bd458c19d');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', 'f87e6127-a551-4caa-95ed-a41171ee0aeb');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', 'a0b05a09-df8f-4057-b49a-34ddf0b43ffe');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', '2b478193-23fe-4647-9978-af031962e2fe');
INSERT INTO role_permission(role_id, permission_id)
VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', '188cfe58-7503-479d-8b76-dbd4f9ba5b95');

INSERT INTO "user"(user_id, email, phone_number, address, password, role_id)
VALUES ('44991aa0-6568-401c-b032-6b436a7812dd', 'testing1@email.com', '+3154512073', 'askdh aksjhdka', 'askhda123',
        '2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb');
INSERT INTO item_type(item_type_id, name, description, price, image)
VALUES ('ccc7ff73-1989-413a-ab52-9bec7a049e98', 'table', 'xdadaqewqdasdasdqweasdasds', 9.99, '');
INSERT INTO item(item_id, available, order_item_id, item_type_id)
VALUES ('ccc7ff73-1989-413a-ab52-9bec7a049e55', true, null, 'ccc7ff73-1989-413a-ab52-9bec7a049e98');
