drop table if exists auth_user;

drop table if exists permission;

drop table if exists role;

drop table if exists role_permissions;

drop table if exists user_roles;

/*==============================================================*/
/* Table: auth_user                                             */
/*==============================================================*/
create table auth_user
(
   id                   int(11) not null auto_increment,
   nickname             varchar(20) character set utf8 not null,
   mail                 varchar(20) character set utf8,
   password             varchar(255) character set utf8 not null,
   avatar               varchar(255) character set utf8,
   register_at          timestamp(0) not null default CURRENT_TIMESTAMP,
   gender               varchar(5) character set utf8 not null,
   phone                varchar(11) character set utf8,
   current_token        varchar(1000) character set utf8,
   username             varchar(20) character set utf8 not null,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   id                   int(11) not null auto_increment,
   permission_name      varchar(50) character set utf8 not null,
   permission_code      varchar(500) character set utf8 not null,
   create_at            timestamp(0) not null default CURRENT_TIMESTAMP,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   int(11) not null auto_increment,
   role_name            varchar(50) character set utf8 not null,
   role_code            varchar(50) character set utf8 not null,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

/*==============================================================*/
/* Table: role_permissions                                      */
/*==============================================================*/
create table role_permissions
(
   id                   int(11) not null auto_increment,
   role_id              int(11) not null,
   permission_id        int(11) not null,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

/*==============================================================*/
/* Table: user_roles                                            */
/*==============================================================*/
create table user_roles
(
   id                   int(11) not null auto_increment,
   user_id              int(11) not null,
   role_id              int(11) not null,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
drop table if exists auth_user;

drop table if exists permission;

drop table if exists role;

drop table if exists role_permissions;

drop table if exists user_roles;

/*==============================================================*/
/* Table: auth_user                                             */
/*==============================================================*/
create table auth_user
(
   id                   int(11) not null auto_increment,
   nickname             varchar(20) character set utf8 not null,
   mail                 varchar(20) character set utf8 not null,
   password             varchar(255) character set utf8 not null,
   avatar               varchar(255) character set utf8,
   register_at          timestamp(0) not null default CURRENT_TIMESTAMP,
   gender               varchar(5) character set utf8 not null,
   phone                varchar(11) character set utf8 not null,
   current_token        varchar(1000) character set utf8,
   username             varchar(20) character set utf8 not null,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   id                   int(11) not null auto_increment,
   permission_name      varchar(50) character set utf8 not null,
   permission_code      varchar(500) character set utf8 not null,
   create_at            timestamp(0) not null default CURRENT_TIMESTAMP,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   int(11) not null auto_increment,
   role_name            varchar(50) character set utf8 not null,
   role_code            varchar(50) character set utf8 not null,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

/*==============================================================*/
/* Table: role_permissions                                      */
/*==============================================================*/
create table role_permissions
(
   id                   int(11) not null auto_increment,
   role_id              int(11) not null,
   permission_id        int(11) not null,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

/*==============================================================*/
/* Table: user_roles                                            */
/*==============================================================*/
create table user_roles
(
   id                   int(11) not null auto_increment,
   user_id              int(11) not null,
   role_id              int(11) not null,
   primary key (id)
)
ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
