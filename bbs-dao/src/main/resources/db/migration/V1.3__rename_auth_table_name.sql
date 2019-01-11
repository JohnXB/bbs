alter table role RENAME auth_role;
alter table permission RENAME auth_permission;
alter table role_permissions RENAME auth_role_permissions;
alter table user_roles RENAME auth_user_roles;