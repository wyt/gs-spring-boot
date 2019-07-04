SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `bonus`;
DROP TABLE IF EXISTS `dept`;
DROP TABLE IF EXISTS `emp`;
DROP TABLE IF EXISTS `salgrade`;


-- ----------------------------
-- Table structure for bonus
-- ----------------------------
CREATE TABLE `bonus` (
  `ename` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `job` varchar(9) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ----------------------------
-- Table structure for dept
-- ----------------------------
CREATE TABLE `dept` (
  `deptno` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dname` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `loc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ----------------------------
-- Table structure for emp
-- ----------------------------
CREATE TABLE `emp` (
  `empno` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ename` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `job` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mgr` int(10) unsigned DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `deptno` (`deptno`) USING BTREE,
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=7935 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ----------------------------
-- Table structure for salgrade
-- ----------------------------
CREATE TABLE `salgrade` (
  `grade` int(10) unsigned DEFAULT NULL,
  `losal` int(10) unsigned DEFAULT NULL,
  `hisal` int(10) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
