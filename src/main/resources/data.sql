--Admin
INSERT INTO user_role(role_id, role_name, description)
VALUES ('50342c5d-17e8-490f-b753-3898041c97e8','admin', 'Base role for admin') ON CONFLICT DO NOTHING;
--Client
INSERT INTO user_role(role_id, role_name, description)
VALUES ('78550f06-9fc7-4b65-a81c-04fc4f7a6e30','client', 'Base role for client') ON CONFLICT DO NOTHING;

--Permission for register
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method)
VALUES ('ccc7ff73-1989-413a-ab52-9bec7a049e33', '/users', 'create.user', 'POST') ON CONFLICT DO NOTHING;

--Permissions
INSERT INTO role_permission(role_id, permission_id)
VALUES ('50342c5d-17e8-490f-b753-3898041c97e8', 'ccc7ff73-1989-413a-ab52-9bec7a049e33') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id)
VALUES ('50342c5d-17e8-490f-b753-3898041c97e8', 'ccc7ff73-1989-413a-ab52-9bec7a049e33') ON CONFLICT DO NOTHING;

--Usuario admin (me voy a decidir entre ingles o español o que?)
INSERT INTO users(user_id,email,password,address,phone_number,role_id)
VALUES ('a5f8cb61-e99a-4965-9301-e68ae79cebf7','soyadmin@gmail.com','aa@aaa1A','Calle 121','+573166747989','50342c5d-17e8-490f-b753-3898041c97e8') ON CONFLICT DO NOTHING;