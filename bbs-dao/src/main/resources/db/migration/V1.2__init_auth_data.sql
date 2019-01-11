


-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES (1, '超级管理员', '408106378@qq.com', '1', NULL, '2019-01-11 10:42:26', b'1', '15922784248', NULL, 'root_admin');
INSERT INTO `auth_user` VALUES (3, 'johnxiao', 'johnxiao@qq.com', '1', NULL, '2019-01-11 10:47:48', b'1', '13333333333', NULL, 'johnxiao');


-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '发布文章', '.release_article', '2019-01-11 10:49:40');
INSERT INTO `permission` VALUES (2, '评论', '.comment', '2019-01-11 10:50:05');
INSERT INTO `permission` VALUES (3, '收藏', '.collection', '2019-01-11 10:50:27');
INSERT INTO `permission` VALUES (4, '审核', '.examine', '2019-01-11 10:50:48');
INSERT INTO `permission` VALUES (5, '管理', '.manage', '2019-01-11 10:51:00');


-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '用户', 'ROLE_USER');
INSERT INTO `role` VALUES (2, '超级管理员', 'ROLE_ADMIN');
INSERT INTO `role` VALUES (3, '审核管理员', 'ROLE_EXAMINE_ADMIN');


-- ----------------------------
-- Records of role_permissions
-- ----------------------------
INSERT INTO `role_permissions` VALUES (1, 1, 1);
INSERT INTO `role_permissions` VALUES (2, 1, 2);
INSERT INTO `role_permissions` VALUES (3, 1, 3);
INSERT INTO `role_permissions` VALUES (4, 2, 4);
INSERT INTO `role_permissions` VALUES (5, 2, 5);
INSERT INTO `role_permissions` VALUES (6, 3, 4);


-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES (1, 1, 2);
INSERT INTO `user_roles` VALUES (2, 3, 1);

