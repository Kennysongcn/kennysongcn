-----------
-- user 用户表
-----------
CREATE TABLE T_USER_INFO (
 user_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
 group_id mediumint(8) NOT NULL COMMENT '用户组ID',
 user_name varchar(32) NOT NULL COMMENT '用户名',
 user_pwd varchar(32) NOT NULL COMMENT '用户密码',
 user_phone int(12) NOT NULL COMMENT '用户手机号码',
 user_sex varchar(6) NOT NULL COMMENT '用户性别',
 user_qq mediumint(9) NOT NULL COMMENT '用户QQ号码',
 user_email varchar(64) NOT NULL COMMENT '用户EMAIL地址',
 user_address varchar(255) NOT NULL COMMENT '用户地址',
 user_mark mediumint(9) NOT NULL COMMENT '用户积分',
 user_rank_id tinyint(3) NOT NULL COMMENT '用户等级',
 user_last_login_ip varchar(15) NOT NULL COMMENT '用户上一次登录IP地址',

 user_birthday int(13) NOT NULL COMMENT '用户生日',
 user_description varchar(255) NOT NULL COMMENT '自我描述',
 user_image_url varchar(255) NOT NULL COMMENT '用户头像存储路径',
 user_school varchar(255) NOT NULL COMMENT '毕业学校',
 user_register_time int(13) NOT NULL COMMENT '用户注册时间',
 user_register_ip varchar(15) NOT NULL COMMENT '用户注册时IP地址',
 user_last_update_time int(13) NOT NULL COMMENT '用户上次更新博客时间',
 user_weibo varchar(255) NOT NULL COMMENT '用户微博',
 user_blood_type char(3) NOT NULL COMMENT '用户血型',
 user_says varchar(255) NOT NULL COMMENT '用户语录',
 user_lock tinyint(3) NOT NULL COMMENT '是否锁定，0为不锁定，1为锁定',
 user_freeze tinyint(3) NOT NULL COMMENT '是否冻结，0为不冻结，1为冻结',
 user_power varchar(255) NOT NULL COMMENT '拥有权限',
 PRIMARY KEY (user_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


-----------------
-- user_rank 用户权限表
-----------------
CREATE TABLE T_USER_RANK (
 rank_id mediumint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 user_rank_id smallint(5) NOT NULL COMMENT '等级ID',
 rank_mark mediumint(6) NOT NULL COMMENT '等级积分',
 rank_name varchar(32) NOT NULL COMMENT '等级名称',
 PRIMARY KEY (rank_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


----------------
-- user_group 用户组表
----------------
CREATE TABLE T_USER_GROUP (
 g_id tinyint(3) NOT NULL AUTO_INCREMENT COMMENT '自增ID号',
 group_id tinyint(3) NOT NULL COMMENT '用户组ID',
 group_name varchar(20) NOT NULL COMMENT '用户组名',
 group_power varchar(20) NOT NULL COMMENT '用户权限',
 PRIMARY KEY (g_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;
 
 
------------------
-- power_list 功能权限表
------------------
CREATE TABLE T_POWER_LIST (
 p_id int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 power_id int(10) NOT NULL COMMENT '权限ID',
 power_name varchar(36) NOT NULL COMMENT '权限描述',
 PRIMARY KEY (p_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

-------------------
-- friend 好友表 
-------------------
CREATE TABLE T_FRIEND (
 f_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 user_id mediumint(8) NOT NULL COMMENT '用户ID',
 friend_id mediumint(8) NOT NULL COMMENT '好友ID',
 PRIMARY KEY (f_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


----------------------
-- user_attention 用户关注表
----------------------
CREATE TABLE T_USER_ATTENTION (
 a_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 user_id mediumint(8) NOT NULL COMMENT '用户ID',
 attention_id mediumint(8) NOT NULL COMMENT '关注ID',
 PRIMARY KEY (a_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


-----------------------
-- secret_message 用户私信表
-----------------------
CREATE TABLE T_SECRET_MESSAGE (
 secret_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '自增私信ID',
 send_id mediumint(8) NOT NULL COMMENT '发信者ID',
 receive_id mediumint(8) NOT NULL COMMENT '收信者ID',
 message_topic varchar(64) NOT NULL COMMENT '私信标题',
 message_content varchar(255) NOT NULL COMMENT '私信内容',
 PRIMARY KEY (secret_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

------------------------
-- system_message 系统通知表
------------------------
CREATE TABLE T_SYSTEM_MESSAGE (
 system_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '系统通知ID',
 send_id mediumint(8) NOT NULL COMMENT '接受者ID',
 group_id tinyint(3) NOT NULL COMMENT '用户组ID',
 send_default mediumint(8) NOT NULL COMMENT '1时发送所有用户，0时则不采用',
 system_topic varchar(60) NOT NULL COMMENT '通知内容',
 system_content varchar(255) NOT NULL COMMENT '通知内容',
 PRIMARY KEY (system_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


--------------------------
-- friendly_link 友情链接
--------------------------
CREATE TABLE T_FRIENDLY_LINK (
 link_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '友情链接自增ID',
 link_name varchar(60) NOT NULL COMMENT '友情链接名称',
 link_url varchar(255) NOT NULL COMMENT '链接地址',
 link_logo varchar(255) NOT NULL COMMENT 'LOGO图片',
 show_order tinyint(3) NOT NULL COMMENT '在页面显示的顺序',
 PRIMARY KEY (link_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


--------------------------
-- ad 广告表
--------------------------
CREATE TABLE T_AD (
 ad_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 position_id smallint(5) NOT NULL COMMENT '0,站外广告;从1开始代表的是该广告所处的广告位,同表ad_postition中的字段position_id的值',
 media_type tinyint(3) NOT NULL DEFAULT 0 COMMENT '广告类型,0图片;1flash;2代码3文字',
 ad_name varchar(60) NOT NULL COMMENT '该条广告记录的广告名称',
 ad_link varchar(255) NOT NULL COMMENT '广告链接地址',
 ad_code text NOT NULL COMMENT '广告链接的表现,文字广告就是文字或图片和flash就是它们的地址',
 start_time int(13) NOT NULL DEFAULT 0 COMMENT '广告开始时间',
 end_time int(13) NOT NULL DEFAULT 0 COMMENT '广告结束时间',
 link_man varchar(60) NOT NULL COMMENT '广告联系人',
 link_email varchar(60) NOT NULL COMMENT '广告联系人的邮箱',
 link_phone varchar(60) NOT NULL COMMENT '广告联系人得电话',
 click_count mediumint(8) NOT NULL DEFAULT 0 COMMENT '广告点击次数',
 enabled tinyint(3) NOT NULL DEFAULT 1 COMMENT '该广告是否关闭;1开启; 0关闭; 关闭后广告将不再有效',
 PRIMARY KEY (ad_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


--------------------
-- stay_message 用户留言表
--------------------
CREATE TABLE T_STAY_MESSAGE (
 stay_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '留言表自增ID',
 user_id mediumint(8) NOT NULL COMMENT '用户ID',
 stay_user_id mediumint(8) NOT NULL COMMENT '留言者ID',
 message_content varchar(255) NOT NULL COMMENT '留言内容',
 stay_user_ip varchar(15) NOT NULL COMMENT '留言用户的IP地址',
 message_stay_time int(13) NOT NULL COMMENT '留言时间',
 place varchar(64) NOT NULL COMMENT '地区',
 PRIMARY KEY (stay_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


----------------------
-- about_blog 博客信息表
----------------------
CREATE TABLE T_ABOUT_BLOG (
 blog_id mediumint(8) NOT NULL  COMMENT '用户ID',
 blog_keyword varchar(255) NOT NULL COMMENT '博客关键字',
 blog_description varchar(255) NOT NULL COMMENT '博客描述',
 blog_name varchar(36) NOT NULL COMMENT '博客名称',
 blog_title varchar(128) NOT NULL COMMENT '博客标题',
 PRIMARY KEY (blog_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

------------------------
-- visitor 最近访客表
------------------------
CREATE TABLE T_VISITOR (
 v_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '访客记录ID',
 visitor_id mediumint(8) NOT NULL COMMENT '访客ID',
 visitor_time int(13) NOT NULL COMMENT '来访时间',
 user_id mediumint(8) NOT NULL COMMENT '被访用户ID',
 visitor_ip varchar(15) NOT NULL COMMENT '访客IP地址',
 type_id int(3) NOT NULL COMMENT '访问板块ID',
 where_id mediumint(8) NOT NULL COMMENT '查看某板块的某个子项目，如查看相册板块的第3个相册，该ID对应该相册的ID号',
 PRIMARY KEY (v_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

-------------------------
-- shuoshuo 用户心情说说表
-------------------------
CREATE TABLE T_SHOUSHOU(
 shuo_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '说说记录ID',
 user_id mediumint(8) NOT NULL COMMENT '用户ID',
 shuo_time int(13) NOT NULL DEFAULT 0 COMMENT '发布时间',
 shuo_ip varchar(15) NOT NULL COMMENT '说说发布时的IP地址',
 shuoshuo varchar(255) NOT NULL COMMENT '说说内容',
 type_id tinyint(3) NOT NULL DEFAULT 3 COMMENT '栏目ID,默认为3',
 PRIMARY KEY (shuo_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

-------------------------
-- photo_sort 相片分类表
-------------------------
CREATE TABLE T_PHOTO_SORT(
 sort_img_id mediumint(8) NOT NULL  AUTO_INCREMENT COMMENT '相册ID',
 sort_img_name varchar(20) NOT NULL COMMENT '相册名',
 sort_img_type varchar(20) NOT NULL COMMENT '展示方式 0->仅主人可见,1->输入密码即可查看,2->仅好友能查看,3->回答问题即可查看',
 img_password varchar(32) NOT NULL COMMENT '查看密码',
 user_id mediumint(8) NOT NULL COMMENT '所属用户ID',
 img_sort_question varchar(255) NOT NULL COMMENT '访问问题',
 img_sort_answer varchar(128) NOT NULL COMMENT '访问问题的答案',
 type_id int(3) NOT NULL DEFAULT 1 COMMENT '默认1表示相册板块',
 top_pic_src mediumint(8) NOT NULL COMMENT '封面图片的路径',
 PRIMARY KEY (sort_img_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

-------------------------
-- photos 相片表
-------------------------
CREATE TABLE T_PHOTOS(
 photo_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '相片ID',
 photo_name varchar(255) NOT NULL COMMENT '相片名称',
 photo_src varchar(255) NOT NULL COMMENT '图片路径',
 photo_description varchar(255) NOT NULL COMMENT '图片描述',
 user_id mediumint(8) NOT NULL COMMENT '所属用户ID',
 sort_id mediumint(8) NOT NULL COMMENT '所属相册ID',
 upload_time int(13) NOT NULL COMMENT '图片上传时间',
 upload_ip varchar(15) NOT NULL COMMENT '图片操作上传IP地址',
 PRIMARY KEY (photo_id) 
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 


---------------------------
-- article_sort 文章分类表
---------------------------
CREATE TABLE T_ARTICLE_SORT (
 sort_article_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '文章自增ID',
 user_id mediumint(8) NOT NULL COMMENT '该分类所属用户',
 sort_article_name varchar(60) NOT NULL COMMENT '分类名称',
 PRIMARY KEY (sort_article_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

----------------------------
-- article 文章表
----------------------------
CREATE TABLE T_ARTICLE_INFO(
 article_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '日志自增ID号',
 article_name varchar(128) NOT NULL COMMENT '文章名称',
 article_time int(13) NOT NULL COMMENT '发布时间',
 article_ip varchar(15) NOT NULL COMMENT '发布IP',
 article_click int(10) NOT NULL COMMENT '查看人数',
 sort_article_id mediumint(8) NOT NULL COMMENT '所属分类',
 user_id mediumint(8) NOT NULL COMMENT '所属用户ID',
 type_id tinyint(3) NOT NULL DEFAULT 1 COMMENT '栏目ID',
 article_type int(13) NOT NULL DEFAULT 1 COMMENT '文章的模式:0为私有，1为公开，2为仅好友查看',
 article_content text NOT NULL COMMENT '文章内容',
 article_up tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否置顶:0为否，1为是',
 article_support tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否博主推荐:0为否，1为是',
 PRIMARY KEY (article_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 


----------------------------
-- user_comment 用户评论表
----------------------------
CREATE TABLE T_USER_COMMENT(
 c_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '评论自增ID号',
 user_id mediumint(8) NOT NULL COMMENT '收到评论的用户ID',
 type_id tinyint(3) NOT NULL COMMENT '评论栏目ID',
 commit_id mediumint(8) NOT NULL COMMENT '评论内容的ID',
 commit_content varchar(255) NOT NULL COMMENT '评论内容',
 commit_user_id mediumint(8) NOT NULL COMMENT '评论者ID',
 commit_time int(13) NOT NULL COMMENT '评论时间',
 commit_ip varchar(15) NOT NULL COMMENT '评论时的IP地址',
 PRIMARY KEY (c_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

------------------------------
-- phone_message 短信记录表
------------------------------
CREATE TABLE T_PHONE_MESSAGE (
 phone_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '自增ID号',
 phone_num varchar(12) NOT NULL COMMENT '用户手机号码',
 contents varchar(255) NOT NULL COMMENT '发送内容',
 send_time int(13) NOT NULL COMMENT '发送时间',
 user_id mediumint(8) NOT NULL COMMENT '用户ID',
 PRIMARY KEY (phone_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;
-------------------------------------------------

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- t_module 系统模块表
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `MODULE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块ID',
  `MODULE_NAME` varchar(55) DEFAULT NULL COMMENT '模块名称',
  `MODULE_SN` varchar(55) DEFAULT NULL COMMENT 'SN',
  `MODULE_URL` varchar(255) DEFAULT NULL COMMENT '模块URL',
  `PARENT_MODULE_ID` int(11) DEFAULT NULL COMMENT '父模块ID',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `ICON` varchar(255) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`MODULE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='系统模块表';

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('1', '资源管理系统', 'RMS', null, null, '2015-12-29 16:12:49', '2015-12-29 16:12:52', null, null);
INSERT INTO `t_module` VALUES ('2', '系统管理', 'SystemManage', null, '1', '2015-12-29 16:14:06', '2015-12-29 16:14:10', null, 'icon icon-sysicon');
INSERT INTO `t_module` VALUES ('3', '角色管理', 'RoleManage', '/manage/role', '2', '2015-12-29 16:14:43', '2015-12-29 16:14:45', null, 'icon icon-user');
INSERT INTO `t_module` VALUES ('4', '模块管理', 'PermissionManage', '/manage/module', '2', '2015-12-29 16:15:17', '2015-12-29 16:15:19', null, 'icon icon-module');
INSERT INTO `t_module` VALUES ('5', '角色权限管理', 'RolePermissionManage', '/manage/rolepermission', '2', '2015-12-29 22:55:21', '2015-12-29 22:55:23', null, 'menu icon-add');
INSERT INTO `t_module` VALUES ('6', '用户管理', 'UserInfoManage', '/manage/userinfo', '2', '2015-12-29 23:12:22', '2015-12-29 23:12:24', null, 'icon icon-userse');
INSERT INTO `t_module` VALUES ('7', '用户角色管理', 'UserRoleManage', '/manage/userrole', '2', '2015-12-29 23:32:22', '2015-12-29 23:32:24', null, 'icon icon-userom');
INSERT INTO `t_module` VALUES ('8', '岗位管理', 'PositionManage', '/manage/position', '2', '2015-12-29 23:58:11', '2015-12-29 23:58:13', null, 'icon icon-postses');
INSERT INTO `t_module` VALUES ('9', '岗位角色管理', 'PositionRoleManage', '/manage/positionrole', '2', '2015-12-30 00:16:43', '2015-12-30 00:16:45', null, 'icon icon-posts');

-- ----------------------------
-- t_permission 系统权限表
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `PERMISSION_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `PERMISSION_NAME` varchar(55) DEFAULT NULL COMMENT '权限名称',
  `PERMISSION_SN` varchar(55) DEFAULT NULL COMMENT 'SN',
  `MODULE_ID` int(11) DEFAULT NULL COMMENT '模块ID',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`PERMISSION_ID`),
  KEY `FK_Reference_3` (`MODULE_ID`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`MODULE_ID`) REFERENCES `t_module` (`MODULE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '查看', 'show', '2', '2015-12-29 16:17:04', '2015-12-29 16:17:04', null);
INSERT INTO `t_permission` VALUES ('2', '查看', 'show', '3', '2015-12-29 16:17:04', '2015-12-29 16:17:04', null);
INSERT INTO `t_permission` VALUES ('3', '查看', 'show', '4', '2015-12-29 16:17:04', '2015-12-29 16:17:04', null);
INSERT INTO `t_permission` VALUES ('4', '查看', 'show', '5', '2015-12-30 00:32:46', '2015-12-30 00:32:48', null);
INSERT INTO `t_permission` VALUES ('5', '查看', 'show', '6', '2015-12-30 00:32:51', '2015-12-30 00:32:53', null);
INSERT INTO `t_permission` VALUES ('6', '查看', 'show', '7', '2015-12-30 00:32:55', '2015-12-30 00:32:57', null);
INSERT INTO `t_permission` VALUES ('7', '查看', 'show', '8', '2015-12-30 00:33:00', '2015-12-30 00:33:02', null);
INSERT INTO `t_permission` VALUES ('8', '查看', 'show', '9', '2015-12-30 00:33:04', '2015-12-30 00:33:06', null);
INSERT INTO `t_permission` VALUES ('19', '查询', 'select', '3', '2016-01-05 17:22:42', '2016-01-05 17:22:42', '查询角色');
INSERT INTO `t_permission` VALUES ('20', '新增', 'add', '3', '2016-01-05 17:22:55', '2016-01-05 17:22:55', '新增角色');
INSERT INTO `t_permission` VALUES ('21', '编辑', 'edit', '3', '2016-01-05 17:23:08', '2016-01-05 17:23:08', '编辑角色');
INSERT INTO `t_permission` VALUES ('22', '新增模块', 'addModule', '4', '2016-01-05 17:24:21', '2016-01-05 17:24:21', '新增模块按钮');
INSERT INTO `t_permission` VALUES ('23', '新增权限', 'addPermission', '4', '2016-01-05 17:24:41', '2016-01-05 17:24:41', '新增权限按钮');
INSERT INTO `t_permission` VALUES ('24', '保存权限', 'savePermission', '5', '2016-01-05 17:25:36', '2016-01-05 17:25:36', '保存权限按钮');
INSERT INTO `t_permission` VALUES ('25', '查询', 'select', '6', '2016-01-05 17:26:06', '2016-01-05 17:26:06', '查询用户');
INSERT INTO `t_permission` VALUES ('26', '关联', 'relate', '7', '2016-01-05 17:27:02', '2016-01-05 17:27:02', '关联用户按钮');
INSERT INTO `t_permission` VALUES ('27', '取消关联', 'cancelRelate', '7', '2016-01-05 17:27:27', '2016-01-05 17:27:27', '取消关联用户按钮');
INSERT INTO `t_permission` VALUES ('28', '关联', 'relate', '9', '2016-01-05 17:28:04', '2016-01-05 17:28:04', '关联岗位按钮');
INSERT INTO `t_permission` VALUES ('29', '取消关联', 'cancelRelate', '9', '2016-01-05 17:28:24', '2016-01-05 17:28:24', '取消关联岗位按钮');

-- ----------------------------
--t_role 角色表
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_NAME` varchar(55) DEFAULT NULL COMMENT '角色名称',
  `IS_VALID` int(2) DEFAULT NULL COMMENT '是否有效',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', '1', '2015-12-29 16:17:04', '2015-12-29 16:17:04', '系统管理员');
INSERT INTO `t_role` VALUES ('2', '默认角色', '1', '2016-01-05 14:22:24', '2016-01-14 16:51:43', '改角色用于与默认岗位进行关联');

-- ----------------------------
-- Table structure for t_role_permission 角色权限表
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `ROLE_PERMISSION_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限ID',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色ID',
  `PERMISSION_ID` int(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`ROLE_PERMISSION_ID`),
  KEY `FK_Reference_4` (`ROLE_ID`),
  KEY `FK_Reference_5` (`PERMISSION_ID`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`ROLE_ID`) REFERENCES `t_role` (`ROLE_ID`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`PERMISSION_ID`) REFERENCES `t_permission` (`PERMISSION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1945 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1866', '1', '1');
INSERT INTO `t_role_permission` VALUES ('1867', '1', '2');

-- ----------------------------
-- Table structure for t_user_info1 用户信息表1
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info1`;
CREATE TABLE `t_user_info1` (
  `USER_INFO_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `NAME` varchar(20) DEFAULT NULL COMMENT '用户名',
  `LOGINNAME` varchar(55) DEFAULT NULL COMMENT '登录名',
  `LOGINPWD` varchar(32) DEFAULT NULL COMMENT '密码',
  `EMAIL` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `TELPHONE` varchar(50) DEFAULT NULL COMMENT '手机',
  `OA_POSITION_ID` varchar(20) DEFAULT NULL,
  `POSITION_NAME` varchar(50) DEFAULT NULL,
  `DEPARTMENT` varchar(50) DEFAULT NULL COMMENT '所属部门',
  `SUPERIOR` varchar(30) DEFAULT NULL COMMENT '上级',
  `USER_CODE` varchar(50) DEFAULT NULL COMMENT '用户编码',
  `USER_STATUS` int(11) DEFAULT NULL COMMENT '用户状态',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`USER_INFO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user_info1
-- ----------------------------
INSERT INTO `t_user_info1` VALUES ('2', '蔡璐', 'cailu', null, 'cailu@hercules-logistics.com', '18682336504', null, 'IT研发工程师', '研发3组', 'HG9340', 'HG8183', '3', null, '2016-03-29 17:53:26');
INSERT INTO `t_user_info1` VALUES ('3', '鲁志龙', 'luzhilong', null, 'luzhilong@hercules-logistics.com', '15919892301', null, '研发工程师', '研发3组', 'HG9340', 'HG9856', '3', null, '2016-03-31 16:05:46');
INSERT INTO `t_user_info1` VALUES ('4', '黄焱根', 'huangyangen', null, 'huangyangen@hercules-logistics.com', '13760212563', null, '高级研发工程师', '研发3组', 'HG9340', 'HG9884', '0', null, '2016-03-31 16:07:20');
INSERT INTO `t_user_info1` VALUES ('5', '宋志浩', 'songzhihao', null, 'songzhihao@hercules-logistics.com', '13590118250', null, 'IT研发工程师', '研发3组', 'HG9340', 'HG9391', '3', null, '2016-03-31 10:04:47');

-- ----------------------------
-- Table structure for t_user_role 用户角色表
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `USER_ROLE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色ID',
  `USER_INFO_ID` int(11) DEFAULT NULL COMMENT '用户ID',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_Reference_1` (`USER_INFO_ID`),
  KEY `FK_Reference_2` (`ROLE_ID`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`USER_INFO_ID`) REFERENCES `t_user_info1` (`USER_INFO_ID`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `t_role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('21', '3', '1');
INSERT INTO `t_user_role` VALUES ('22', '2', '1');
INSERT INTO `t_user_role` VALUES ('23', '4', '1');
INSERT INTO `t_user_role` VALUES ('26', '5', '1');