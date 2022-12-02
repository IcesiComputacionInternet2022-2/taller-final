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



insert into USERS (user_id,email,password,address,phone_number,role_id)
values ('34366239-3264-3430-2d34-6662642d3131','juansedogs@gmail.com','aa@aaa1A','Carrera 20','+573209842398','78550f06-9fc7-4b65-a81c-04fc4f7a6e30');
insert into USERS (user_id,email,password,address,phone_number,role_id)
values ('c977eff7-db1a-424e-9a16-63da84b03b8d','test@gmail.com','aa@aaa1A','Carrera 21','+573109842398','78550f06-9fc7-4b65-a81c-04fc4f7a6e30');
insert into USERS (user_id,email,password,address,phone_number,role_id)
values ('4c4b85df-9b3c-47f5-9baa-8428c4421210','test2@gmail.com','aa@aaa1A','Carrera 22','+573109642398','78550f06-9fc7-4b65-a81c-04fc4f7a6e30');