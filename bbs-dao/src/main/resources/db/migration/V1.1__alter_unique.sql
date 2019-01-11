alter table auth_user add UNIQUE(username);
alter TABLE auth_user add UNIQUE(mail);
alter TABLE auth_user add UNIQUE(phone);