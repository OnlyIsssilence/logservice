-- 创建图书表
CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` varchar(100) NOT NULL COMMENT '图书名称',
  `number` int(11) NOT NULL COMMENT '馆藏数量',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='图书表';

-- 初始化图书数据
INSERT INTO `book` (`book_id`, `name`, `number`)
VALUES
    (1000, 'Java程序设计', 10),
    (1001, '数据结构', 10),
    (1002, '设计模式', 10),
    (1003, '编译原理', 10);

-- 创建预约图书表
CREATE TABLE `appointment` (
  `book_id` bigint(20) NOT NULL COMMENT '图书ID',
  `student_id` bigint(20) NOT NULL COMMENT '学号',
  `appoint_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '预约时间' ,
  PRIMARY KEY (`book_id`, `student_id`),
  INDEX `idx_appoint_time` (`appoint_time`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '预约图书表';

-- 日志信息全量表

DROP TABLE IF EXISTS `seed_log`;
CREATE TABLE `seed_log` (
  `log_id`      VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '日志ID',
  `city_code`   VARCHAR(20) NOT NULL
  COMMENT '城市ID',
  `version`     VARCHAR(20) NOT NULL
  COMMENT '版本号',
  `uid`         VARCHAR(40) NOT NULL DEFAULT ''
  COMMENT '用户ID',
  `seed_time`   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '埋点时间',
  `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '埋点日志表';

-- 初始化图书数据
INSERT INTO `seed_log` (`city_code`, `version`, `uid`)
VALUES
  (420100, '0.0.0', 2088010);
