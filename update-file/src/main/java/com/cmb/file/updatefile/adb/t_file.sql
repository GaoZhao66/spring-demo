CREATE TABLE `t_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tuid` varchar(50) NOT NULL,
  `key` varchar(50) DEFAULT NULL COMMENT '文件键',
  `name` varchar(50) DEFAULT NULL COMMENT '文件名称',
  `type` varchar(50) DEFAULT NULL COMMENT '文件类型',
  `value` mediumtext COMMENT '文件内容',
  `size` int(20) DEFAULT NULL COMMENT '文件大小',
  `access_url` varchar(200) DEFAULT NULL COMMENT '访问路径',
  `is_delete` varchar(50) NOT NULL COMMENT '是否删除：N=否；Y=是',
  `creator_id` varchar(50) DEFAULT NULL COMMENT '创建人id',
  `creator_name` varchar(50) DEFAULT NULL COMMENT '创建人姓名',
  `creator_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人id',
  `modify_name` varchar(50) DEFAULT NULL COMMENT '修改人姓名',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_tuid` (`tuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8 COMMENT='文件存储表';