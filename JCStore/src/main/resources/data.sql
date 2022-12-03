--Defined basic user roles
INSERT INTO "USER_ROLE" (role_id, role_name, description)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff','BUYER','The buyer will be our main customer and will only have permissions to perform actions related to the purchase.');

INSERT INTO "USER_ROLE" (role_id, role_name, description)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20','ADMIN','The admin will be able to manage the stores orders, items and users');

--Possible permissions
INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('ccc7ff73-1989-413a-ab52-9bec7a049e33', '/users', 'create.user', 'POST');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('39c00009-bed2-4f48-b137-ce7804eed5cd', '/users', 'get.users', 'GET');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('5ceceff2-664b-4bf0-ac2a-627571e6abf3', '/users/*', 'get.users/*', 'GET');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('cee082d5-3b67-4af1-b545-d2359762cdc0', '/orders', 'create.orders', 'POST');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('38dea8f6-92da-4dbf-8598-d0652379731b', '/orders', 'get.orders', 'GET');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('e59f6f6e-d3a0-4b8d-bc24-3181b0db70a8', '/orders/*', 'get.ordersDTO', 'GET');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('e2434bb5-2a2c-4769-938c-1fb90a8756ff', '/orders/*', 'update.orderStatus', 'PATCH');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('58ea58c9-9f69-4e84-8230-04147f3f85d6', '/orders/cancel/*', 'cancel.orderStatus', 'PATCH');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('aa79c146-3620-4f8d-8411-9937ab71d2c8', '/auth', 'login.loginUser', 'POST');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('9fcab7da-0e3d-4fb9-bd2b-42f38667cc4f', '/items', 'create.item', 'POST');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('0aaf7cbc-62b0-471a-a9fa-3b7a289e0079', '/items', 'get.items', 'GET');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('0ca1eecd-25ca-4a74-9c14-8131d90f4699', '/items/*', 'get.item', 'GET');

INSERT INTO user_permission (permission_id, uri, permission_key, permission_method)
VALUES ('bd36cf56-4860-438d-a07b-795b3281fbf8', '/items/*', 'update.item', 'PUT');

--Permission's of an specific role
--BUYER
INSERT INTO role_permission (role_id, permission_id)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff', 'ccc7ff73-1989-413a-ab52-9bec7a049e33');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff', '5ceceff2-664b-4bf0-ac2a-627571e6abf3');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff', 'cee082d5-3b67-4af1-b545-d2359762cdc0');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff', '38dea8f6-92da-4dbf-8598-d0652379731b');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff', 'e59f6f6e-d3a0-4b8d-bc24-3181b0db70a8');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff', 'aa79c146-3620-4f8d-8411-9937ab71d2c8');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff', '0aaf7cbc-62b0-471a-a9fa-3b7a289e0079');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff', '0ca1eecd-25ca-4a74-9c14-8131d90f4699');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('7832c0fe-d0f0-425a-8d36-d32693c57aff', '58ea58c9-9f69-4e84-8230-04147f3f85d6');

--ADMIN
INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', 'ccc7ff73-1989-413a-ab52-9bec7a049e33');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', '39c00009-bed2-4f48-b137-ce7804eed5cd');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', '5ceceff2-664b-4bf0-ac2a-627571e6abf3');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', 'cee082d5-3b67-4af1-b545-d2359762cdc0');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', '38dea8f6-92da-4dbf-8598-d0652379731b');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', 'e59f6f6e-d3a0-4b8d-bc24-3181b0db70a8');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', 'e2434bb5-2a2c-4769-938c-1fb90a8756ff');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', 'aa79c146-3620-4f8d-8411-9937ab71d2c8');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', '9fcab7da-0e3d-4fb9-bd2b-42f38667cc4f');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', '0aaf7cbc-62b0-471a-a9fa-3b7a289e0079');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', '0ca1eecd-25ca-4a74-9c14-8131d90f4699');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', '58ea58c9-9f69-4e84-8230-04147f3f85d6');

INSERT INTO role_permission (role_id, permission_id)
VALUES ('cbe5ea52-0edb-4d2e-a883-1488f1520b20', 'bd36cf56-4860-438d-a07b-795b3281fbf8');

--Base admin user
INSERT INTO users (id, name, email, password, address, phone, role_id)
VALUES ('69a91b05-4621-4a79-9c94-372fa108d132', 'admin', 'admin@gmail.com', 'Admin#1', 'Home', '+57123456789', 'cbe5ea52-0edb-4d2e-a883-1488f1520b20');

--Initial client user
INSERT INTO users (id, name, email, password, address, phone, role_id)
VALUES ('f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454', 'client', 'client@gmail.com', 'Client#1', 'House', '+57123456789', '7832c0fe-d0f0-425a-8d36-d32693c57aff');