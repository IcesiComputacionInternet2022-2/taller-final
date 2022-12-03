INSERT INTO user_role(role_id, role_name, description) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb','admin', 'Base role for admin');
INSERT INTO user_role(role_id, role_name, description) VALUES ('2b393010-5fde-43fc-9bbd-be6a914259eb','user', 'Base role for user');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('ccc7ff73-1989-413a-ab52-9bec7a049e33', '/rest/user', 'create.user', 'POST');
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('14cc9ad2-d9cd-4cd7-a290-b10a1d876180', '/rest/item', 'create.item', 'POST');
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', 'ccc7ff73-1989-413a-ab52-9bec7a049e33');
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '14cc9ad2-d9cd-4cd7-a290-b10a1d876180');