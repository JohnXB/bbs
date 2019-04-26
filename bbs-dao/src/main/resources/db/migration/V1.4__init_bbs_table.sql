drop table if exists bbs_admin_log;

drop table if exists bbs_article;

drop table if exists bbs_code_table;

drop table if exists bbs_collection;

drop table if exists bbs_comment;

drop table if exists bbs_follow;

drop table if exists bbs_like;

drop table if exists bbs_message;

drop table if exists bbs_tag;

drop table if exists bbs_user_extend;

/*==============================================================*/
/* Table: bbs_admin_log                                         */
/*==============================================================*/
create table bbs_admin_log
(
   id                   int(11) not null auto_increment,
   admin_id             int(11) not null,
   action               varchar(20) not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   admin_name           varchar(10) not null,
   result               varchar(30),
   primary key (id)
);

alter table bbs_admin_log comment '管理员操作日志表';

/*==============================================================*/
/* Table: bbs_article                                           */
/*==============================================================*/
create table bbs_article
(
   id                   int(11) not null auto_increment,
   title                varchar(30) not null,
   user_id              int(11) not null,
   tag_id               int(11) not null,
   content              text not null comment '文章内容',
   view_count           int(11) not null default 0,
   is_examine           tinyint(1) not null default 0,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   updated_at           timestamp not null default CURRENT_TIMESTAMP,
   status               int(11) not null default 0 comment '文章状态',
   comment_num          int(11) not null default 0,
   type                 tinyint(1) not null comment '对应码表parent_id:ARTICLE_TYPE,1表示文章，2表示问题',
   examine_result       varchar(30) comment '审核结果，审核失败时给出理由',
   primary key (id)
);

alter table bbs_article comment '文章或问题表';

/*==============================================================*/
/* Table: bbs_code_table                                        */
/*==============================================================*/
create table bbs_code_table
(
   id                   int(11) not null auto_increment,
   parent_key           varchar(20) not null,
   `key`                  int(11) not null,
   `value`               varchar(10) not null,
   primary key (id)
);

alter table bbs_code_table comment '码表';

/*==============================================================*/
/* Table: bbs_collection                                        */
/*==============================================================*/
create table bbs_collection
(
   id                   int(11) not null auto_increment,
   user_id              int(11) not null,
   article_id           int(11) not null,
   created_at           timestamp not null,
   primary key (id)
);

alter table bbs_collection comment '收藏表';

/*==============================================================*/
/* Table: bbs_comment                                           */
/*==============================================================*/
create table bbs_comment
(
   id                   int(11) not null auto_increment,
   content              text not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   like_num             int(11) not null default 0,
   article_id           int(11) not null,
   parent_id            int(11) not null comment '父级评论id',
   floor                int(11) not null,
   primary key (id)
);

alter table bbs_comment comment '文章评论';

/*==============================================================*/
/* Table: bbs_follow                                            */
/*==============================================================*/
create table bbs_follow
(
   id                   int(11) not null auto_increment,
   user_id              int(11) not null,
   follow_user_id       int(11) not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   primary key (id)
);

alter table bbs_follow comment '关注表';

/*==============================================================*/
/* Table: bbs_like                                              */
/*==============================================================*/
create table bbs_like
(
   id                   int(11) not null auto_increment,
   belong_id            int(11) not null,
   user_id              int(11) not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   type                 tinyint(1) not null comment '被点赞类型，对应码表parent_id:LIKE_TYPE,1表示文章或问题，2表示评论',
   primary key (id)
);

alter table bbs_like comment '点赞表';

/*==============================================================*/
/* Table: bbs_message                                           */
/*==============================================================*/
create table bbs_message
(
   id                   int(11) not null auto_increment,
   user_id              int(11) not null,
   message_type         tinyint(1) not null comment '消息type，对应码表，parent_id: MESSAGE_TYPE,1表示新的回复，2表示新的关注，3表示关注的人发布新消息',
   content              varchar(50) not null,
   already_read         tinyint(1) not null comment '消息是否已读',
   message_id           int(11) not null,
   created_at           timestamp not null,
   primary key (id)
);

alter table bbs_message comment '消息推送表';

/*==============================================================*/
/* Table: bbs_tag                                               */
/*==============================================================*/
create table bbs_tag
(
   id                   int(11) not null auto_increment,
   tag_name             varchar(10) not null comment '标签名',
   icon                 blob comment '标签图标',
   introduce            varchar(50) not null,
   created_at           timestamp not null default CURRENT_TIMESTAMP,
   updated_at           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

alter table bbs_tag comment '标签表';

/*==============================================================*/
/* Table: bbs_user_extend                                       */
/*==============================================================*/
create table bbs_user_extend
(
   id                   int(11) not null auto_increment,
   user_id              int(11) not null,
   message_time         timestamp not null default CURRENT_TIMESTAMP comment '最后一次获取消息时间',
   primary key (id)
);

alter table bbs_user_extend comment '用户信息扩展表';
