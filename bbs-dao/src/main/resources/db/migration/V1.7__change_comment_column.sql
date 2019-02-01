alter TABLE bbs_comment add column user_id int(11) not null;
alter TABLE bbs_comment add column to_user_id int(11);