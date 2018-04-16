/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : final_year_project

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 16/04/2018 23:10:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance_threshold_config
-- ----------------------------
DROP TABLE IF EXISTS `attendance_threshold_config`;
CREATE TABLE `attendance_threshold_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_level` double(50, 2) NULL DEFAULT NULL,
  `second_level` double(50, 2) NULL DEFAULT NULL,
  `third_level` double(50, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance_threshold_config
-- ----------------------------
INSERT INTO `attendance_threshold_config` VALUES (1, 70.00, 60.00, 40.00);

-- ----------------------------
-- Table structure for cron
-- ----------------------------
DROP TABLE IF EXISTS `cron`;
CREATE TABLE `cron`  (
  `cron_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cron` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cron_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cron
-- ----------------------------
INSERT INTO `cron` VALUES (1, '0 0/5 * * * ?');
INSERT INTO `cron` VALUES (2, '0/5 * * * * ?');
INSERT INTO `cron` VALUES (3, '0 0 0 1/1 * ? ');

-- ----------------------------
-- Table structure for email_log
-- ----------------------------
DROP TABLE IF EXISTS `email_log`;
CREATE TABLE `email_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `replied_email_id` bigint(20) NULL DEFAULT NULL,
  `is_replied` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `replied_email_id`(`replied_email_id`) USING BTREE,
  CONSTRAINT `email_log_ibfk_1` FOREIGN KEY (`replied_email_id`) REFERENCES `replied_email_log` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for email_template
-- ----------------------------
DROP TABLE IF EXISTS `email_template`;
CREATE TABLE `email_template`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `template_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `template_body` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of email_template
-- ----------------------------
INSERT INTO `email_template` VALUES (1, 'Third Template', 'This is the third level template.', 'third');
INSERT INTO `email_template` VALUES (2, 'Second Template', 'This is the second level templete.', 'second');
INSERT INTO `email_template` VALUES (3, 'First Template', 'This is the first level templete.', 'first');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (11);

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module`  (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES (1, 'add');
INSERT INTO `module` VALUES (2, 'delete');
INSERT INTO `module` VALUES (3, 'query');
INSERT INTO `module` VALUES (4, 'update');

-- ----------------------------
-- Table structure for module_role
-- ----------------------------
DROP TABLE IF EXISTS `module_role`;
CREATE TABLE `module_role`  (
  `rid` int(11) NULL DEFAULT NULL,
  `mid` int(11) NULL DEFAULT NULL,
  INDEX `rid`(`rid`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  CONSTRAINT `mid` FOREIGN KEY (`mid`) REFERENCES `module` (`mid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rid` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of module_role
-- ----------------------------
INSERT INTO `module_role` VALUES (1, 1);
INSERT INTO `module_role` VALUES (1, 2);
INSERT INTO `module_role` VALUES (1, 3);
INSERT INTO `module_role` VALUES (1, 4);
INSERT INTO `module_role` VALUES (2, 2);
INSERT INTO `module_role` VALUES (2, 3);

-- ----------------------------
-- Table structure for replied_email_log
-- ----------------------------
DROP TABLE IF EXISTS `replied_email_log`;
CREATE TABLE `replied_email_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email_subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email_body` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `absence_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replied_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `replied_email_log_ibfk_1` FOREIGN KEY (`id`) REFERENCES `email_log` (`replied_email_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin');
INSERT INTO `role` VALUES (2, 'customer');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `program` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `year_of_program` int(11) NULL DEFAULT NULL,
  `avg_attendance` double(255, 2) NULL DEFAULT NULL,
  `email_log_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `email_log_id`(`email_log_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`email_log_id`) REFERENCES `email_log` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '1.0', '1.0', NULL, 'ACTIVE', NULL, 25.00, NULL);
INSERT INTO `student` VALUES (2, '2.0', '2.0', NULL, 'ACTIVE', NULL, 65.00, NULL);
INSERT INTO `student` VALUES (3, '3.0', '3.0', NULL, 'ACTIVE', NULL, 75.00, NULL);
INSERT INTO `student` VALUES (4, '4.0', '4.0', NULL, 'ACTIVE', NULL, 76.20, NULL);
INSERT INTO `student` VALUES (5, '5.0', '5.0', NULL, 'ACTIVE', NULL, 78.60, NULL);
INSERT INTO `student` VALUES (6, '6.0', '6.0', NULL, 'ACTIVE', NULL, 61.10, NULL);
INSERT INTO `student` VALUES (7, '7.0', '7.0', NULL, 'ACTIVE', NULL, 55.00, NULL);
INSERT INTO `student` VALUES (8, '8.0', '8.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (9, '9.0', '9.0', NULL, 'ACTIVE', NULL, 28.60, NULL);
INSERT INTO `student` VALUES (10, '10.0', '10.0', NULL, 'ACTIVE', NULL, 52.60, NULL);
INSERT INTO `student` VALUES (11, '11.0', '11.0', NULL, 'ACTIVE', NULL, 52.60, NULL);
INSERT INTO `student` VALUES (12, '12.0', '12.0', NULL, 'ACTIVE', NULL, 5.00, NULL);
INSERT INTO `student` VALUES (13, '13.0', '13.0', NULL, 'ACTIVE', NULL, 30.00, NULL);
INSERT INTO `student` VALUES (14, '14.0', '14.0', NULL, 'ACTIVE', NULL, 45.00, NULL);
INSERT INTO `student` VALUES (15, '15.0', '15.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (16, '16.0', '16.0', NULL, 'ACTIVE', NULL, 64.30, NULL);
INSERT INTO `student` VALUES (17, '17.0', '17.0', NULL, 'ACTIVE', NULL, 78.60, NULL);
INSERT INTO `student` VALUES (18, '18.0', '18.0', NULL, 'ACTIVE', NULL, 78.60, NULL);
INSERT INTO `student` VALUES (19, '19.0', '19.0', NULL, 'ACTIVE', NULL, 28.60, NULL);
INSERT INTO `student` VALUES (20, '20.0', '20.0', NULL, 'ACTIVE', NULL, 78.60, NULL);
INSERT INTO `student` VALUES (21, '21.0', '21.0', NULL, 'ACTIVE', NULL, 78.60, NULL);
INSERT INTO `student` VALUES (22, '22.0', '22.0', NULL, 'ACTIVE', NULL, 71.40, NULL);
INSERT INTO `student` VALUES (23, '23.0', '23.0', NULL, 'ACTIVE', NULL, 58.30, NULL);
INSERT INTO `student` VALUES (24, '24.0', '24.0', NULL, 'ACTIVE', NULL, 43.80, NULL);
INSERT INTO `student` VALUES (25, '25.0', '25.0', NULL, 'ACTIVE', NULL, 71.40, NULL);
INSERT INTO `student` VALUES (26, '26.0', '26.0', NULL, 'ACTIVE', NULL, 66.70, NULL);
INSERT INTO `student` VALUES (27, '27.0', '27.0', NULL, 'ACTIVE', NULL, 57.10, NULL);
INSERT INTO `student` VALUES (28, '28.0', '28.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (29, '29.0', '29.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (30, '30.0', '30.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (31, '31.0', '31.0', NULL, 'ACTIVE', NULL, 21.40, NULL);
INSERT INTO `student` VALUES (32, '32.0', '32.0', NULL, 'ACTIVE', NULL, 58.30, NULL);
INSERT INTO `student` VALUES (33, '33.0', '33.0', NULL, 'ACTIVE', NULL, 75.00, NULL);
INSERT INTO `student` VALUES (34, '34.0', '34.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (35, '35.0', '35.0', NULL, 'ACTIVE', NULL, 5.60, NULL);
INSERT INTO `student` VALUES (36, '36.0', '36.0', NULL, 'ACTIVE', NULL, 78.60, NULL);
INSERT INTO `student` VALUES (37, '37.0', '37.0', NULL, 'ACTIVE', NULL, 6.70, NULL);
INSERT INTO `student` VALUES (38, '38.0', '38.0', NULL, 'ACTIVE', NULL, 75.00, NULL);
INSERT INTO `student` VALUES (39, '39.0', '39.0', NULL, 'ACTIVE', NULL, 75.00, NULL);
INSERT INTO `student` VALUES (40, '40.0', '40.0', NULL, 'ACTIVE', NULL, 75.00, NULL);
INSERT INTO `student` VALUES (41, '41.0', '41.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (42, '42.0', '42.0', NULL, 'ACTIVE', NULL, 70.00, NULL);
INSERT INTO `student` VALUES (43, '43.0', '43.0', NULL, 'ACTIVE', NULL, 57.10, NULL);
INSERT INTO `student` VALUES (44, '44.0', '44.0', NULL, 'ACTIVE', NULL, 42.90, NULL);
INSERT INTO `student` VALUES (45, '45.0', '45.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (46, '46.0', '46.0', NULL, 'ACTIVE', NULL, 68.40, NULL);
INSERT INTO `student` VALUES (47, '47.0', '47.0', NULL, 'ACTIVE', NULL, 42.90, NULL);
INSERT INTO `student` VALUES (48, '48.0', '48.0', NULL, 'ACTIVE', NULL, 41.70, NULL);
INSERT INTO `student` VALUES (49, '49.0', '49.0', NULL, 'ACTIVE', NULL, 80.00, NULL);
INSERT INTO `student` VALUES (50, '50.0', '50.0', NULL, 'ACTIVE', NULL, 71.40, NULL);
INSERT INTO `student` VALUES (51, '51.0', '51.0', NULL, 'ACTIVE', NULL, 80.00, NULL);
INSERT INTO `student` VALUES (52, '52.0', '52.0', NULL, 'ACTIVE', NULL, 66.70, NULL);
INSERT INTO `student` VALUES (53, '53.0', '53.0', NULL, 'ACTIVE', NULL, 25.00, NULL);
INSERT INTO `student` VALUES (54, '54.0', '54.0', NULL, 'ACTIVE', NULL, 28.60, NULL);
INSERT INTO `student` VALUES (55, '55.0', '55.0', NULL, 'ACTIVE', NULL, 78.60, NULL);
INSERT INTO `student` VALUES (56, '56.0', '56.0', NULL, 'ACTIVE', NULL, 71.40, NULL);
INSERT INTO `student` VALUES (57, '57.0', '57.0', NULL, 'ACTIVE', NULL, 42.90, NULL);
INSERT INTO `student` VALUES (58, '58.0', '58.0', NULL, 'ACTIVE', NULL, 47.60, NULL);
INSERT INTO `student` VALUES (59, '59.0', '59.0', NULL, 'ACTIVE', NULL, 5.00, NULL);
INSERT INTO `student` VALUES (60, '60.0', '60.0', NULL, 'ACTIVE', NULL, 80.00, NULL);
INSERT INTO `student` VALUES (61, '61.0', '61.0', NULL, 'ACTIVE', NULL, 78.90, NULL);
INSERT INTO `student` VALUES (62, '62.0', '62.0', NULL, 'ACTIVE', NULL, 78.60, NULL);
INSERT INTO `student` VALUES (63, '63.0', '63.0', NULL, 'ACTIVE', NULL, 66.70, NULL);
INSERT INTO `student` VALUES (64, '64.0', '64.0', NULL, 'ACTIVE', NULL, 80.00, NULL);
INSERT INTO `student` VALUES (65, '65.0', '65.0', NULL, 'ACTIVE', NULL, 66.70, NULL);
INSERT INTO `student` VALUES (66, '66.0', '66.0', NULL, 'ACTIVE', NULL, 71.40, NULL);
INSERT INTO `student` VALUES (67, '67.0', '67.0', NULL, 'ACTIVE', NULL, 64.30, NULL);
INSERT INTO `student` VALUES (68, '68.0', '68.0', NULL, 'ACTIVE', NULL, 45.00, NULL);
INSERT INTO `student` VALUES (69, '69.0', '69.0', NULL, 'ACTIVE', NULL, 64.30, NULL);
INSERT INTO `student` VALUES (70, '70.0', '70.0', NULL, 'ACTIVE', NULL, 21.40, NULL);
INSERT INTO `student` VALUES (71, '71.0', '71.0', NULL, 'ACTIVE', NULL, 65.00, NULL);
INSERT INTO `student` VALUES (72, '72.0', '72.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (73, '73.0', '73.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (74, '74.0', '74.0', NULL, 'ACTIVE', NULL, 42.10, NULL);
INSERT INTO `student` VALUES (75, '75.0', '75.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (76, '76.0', '76.0', NULL, 'ACTIVE', NULL, 50.00, NULL);
INSERT INTO `student` VALUES (77, '77.0', '77.0', NULL, 'ACTIVE', NULL, 50.00, NULL);
INSERT INTO `student` VALUES (78, '78.0', '78.0', NULL, 'ACTIVE', NULL, 35.00, NULL);
INSERT INTO `student` VALUES (79, '79.0', '79.0', NULL, 'ACTIVE', NULL, 44.40, NULL);
INSERT INTO `student` VALUES (80, '80.0', '80.0', NULL, 'ACTIVE', NULL, 64.30, NULL);
INSERT INTO `student` VALUES (81, '81.0', '81.0', NULL, 'ACTIVE', NULL, 56.30, NULL);
INSERT INTO `student` VALUES (82, '82.0', '82.0', NULL, 'ACTIVE', NULL, 5.60, NULL);
INSERT INTO `student` VALUES (83, '83.0', '83.0', NULL, 'ACTIVE', NULL, 64.30, NULL);
INSERT INTO `student` VALUES (84, '84.0', '84.0', NULL, 'ACTIVE', NULL, 14.30, NULL);
INSERT INTO `student` VALUES (85, '85.0', '85.0', NULL, 'ACTIVE', NULL, 75.00, NULL);
INSERT INTO `student` VALUES (86, '86.0', '86.0', NULL, 'ACTIVE', NULL, 60.00, NULL);
INSERT INTO `student` VALUES (87, '87.0', '87.0', NULL, 'ACTIVE', NULL, 66.70, NULL);
INSERT INTO `student` VALUES (88, '88.0', '88.0', NULL, 'ACTIVE', NULL, 0.00, NULL);
INSERT INTO `student` VALUES (89, '89.0', '89.0', NULL, 'ACTIVE', NULL, 21.40, NULL);

-- ----------------------------
-- Table structure for student_attendance
-- ----------------------------
DROP TABLE IF EXISTS `student_attendance`;
CREATE TABLE `student_attendance`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `course_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attended` bigint(255) NULL DEFAULT NULL,
  `explained_absence` bigint(255) NULL DEFAULT NULL,
  `sessions` bigint(255) NULL DEFAULT NULL,
  `attendance` double(65, 2) NULL DEFAULT NULL,
  `term` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_attendance
-- ----------------------------
INSERT INTO `student_attendance` VALUES (1, 1, 'Mechanical Engineering', 'H3002U', 2, 3, 20, 25.00, NULL);
INSERT INTO `student_attendance` VALUES (2, 2, 'Elecl Eng and Elecc Eng', 'H5001U', 13, 0, 20, 65.00, NULL);
INSERT INTO `student_attendance` VALUES (3, 3, 'Mechanical Engineering', 'H3002U', 4, 8, 16, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (4, 4, 'Elecl Eng and Elecc Eng', 'H5001U', 16, 0, 21, 76.20, NULL);
INSERT INTO `student_attendance` VALUES (5, 5, 'Computing for Digital Media', 'G5020U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (6, 6, 'Mechanical Engineering', 'H3002U', 11, 0, 18, 61.10, NULL);
INSERT INTO `student_attendance` VALUES (7, 7, 'Elecl Eng and Elecc Eng', 'H5001U', 11, 0, 20, 55.00, NULL);
INSERT INTO `student_attendance` VALUES (8, 8, 'Computer Science', 'G5001U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (9, 9, 'Comp for Bus and Mgmt', 'GH561U', 4, 0, 14, 28.60, NULL);
INSERT INTO `student_attendance` VALUES (10, 10, 'Elecl Eng and Elecc Eng', 'H5001U', 10, 0, 19, 52.60, NULL);
INSERT INTO `student_attendance` VALUES (11, 11, 'Elecl Eng and Elecc Eng', 'H5001U', 10, 0, 19, 52.60, NULL);
INSERT INTO `student_attendance` VALUES (12, 12, 'Mechanical Engineering', 'H3002U', 1, 0, 20, 5.00, NULL);
INSERT INTO `student_attendance` VALUES (13, 13, 'Mechanical Engineering', 'H3002U', 6, 0, 20, 30.00, NULL);
INSERT INTO `student_attendance` VALUES (14, 14, 'Mechanical Engineering', 'H3006U', 9, 0, 20, 45.00, NULL);
INSERT INTO `student_attendance` VALUES (15, 15, 'Computer Science', 'G5001U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (16, 16, 'Computer Science', 'G5001U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (17, 17, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (18, 18, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (19, 19, 'Comp for Bus and Mgmt', 'GH561U', 4, 0, 14, 28.60, NULL);
INSERT INTO `student_attendance` VALUES (20, 20, 'Computer Science (IP)', 'G40F0U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (21, 21, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (22, 22, 'Computing for Digital Media', 'G5020U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (23, 23, 'Comp Sci and AI', 'G5005U', 7, 0, 12, 58.30, NULL);
INSERT INTO `student_attendance` VALUES (24, 24, 'Product Design (IP)', 'H7006U', 7, 0, 16, 43.80, NULL);
INSERT INTO `student_attendance` VALUES (25, 25, 'Computer Science (IP)', 'G40F0U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (26, 26, 'Comp Sci and AI', 'G5005U', 8, 0, 12, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (27, 27, 'Computing for Digital Media', 'G5020U', 8, 0, 14, 57.10, NULL);
INSERT INTO `student_attendance` VALUES (28, 28, 'Computer Engineering', 'H6001U', 0, 0, 15, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (29, 29, 'Mechanical Engineering', 'H3002U', 0, 0, 19, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (30, 30, 'Comp Sci and AI', 'G5005U', 0, 0, 12, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (31, 31, 'Computing for Digital Media', 'G5020U', 3, 0, 14, 21.40, NULL);
INSERT INTO `student_attendance` VALUES (32, 32, 'Comp Sci and AI', 'G5005U', 7, 0, 12, 58.30, NULL);
INSERT INTO `student_attendance` VALUES (33, 33, 'Computer Science (IP)', 'G41F0U', 8, 1, 12, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (34, 34, 'Computer Science', 'G5001U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (35, 35, 'Mechanical Engineering', 'H3006U', 1, 0, 18, 5.60, NULL);
INSERT INTO `student_attendance` VALUES (36, 36, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (37, 37, 'Product Design (IP)', 'H7006U', 1, 0, 15, 6.70, NULL);
INSERT INTO `student_attendance` VALUES (38, 38, 'Product Design (IP)', 'H7006U', 11, 1, 16, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (39, 39, 'Mechanical Engineering', 'H3002U', 15, 0, 20, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (40, 40, 'Comp Sci and AI', 'G5005U', 9, 0, 12, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (41, 41, 'Comp for Bus and Mgmt', 'GH561U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (42, 42, 'Elecl Eng and Elecc Eng (IP)', 'H60F0U', 14, 0, 20, 70.00, NULL);
INSERT INTO `student_attendance` VALUES (43, 43, 'Computer Science (IP)', 'G40F0U', 8, 0, 14, 57.10, NULL);
INSERT INTO `student_attendance` VALUES (44, 44, 'GAME', 'G5027U', 6, 0, 14, 42.90, NULL);
INSERT INTO `student_attendance` VALUES (45, 45, 'Computer Science', 'G5001U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (46, 46, 'Elecl Eng and Elecc Eng', 'H5001U', 13, 0, 19, 68.40, NULL);
INSERT INTO `student_attendance` VALUES (47, 47, 'Computer Science', 'G5001U', 6, 0, 14, 42.90, NULL);
INSERT INTO `student_attendance` VALUES (48, 48, 'Comp Sci and AI (IP)', 'G42F0U', 5, 0, 12, 41.70, NULL);
INSERT INTO `student_attendance` VALUES (49, 49, 'Automotive Engineering', 'H3014U', 16, 0, 20, 80.00, NULL);
INSERT INTO `student_attendance` VALUES (50, 50, 'Computer Science', 'G5001U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (51, 51, 'Mechanical Engineering', 'H3002U', 16, 0, 20, 80.00, NULL);
INSERT INTO `student_attendance` VALUES (52, 52, 'Computer Engineering (IP)', 'H63F0U', 10, 0, 15, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (53, 53, 'Mechanical Engineering', 'H3002U', 5, 0, 20, 25.00, NULL);
INSERT INTO `student_attendance` VALUES (54, 54, 'Computing for Digital Media', 'G5020U', 4, 0, 14, 28.60, NULL);
INSERT INTO `student_attendance` VALUES (55, 55, 'GAME', 'G5027U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (56, 56, 'Comp for Bus and Mgmt', 'GH561U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (57, 57, 'Computer Science', 'G5001U', 6, 0, 14, 42.90, NULL);
INSERT INTO `student_attendance` VALUES (58, 58, 'Elecl Eng and Elecc Eng', 'H5001U', 10, 0, 21, 47.60, NULL);
INSERT INTO `student_attendance` VALUES (59, 59, 'Mechanical Engineering', 'H3002U', 1, 0, 20, 5.00, NULL);
INSERT INTO `student_attendance` VALUES (60, 60, 'Elecl Eng and Elecc Eng', 'H5001U', 16, 0, 20, 80.00, NULL);
INSERT INTO `student_attendance` VALUES (61, 61, 'Mechanical Engineering (IP)', 'H32F0U', 15, 0, 19, 78.90, NULL);
INSERT INTO `student_attendance` VALUES (62, 62, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (63, 63, 'Comp Sci and AI', 'G5005U', 8, 0, 12, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (64, 64, 'Elecl Eng and Elecc Eng', 'H5001U', 16, 0, 20, 80.00, NULL);
INSERT INTO `student_attendance` VALUES (65, 65, 'Comp Sci and AI', 'G5005U', 4, 4, 12, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (66, 66, 'Comp for Dig Med (IP)', 'G45F0U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (67, 67, 'GAME (IP)', 'G46F0U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (68, 68, 'Mechanical Engineering', 'H3002U', 9, 0, 20, 45.00, NULL);
INSERT INTO `student_attendance` VALUES (69, 69, 'Computer Science', 'G5001U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (70, 70, 'Comp for Dig Med (IP)', 'G45F0U', 3, 0, 14, 21.40, NULL);
INSERT INTO `student_attendance` VALUES (71, 71, 'Mechanical Engineering (IP)', 'H34F0U', 13, 0, 20, 65.00, NULL);
INSERT INTO `student_attendance` VALUES (72, 72, 'Elecl Eng and Elecc Eng (IP)', 'H60F0U', 0, 0, 20, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (73, 73, 'Computing for Digital Media', 'G5020U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (74, 74, 'Mechanical Engineering', 'H3002U', 8, 0, 19, 42.10, NULL);
INSERT INTO `student_attendance` VALUES (75, 75, 'Mechanical Engineering', 'H3002U', 0, 0, 18, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (76, 76, 'Computing for Digital Media', 'G5020U', 7, 0, 14, 50.00, NULL);
INSERT INTO `student_attendance` VALUES (77, 77, 'Computer Science', 'G5001U', 7, 0, 14, 50.00, NULL);
INSERT INTO `student_attendance` VALUES (78, 78, 'Elecl Eng and Elecc Eng (IP)', 'H60F0U', 7, 0, 20, 35.00, NULL);
INSERT INTO `student_attendance` VALUES (79, 79, 'Mechanical Engineering (IP)', 'H32F0U', 8, 0, 18, 44.40, NULL);
INSERT INTO `student_attendance` VALUES (80, 80, 'Computer Science (IP)', 'G40F0U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (81, 81, 'Product Design (IP)', 'H7006U', 8, 1, 16, 56.30, NULL);
INSERT INTO `student_attendance` VALUES (82, 82, 'Mechanical Engineering', 'H3002U', 1, 0, 18, 5.60, NULL);
INSERT INTO `student_attendance` VALUES (83, 83, 'Computer Science', 'G5001U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (84, 84, 'GAME', 'G5027U', 2, 0, 14, 14.30, NULL);
INSERT INTO `student_attendance` VALUES (85, 85, 'Elecl Eng and Elecc Eng', 'H5001U', 15, 0, 20, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (86, 86, 'V&E - Informatics', 'YY003U', 6, 0, 10, 60.00, NULL);
INSERT INTO `student_attendance` VALUES (87, 87, 'Comp Sci and AI', 'G5005U', 7, 1, 12, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (88, 88, 'Automotive Engineering', 'H3014U', 0, 0, 19, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (89, 89, 'Computer Science (IP)', 'G40F0U', 3, 0, 14, 21.40, NULL);

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inactive_date` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES (1, 'admin', 'admin', NULL);
INSERT INTO `user_login` VALUES (2, 'admin1', 'admin1', NULL);
INSERT INTO `user_login` VALUES (3, 'admin123123', '123123', NULL);
INSERT INTO `user_login` VALUES (4, 'shengaofeng123', '123456', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  INDEX `u_fk`(`id`) USING BTREE,
  INDEX `r_fk`(`rid`) USING BTREE,
  CONSTRAINT `r_fk` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `u_fk` FOREIGN KEY (`id`) REFERENCES `user_login` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
