-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: graduation
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `a_base_assignment`
--

DROP TABLE IF EXISTS `a_base_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_assignment` (
  `id` int(16) NOT NULL,
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  `state_code` int(4) DEFAULT NULL COMMENT '状态码，0：未下发，1：已下发，2：已确认查看',
  `send_time` datetime DEFAULT NULL COMMENT '下发时间',
  `student_id` int(16) DEFAULT NULL COMMENT '接收学生id',
  `teacher_id` int(16) DEFAULT NULL COMMENT '发送教师id',
  `assignment_content` longtext COMMENT '主要内容和要求',
  `design_schedule` longtext COMMENT '毕业设计进度安排',
  `reference` longtext COMMENT '主要参考资料',
  `device` longtext COMMENT '主要仪器设备及材料',
  `place` varchar(255) DEFAULT NULL COMMENT '场地及要求',
  `answer_time` varchar(255) DEFAULT NULL COMMENT '指导答疑时间安排',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_assignment`
--

LOCK TABLES `a_base_assignment` WRITE;
/*!40000 ALTER TABLE `a_base_assignment` DISABLE KEYS */;
INSERT INTO `a_base_assignment` VALUES (1,'已下发',0,'2019-01-01 16:19:40',21,11,'主要内容：为解决Hadoop大数据平台组件的统一授权管理与访问控制问题，本课题设计实现面向Hadoop平台的授权管理与访问控制组件，研究基于策略和用户身份的大数据组件访问权限模型，为Hadoop平台的HDFS、YARN、HBase等大数据平台组件提供一个集中的权限管理机制，通过配置策略来控制用户访问HDFS文件夹、HDFS文件、数据库、表、字段的细粒度权限，支持基于LDAP、文件的用户同步机制，且可扩展，同时权限可与hadoop无缝对接，为大数据平台的安全提供重要支撑。 \r\n主要要求：本文要求在充分调研分析国内外有关大数据平台授权模型与访问控制技术研究现状基础上，研究设计Hadoop大数据平台组件的统一授权管理与访问控制，采用Ranger、Eagle等开源框架研究实现Hadoop平台的授权管理、访问控制与行为审计等功能。 ','（1）资料收集与开题准备：2018.12-2019.2\r\n（2）开题答辩与方案完善：2019.2-2019.3\r\n（3）技术研究与总体设计：2019.3-2019.4  \r\n（4）系统开发与测试：2019.4-2019.5 \r\n（5）撰写学位论文与准备答辩：2019.5-2019.6','《GB/T xxxx大数据安全管理指南》\r\n《GB/T xxxx信息安全技术 数据交易服务安全要求》\r\n《GBT 35274-2017 信息安全技术 大数据服务安全能力要求》\r\n《信息安全技术 数据安全能力成熟度模型》\r\n《GBT 7027-2002 信息分类和编码的基本原则与方法》\r\n《GBT 19715.1-2005 信息技术信息技术安全管理指南第1部分：信息技术安全概念和模型》\r\n政务大数据安全组件设计方案','高性能计算机2台及互联网环境','具备互联网和局域网环境的实验室','每周一、二、三、四、五下午14:00至17:00'),(2,'已下发',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `a_base_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_firstdraft`
--

DROP TABLE IF EXISTS `a_base_firstdraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_firstdraft` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '论文初稿ID-主键',
  `usr_id` int(11) NOT NULL COMMENT '学生id',
  `usr_name` varchar(255) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL COMMENT '课题ID',
  `project_name` varchar(255) DEFAULT '' COMMENT '课题名称',
  `file_paper` varchar(255) DEFAULT '' COMMENT '设计（论文）文件',
  `file_attachment` varchar(255) DEFAULT '' COMMENT '设计（论文）附件',
  `is_submit` int(1) DEFAULT '0' COMMENT '是否提交',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `update_datetime` datetime DEFAULT NULL COMMENT '上次修改时间',
  `deleted_num` int(1) DEFAULT NULL COMMENT '删除码，1：未删除，0：已删除',
  `deleted_name` varchar(255) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_firstdraft`
--

LOCK TABLES `a_base_firstdraft` WRITE;
/*!40000 ALTER TABLE `a_base_firstdraft` DISABLE KEYS */;
INSERT INTO `a_base_firstdraft` VALUES (1,21,'1学生1',11,'课题11','','',0,'2019-02-01 15:58:38','2019-04-08 15:59:05',NULL,NULL),(2,22,'1学生2',12,'课题12','','',0,'2019-02-01 16:00:19','2019-04-08 16:00:31',NULL,NULL);
/*!40000 ALTER TABLE `a_base_firstdraft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_group`
--

DROP TABLE IF EXISTS `a_base_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_group` (
  `id` int(16) NOT NULL,
  `group_id` int(16) DEFAULT NULL COMMENT '专家组编号',
  `group_name` varchar(255) DEFAULT NULL COMMENT '专家组名称',
  `group_leader` int(32) DEFAULT NULL COMMENT '专家组组长ID',
  `group_secretary` int(32) DEFAULT NULL COMMENT '专家组秘书ID',
  `group_member` int(32) DEFAULT NULL COMMENT '专家组成员ID',
  `time` datetime DEFAULT NULL COMMENT '答辩时间',
  `place` varchar(255) DEFAULT NULL COMMENT '答辩地点',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_group`
--

LOCK TABLES `a_base_group` WRITE;
/*!40000 ALTER TABLE `a_base_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `a_base_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_guidance`
--

DROP TABLE IF EXISTS `a_base_guidance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_guidance` (
  `id` int(11) NOT NULL,
  `student_id` int(16) DEFAULT NULL COMMENT '学生ID',
  `student_name` varchar(255) DEFAULT NULL COMMENT '学生姓名',
  `guidance_date` datetime DEFAULT NULL COMMENT '指导日期',
  `guidance_hour` double(5,0) DEFAULT NULL COMMENT '指导小时数',
  `guidance_content` longtext COMMENT '主要指导内容',
  `guidance_problem` longtext COMMENT '存在问题及改进意见',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `appendix` varchar(255) DEFAULT NULL COMMENT '附件',
  `create_date` datetime DEFAULT NULL COMMENT '记录创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '最近更新时间',
  `deleted_num` int(1) DEFAULT NULL COMMENT '删除码，1：未删除，0：已删除',
  `deleted_state` varchar(255) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_guidance`
--

LOCK TABLES `a_base_guidance` WRITE;
/*!40000 ALTER TABLE `a_base_guidance` DISABLE KEYS */;
/*!40000 ALTER TABLE `a_base_guidance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_menu`
--

DROP TABLE IF EXISTS `a_base_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_menu` (
  `id` int(11) NOT NULL,
  `p_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_menu`
--

LOCK TABLES `a_base_menu` WRITE;
/*!40000 ALTER TABLE `a_base_menu` DISABLE KEYS */;
INSERT INTO `a_base_menu` VALUES (1,1,'学生选题');
/*!40000 ALTER TABLE `a_base_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_midsupervise`
--

DROP TABLE IF EXISTS `a_base_midsupervise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_midsupervise` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '中期报告ID主键',
  `student_id` int(11) NOT NULL COMMENT '学生ID',
  `project_id` int(11) NOT NULL COMMENT '课题ID',
  `mid_state_number` int(11) NOT NULL COMMENT '中期报告状态码，1：未审核，2：不合格，3：审核通过',
  `mid_state_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '中期报告状态',
  `is_schedule` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '是否符合任务书要求进度',
  `is_finish` varchar(255) NOT NULL COMMENT '是否按期完成',
  `finished_text` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '已完成的任务',
  `unfinished_text` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '尚需完成的任务',
  `exited_problems` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存在的问题',
  `approach` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '拟采取的方法',
  `attachment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '附件名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_midsupervise`
--

LOCK TABLES `a_base_midsupervise` WRITE;
/*!40000 ALTER TABLE `a_base_midsupervise` DISABLE KEYS */;
INSERT INTO `a_base_midsupervise` VALUES (1,1,1,1,'未查看','1','1','数据添加','很多','很多','很多','1.txt');
/*!40000 ALTER TABLE `a_base_midsupervise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_paper`
--

DROP TABLE IF EXISTS `a_base_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_paper` (
  `id` int(16) NOT NULL COMMENT '序号',
  `project_id` varchar(255) DEFAULT NULL COMMENT '课题ID',
  `project_name` varchar(255) DEFAULT NULL COMMENT '课题名称',
  `paper_content` varchar(255) DEFAULT NULL COMMENT '论文内容',
  `reference` varchar(255) DEFAULT NULL COMMENT '参考文献',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '最近更新时间',
  `deleted_number` int(1) DEFAULT NULL COMMENT '删除标识符，1：已删除，0：未删除',
  `deleted_name` varchar(255) DEFAULT NULL COMMENT '是否删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_paper`
--

LOCK TABLES `a_base_paper` WRITE;
/*!40000 ALTER TABLE `a_base_paper` DISABLE KEYS */;
INSERT INTO `a_base_paper` VALUES (1,'1','大数据应用','大数据应用论文内容','《hadoop源码解析》','2019-04-08 19:46:29','2019-04-08 19:46:32',NULL,NULL,'无'),(2,'2','大数据平台授权模型与访问控制技术研究与实现','为解决Hadoop大数据平台组件的统一授权管理与访问控制问题，本课题设计实现面向Hadoop平台的授权管理与访问控制组件，研究基于策略和用户身份的大数据组件访问权限模型，为Hadoop平台的HDFS、YARN、HBase等大数据平台组件提供一个集中的权限管理机制，通过配置策略来控制用户访问HDFS文件夹、HDFS文件、数据库、表、字段的细粒度权限，支持基于LDAP、文件的用户同步机制，且可扩展，同时权限可与hadoop无缝对接，为大数据平台的安全提供重要支撑。','Hadoop大数据平台基础\r\nHadoop大数据平台开发\r\nHadoop平台Eagle、Ranger组件开发','2019-03-15 19:48:03','2019-04-08 19:48:09',NULL,NULL,'无');
/*!40000 ALTER TABLE `a_base_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_project`
--

DROP TABLE IF EXISTS `a_base_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_project` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '课题名称',
  `type` varchar(255) DEFAULT NULL COMMENT '题目类型',
  `source` varchar(255) DEFAULT NULL COMMENT '题目来源',
  `workload` varchar(255) DEFAULT NULL COMMENT '工作量',
  `difficulty` varchar(255) DEFAULT NULL COMMENT '困难度',
  `introduce` varchar(255) DEFAULT NULL COMMENT '题目简介',
  `requirement` varchar(255) DEFAULT NULL COMMENT '毕业设计要求',
  `reference` varchar(255) DEFAULT NULL COMMENT '主要参考资料',
  `major` varchar(255) DEFAULT NULL COMMENT '课题适用专业',
  `appendix` varchar(255) DEFAULT NULL COMMENT '附件',
  `deleted_code` int(255) DEFAULT NULL COMMENT '删除码，1：已删除，0：未删除',
  `deleted_name` varchar(255) DEFAULT NULL COMMENT '删除状态',
  `state_code` int(255) DEFAULT NULL COMMENT '状态码，2：已审核，1：已选，0：未选',
  `state_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_project`
--

LOCK TABLES `a_base_project` WRITE;
/*!40000 ALTER TABLE `a_base_project` DISABLE KEYS */;
INSERT INTO `a_base_project` VALUES (1,'大数据应用','毕业设计','校外立项科研','较小','简单','大数据应用课题介绍','需要的工作','《hadoop源码解析》','计算机技术','sss',0,'未删除',0,'未选'),(2,'大数据平台授权模型与访问控制技术研究与实现','毕业设计','校外立项科研','适中','一般','为解决Hadoop大数据平台组件的统一授权管理与访问控制问题，本课题设计实现面向Hadoop平台的授权管理与访问控制组件，研究基于策略和用户身份的大数据组件访问权限模型，为Hadoop平台的HDFS、YARN、HBase等大数据平台组件提供一个集中的权限管理机制，通过配置策略来控制用户访问HDFS文件夹、HDFS文件、数据库、表、字段的细粒度权限，支持基于LDAP、文件的用户同步机制，且可扩展，同时权限可与hadoop无缝对接，为大数据平台的安全提供重要支撑。','掌握信息安全基础知识；\r\n掌握C++和组件开发技术；\r\n具备搭建Hadoop大数据平台的能力。','Hadoop大数据平台基础\r\nHadoop大数据平台开发\r\nHadoop平台Eagle、Ranger组件开发','保密管理 [0402]','无',0,'未删除',1,'已选');
/*!40000 ALTER TABLE `a_base_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_recommend`
--

DROP TABLE IF EXISTS `a_base_recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `point` double DEFAULT NULL COMMENT '教师所打分数',
  `recommend_text` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评语内容录入',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_ok` int(1) NOT NULL DEFAULT '0' COMMENT '教务处表示是否通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_recommend`
--

LOCK TABLES `a_base_recommend` WRITE;
/*!40000 ALTER TABLE `a_base_recommend` DISABLE KEYS */;
INSERT INTO `a_base_recommend` VALUES (1,21,1,11,80,'需要抓紧进度','2019-03-01 19:33:50',1);
/*!40000 ALTER TABLE `a_base_recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_replyrecord`
--

DROP TABLE IF EXISTS `a_base_replyrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_replyrecord` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usr_id` int(11) NOT NULL,
  `teacher_id` int(255) NOT NULL,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `question_text` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答辩问题录入',
  `reply_text` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题回答录入',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_replyrecord`
--

LOCK TABLES `a_base_replyrecord` WRITE;
/*!40000 ALTER TABLE `a_base_replyrecord` DISABLE KEYS */;
INSERT INTO `a_base_replyrecord` VALUES (1,22,11,'大数据平台授权模型与访问控制技术研究与实现','实现的语言','c#','2019-04-08 19:49:41');
/*!40000 ALTER TABLE `a_base_replyrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_role`
--

DROP TABLE IF EXISTS `a_base_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `deleted_code` int(255) DEFAULT NULL COMMENT '删除码，1：未删除，0：已删除',
  `deleted_name` varchar(255) DEFAULT NULL COMMENT '删除状态',
  `state_code` int(255) DEFAULT NULL COMMENT '状态码',
  `state_name` varchar(255) DEFAULT NULL COMMENT '状态',
  `sort_index` int(255) DEFAULT NULL COMMENT '索引',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_role`
--

LOCK TABLES `a_base_role` WRITE;
/*!40000 ALTER TABLE `a_base_role` DISABLE KEYS */;
INSERT INTO `a_base_role` VALUES (11,'指导教师1',0,'未删除',0,'已启用',0,'备注'),(21,'学生1',0,'未删除',1,'已启用',1,'备注'),(22,'学生2',0,'未删除',1,'已启用',1,'备注'),(31,'教务处老师1',0,'未删除',1,'已启用',1,'备注');
/*!40000 ALTER TABLE `a_base_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_role_menu`
--

DROP TABLE IF EXISTS `a_base_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_role_menu` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_role_menu`
--

LOCK TABLES `a_base_role_menu` WRITE;
/*!40000 ALTER TABLE `a_base_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `a_base_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_role_user`
--

DROP TABLE IF EXISTS `a_base_role_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_role_user` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_role_user`
--

LOCK TABLES `a_base_role_user` WRITE;
/*!40000 ALTER TABLE `a_base_role_user` DISABLE KEYS */;
INSERT INTO `a_base_role_user` VALUES (1,21,2),(2,22,2);
/*!40000 ALTER TABLE `a_base_role_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_syslog`
--

DROP TABLE IF EXISTS `a_base_syslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_syslog` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(255) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(255) DEFAULT NULL COMMENT '请求参数',
  `time` int(11) DEFAULT NULL COMMENT '执行时长（毫秒）',
  `ip` varchar(255) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_syslog`
--

LOCK TABLES `a_base_syslog` WRITE;
/*!40000 ALTER TABLE `a_base_syslog` DISABLE KEYS */;
INSERT INTO `a_base_syslog` VALUES ('1240b88eb1234b409376ecc422b38530','张博文','查询全部课题','com.dky.modules.sys.controller.WebProjectController.list()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',68,'0:0:0:0:0:0:0:1','2019-04-07 23:17:33'),('1e34a55547c24f9ab51c99cd887a18e7','张博文','查询全部课题','com.dky.modules.sys.controller.WebProjectController.list()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',82,'0:0:0:0:0:0:0:1','2019-04-08 11:09:56'),('293aecf41c604d3ca8d562cb7e509ec4','张博文','获取角色列表','com.dky.modules.sys.controller.WebRoleController.select()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',385,'0:0:0:0:0:0:0:1','2019-04-08 08:41:20'),('297bc57b68294196aa84ebbbfd902ced','张博文','根据Id查找角色','com.dky.modules.sys.controller.WebRoleController.selectById()','\"1\"',22,'0:0:0:0:0:0:0:1','2019-04-08 08:37:45'),('2c9bca79962e4c4cb0dd11ded954031e','张博文','查询全部课题','com.dky.modules.sys.controller.WebProjectController.list()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',18,'0:0:0:0:0:0:0:1','2019-04-08 11:12:06'),('35f533775c124106ba80cb5ec363e0d7','张博文','根据Id查找角色','com.dky.modules.sys.controller.WebRoleController.selectById()','\"2\"',5,'0:0:0:0:0:0:0:1','2019-04-08 08:37:50'),('434ab712fff745f78d00b391640c2758','张博文','获取角色列表','com.dky.modules.sys.controller.WebRoleController.select()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',13,'0:0:0:0:0:0:0:1','2019-04-07 18:46:18'),('436ab945fb5c414dab3384324a12693d','张博文','查询全部课题','com.dky.modules.sys.controller.WebProjectController.list()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',14,'0:0:0:0:0:0:0:1','2019-04-08 08:42:25'),('48095399f75841d69847f386ad77842c','张博文','获取角色列表','com.dky.modules.sys.controller.WebRoleController.select()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',95,'0:0:0:0:0:0:0:1','2019-04-07 12:55:01'),('4983b72af50e4ca7ba56bfe3269fa22a','张博文','保存或更新角色','com.dky.modules.sys.controller.WebRoleController.saveOrUpdage()','{\"deletedCode\":0,\"deletedName\":\"string\",\"id\":\"1\",\"name\":\"string\",\"remark\":\"string\",\"sortIndex\":0,\"stateCode\":0,\"stateName\":\"string\"}',30,'0:0:0:0:0:0:0:1','2019-04-07 18:44:16'),('4a4880976dcf42a9ad75a90ff46223d0','张博文','删除课题，未删除','com.dky.modules.sys.controller.WebProjectController.deleteProject()','[\"1\"]',13,'0:0:0:0:0:0:0:1','2019-04-08 10:34:18'),('53f52e7a6dc94b689b3cf21be68c3f85','张博文','查询全部课题','com.dky.modules.sys.controller.WebProjectController.list()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',23,'0:0:0:0:0:0:0:1','2019-04-08 14:07:37'),('592dcd44c8894874a3c85c0c5830619b','张博文','用户登录token验证','com.dky.modules.sys.controller.WebLoginController.check()',NULL,3,'0:0:0:0:0:0:0:1','2019-04-07 23:15:25'),('60bb9ae9a72e4d959bd10bb206bcbb0c','张博文','获取角色列表','com.dky.modules.sys.controller.WebRoleController.select()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',82,'0:0:0:0:0:0:0:1','2019-04-08 13:47:02'),('6c1c9d1d382b4621a2772df7d1b073eb','张博文','删除课题，未删除','com.dky.modules.sys.controller.WebProjectController.deleteProject()','[\"1\"]',24,'0:0:0:0:0:0:0:1','2019-04-08 11:10:41'),('704d116ec1954ddc9499dc97c3b3519b','张博文','查询全部课题','com.dky.modules.sys.controller.WebProjectController.list()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',19,'0:0:0:0:0:0:0:1','2019-04-07 23:20:57'),('81d13aaec55b4a4289825f306aaea99b','张博文','根据id查找课题','com.dky.modules.sys.controller.WebProjectController.selectById()','\"1\"',18,'0:0:0:0:0:0:0:1','2019-04-08 11:37:31'),('858aa3efccf44a8982e6a851874c5661','张博文','获取角色列表','com.dky.modules.sys.controller.WebRoleController.select()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',18,'0:0:0:0:0:0:0:1','2019-04-07 18:45:45'),('8f76de14afee4dde900e0ac935468a0a','张博文','删除课题，未删除','com.dky.modules.sys.controller.WebProjectController.deleteProject()','[\"1\",\"2\"]',65,'0:0:0:0:0:0:0:1','2019-04-08 10:22:11'),('934f75e356734eeb818f55354117622b','张博文','查询全部课题','com.dky.modules.sys.controller.WebProjectController.list()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',81,'0:0:0:0:0:0:0:1','2019-04-08 09:28:20'),('98a4bcfe2c4b49958df23983b06ddda1','张博文','保存或更新课题','com.dky.modules.sys.controller.WebProjectController.saveOrUpdage()','{\"appendix\":\"111\",\"deletedCode\":0,\"deletedName\":\"未删除\",\"difficulty\":\"简单\",\"id\":3,\"introduce\":\"简介\",\"major\":\"string\",\"name\":\"string\"}',13,'0:0:0:0:0:0:0:1','2019-04-08 14:06:40'),('9e495ea776d048a68ef1ff7d0a2e1198','张博文','获取全部用户列表','com.dky.modules.sys.controller.WebLoginController.check()',NULL,0,'0:0:0:0:0:0:0:1','2019-04-07 12:52:33'),('aa4c924de68b4328ba92114942d5258e','张博文','删除课题，未删除','com.dky.modules.sys.controller.WebProjectController.deleteProject()','[\"1\"]',6,'0:0:0:0:0:0:0:1','2019-04-08 10:22:23'),('b8866ba620c04f0895cf1e4cbdba525e','张博文','获取角色列表','com.dky.modules.sys.controller.WebRoleController.select()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',276,'0:0:0:0:0:0:0:1','2019-04-07 18:07:54'),('c040f853bbbf4965a4b9fbc4770157aa','张博文','删除课题，未删除','com.dky.modules.sys.controller.WebProjectController.deleteProject()','[\"1\"]',14,'0:0:0:0:0:0:0:1','2019-04-08 10:34:44'),('c9e659138a0d405498ce2a9d9f079dce','张博文','用户登录token验证','com.dky.modules.sys.controller.WebLoginController.check()',NULL,2,'0:0:0:0:0:0:0:1','2019-04-07 16:01:44'),('d183b059a0d9438281d69b8a3dac097c','张博文','获取全部用户列表','com.dky.modules.sys.controller.WebLoginController.check()',NULL,0,'0:0:0:0:0:0:0:1','2019-04-07 12:52:21'),('e695caa204644dc59943b51373223730','张博文','获取角色列表','com.dky.modules.sys.controller.WebRoleController.select()','{\"additionalProp1\":{},\"additionalProp3\":{},\"additionalProp2\":{}}',19,'0:0:0:0:0:0:0:1','2019-04-07 18:08:31'),('fbad0de39513417e939c66d75011779b','张博文','根据Id查找角色','com.dky.modules.sys.controller.WebRoleController.selectById()','\"1\"',5,'0:0:0:0:0:0:0:1','2019-04-07 18:46:27'),('fdb086efd5f84ebb8f94bd1c6db043f8','张博文','根据Id查找角色','com.dky.modules.sys.controller.WebRoleController.selectById()','\"1\"',5,'0:0:0:0:0:0:0:1','2019-04-07 18:44:37');
/*!40000 ALTER TABLE `a_base_syslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a_base_user`
--

DROP TABLE IF EXISTS `a_base_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `a_base_user` (
  `id` int(16) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `accounts` varchar(255) DEFAULT NULL COMMENT '账户',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `gender_code` int(1) DEFAULT NULL COMMENT '性别，1：男，0：女',
  `gender_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `mobile` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `department` varchar(255) DEFAULT NULL COMMENT '所属系部',
  `date_create` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted_number` int(1) DEFAULT NULL COMMENT '删除标识符，1：已删除，0：未删除',
  `deleted_name` varchar(255) DEFAULT NULL COMMENT '是否删除',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_base_user`
--

LOCK TABLES `a_base_user` WRITE;
/*!40000 ALTER TABLE `a_base_user` DISABLE KEYS */;
INSERT INTO `a_base_user` VALUES (21,'张博文','zhangbowen','ceshi',1,'男','15010519788','研究生部','2019-04-07 11:01:33',0,'未删除','备注'),(22,'张子松','zhangzisong','ceshi',1,'男','18810598386','研究生部','2019-04-08 20:00:59',0,'未删除','备注');
/*!40000 ALTER TABLE `a_base_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_fun_banji`
--

DROP TABLE IF EXISTS `b_fun_banji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `b_fun_banji` (
  `id` int(11) NOT NULL,
  `banji` varchar(255) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_fun_banji`
--

LOCK TABLES `b_fun_banji` WRITE;
/*!40000 ALTER TABLE `b_fun_banji` DISABLE KEYS */;
INSERT INTO `b_fun_banji` VALUES (1,'1891'),(2,'1892'),(3,'1893');
/*!40000 ALTER TABLE `b_fun_banji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_fun_user_banji`
--

DROP TABLE IF EXISTS `b_fun_user_banji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `b_fun_user_banji` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `banji_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_fun_user_banji`
--

LOCK TABLES `b_fun_user_banji` WRITE;
/*!40000 ALTER TABLE `b_fun_user_banji` DISABLE KEYS */;
INSERT INTO `b_fun_user_banji` VALUES (1,1,2);
/*!40000 ALTER TABLE `b_fun_user_banji` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-08 20:10:09
