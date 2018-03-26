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

 Date: 25/03/2018 22:41:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 190 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, 'b@b.com', 'b', 'computing', 'ACTIVE', 2);
INSERT INTO `student` VALUES (3, 'c@c.com', 'c', 'computing', 'ACTIVE', 3);
INSERT INTO `student` VALUES (4, 'd@d.com', 'd', 'computing', 'ACTIVE', 1);
INSERT INTO `student` VALUES (5, 'e@e.com', 'e', 'computing', 'ACTIVE', 2);
INSERT INTO `student` VALUES (6, 'f@f.com', 'f', 'computing', 'ACTIVE', 3);
INSERT INTO `student` VALUES (7, 'g@g.com', 'g', 'computing', 'ACTIVE', 1);
INSERT INTO `student` VALUES (8, 'h@h.com', 'h', 'computing', 'ACTIVE', 2);
INSERT INTO `student` VALUES (9, 'i@i.com', 'i', 'computing', 'ACTIVE', 3);
INSERT INTO `student` VALUES (10, 'j@j.com', 'j', 'computing', 'ACTIVE', 1);
INSERT INTO `student` VALUES (12, '1.0', '1.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (13, '2.0', '2.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (14, '3.0', '3.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (15, '4.0', '4.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (16, '5.0', '5.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (17, '6.0', '6.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (18, '7.0', '7.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (19, '8.0', '8.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (20, '9.0', '9.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (21, '10.0', '10.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (22, '11.0', '11.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (23, '12.0', '12.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (24, '13.0', '13.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (25, '14.0', '14.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (26, '15.0', '15.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (27, '16.0', '16.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (28, '17.0', '17.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (29, '18.0', '18.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (30, '19.0', '19.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (31, '20.0', '20.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (32, '21.0', '21.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (33, '22.0', '22.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (34, '23.0', '23.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (35, '24.0', '24.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (36, '25.0', '25.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (37, '26.0', '26.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (38, '27.0', '27.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (39, '28.0', '28.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (40, '29.0', '29.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (41, '30.0', '30.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (42, '31.0', '31.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (43, '32.0', '32.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (44, '33.0', '33.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (45, '34.0', '34.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (46, '35.0', '35.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (47, '36.0', '36.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (48, '37.0', '37.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (49, '38.0', '38.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (50, '39.0', '39.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (51, '40.0', '40.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (52, '41.0', '41.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (53, '42.0', '42.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (54, '43.0', '43.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (55, '44.0', '44.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (56, '45.0', '45.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (57, '46.0', '46.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (58, '47.0', '47.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (59, '48.0', '48.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (60, '49.0', '49.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (61, '50.0', '50.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (62, '51.0', '51.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (63, '52.0', '52.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (64, '53.0', '53.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (65, '54.0', '54.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (66, '55.0', '55.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (67, '56.0', '56.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (68, '57.0', '57.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (69, '58.0', '58.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (70, '59.0', '59.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (71, '60.0', '60.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (72, '61.0', '61.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (73, '62.0', '62.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (74, '63.0', '63.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (75, '64.0', '64.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (76, '65.0', '65.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (77, '66.0', '66.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (78, '67.0', '67.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (79, '68.0', '68.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (80, '69.0', '69.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (81, '70.0', '70.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (82, '71.0', '71.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (83, '72.0', '72.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (84, '73.0', '73.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (85, '74.0', '74.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (86, '75.0', '75.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (87, '76.0', '76.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (88, '77.0', '77.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (89, '78.0', '78.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (90, '79.0', '79.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (91, '80.0', '80.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (92, '81.0', '81.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (93, '82.0', '82.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (94, '83.0', '83.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (95, '84.0', '84.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (96, '85.0', '85.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (97, '86.0', '86.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (98, '87.0', '87.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (99, '88.0', '88.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (100, '89.0', '89.0', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (101, '1', '1', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (102, '2', '2', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (103, '3', '3', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (104, '4', '4', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (105, '5', '5', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (106, '6', '6', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (107, '7', '7', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (108, '8', '8', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (109, '9', '9', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (110, '10', '10', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (111, '11', '11', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (112, '12', '12', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (113, '13', '13', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (114, '14', '14', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (115, '15', '15', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (116, '16', '16', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (117, '17', '17', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (118, '18', '18', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (119, '19', '19', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (120, '20', '20', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (121, '21', '21', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (122, '22', '22', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (123, '23', '23', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (124, '24', '24', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (125, '25', '25', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (126, '26', '26', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (127, '27', '27', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (128, '28', '28', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (129, '29', '29', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (130, '30', '30', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (131, '31', '31', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (132, '32', '32', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (133, '33', '33', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (134, '34', '34', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (135, '35', '35', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (136, '36', '36', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (137, '37', '37', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (138, '38', '38', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (139, '39', '39', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (140, '40', '40', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (141, '41', '41', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (142, '42', '42', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (143, '43', '43', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (144, '44', '44', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (145, '45', '45', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (146, '46', '46', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (147, '47', '47', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (148, '48', '48', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (149, '49', '49', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (150, '50', '50', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (151, '51', '51', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (152, '52', '52', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (153, '53', '53', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (154, '54', '54', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (155, '55', '55', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (156, '56', '56', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (157, '57', '57', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (158, '58', '58', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (159, '59', '59', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (160, '60', '60', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (161, '61', '61', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (162, '62', '62', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (163, '63', '63', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (164, '64', '64', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (165, '65', '65', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (166, '66', '66', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (167, '67', '67', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (168, '68', '68', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (169, '69', '69', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (170, '70', '70', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (171, '71', '71', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (172, '72', '72', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (173, '73', '73', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (174, '74', '74', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (175, '75', '75', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (176, '76', '76', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (177, '77', '77', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (178, '78', '78', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (179, '79', '79', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (180, '80', '80', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (181, '81', '81', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (182, '82', '82', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (183, '83', '83', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (184, '84', '84', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (185, '85', '85', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (186, '86', '86', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (187, '87', '87', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (188, '88', '88', NULL, 'ACTIVE', NULL);
INSERT INTO `student` VALUES (189, '89', '89', NULL, 'ACTIVE', NULL);

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
INSERT INTO `student_attendance` VALUES (1, 101, 'Mechanical Engineering', 'H3002U', 2, 3, 20, 25.00, NULL);
INSERT INTO `student_attendance` VALUES (2, 102, 'Elecl Eng and Elecc Eng', 'H5001U', 13, 0, 20, 65.00, NULL);
INSERT INTO `student_attendance` VALUES (3, 103, 'Mechanical Engineering', 'H3002U', 4, 8, 16, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (4, 104, 'Elecl Eng and Elecc Eng', 'H5001U', 16, 0, 21, 76.20, NULL);
INSERT INTO `student_attendance` VALUES (5, 105, 'Computing for Digital Media', 'G5020U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (6, 106, 'Mechanical Engineering', 'H3002U', 11, 0, 18, 61.10, NULL);
INSERT INTO `student_attendance` VALUES (7, 107, 'Elecl Eng and Elecc Eng', 'H5001U', 11, 0, 20, 55.00, NULL);
INSERT INTO `student_attendance` VALUES (8, 108, 'Computer Science', 'G5001U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (9, 109, 'Comp for Bus and Mgmt', 'GH561U', 4, 0, 14, 28.60, NULL);
INSERT INTO `student_attendance` VALUES (10, 110, 'Elecl Eng and Elecc Eng', 'H5001U', 10, 0, 19, 52.60, NULL);
INSERT INTO `student_attendance` VALUES (11, 111, 'Elecl Eng and Elecc Eng', 'H5001U', 10, 0, 19, 52.60, NULL);
INSERT INTO `student_attendance` VALUES (12, 112, 'Mechanical Engineering', 'H3002U', 1, 0, 20, 5.00, NULL);
INSERT INTO `student_attendance` VALUES (13, 113, 'Mechanical Engineering', 'H3002U', 6, 0, 20, 30.00, NULL);
INSERT INTO `student_attendance` VALUES (14, 114, 'Mechanical Engineering', 'H3006U', 9, 0, 20, 45.00, NULL);
INSERT INTO `student_attendance` VALUES (15, 115, 'Computer Science', 'G5001U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (16, 116, 'Computer Science', 'G5001U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (17, 117, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (18, 118, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (19, 119, 'Comp for Bus and Mgmt', 'GH561U', 4, 0, 14, 28.60, NULL);
INSERT INTO `student_attendance` VALUES (20, 120, 'Computer Science (IP)', 'G40F0U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (21, 121, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (22, 122, 'Computing for Digital Media', 'G5020U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (23, 123, 'Comp Sci and AI', 'G5005U', 7, 0, 12, 58.30, NULL);
INSERT INTO `student_attendance` VALUES (24, 124, 'Product Design (IP)', 'H7006U', 7, 0, 16, 43.80, NULL);
INSERT INTO `student_attendance` VALUES (25, 125, 'Computer Science (IP)', 'G40F0U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (26, 126, 'Comp Sci and AI', 'G5005U', 8, 0, 12, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (27, 127, 'Computing for Digital Media', 'G5020U', 8, 0, 14, 57.10, NULL);
INSERT INTO `student_attendance` VALUES (28, 128, 'Computer Engineering', 'H6001U', 0, 0, 15, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (29, 129, 'Mechanical Engineering', 'H3002U', 0, 0, 19, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (30, 130, 'Comp Sci and AI', 'G5005U', 0, 0, 12, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (31, 131, 'Computing for Digital Media', 'G5020U', 3, 0, 14, 21.40, NULL);
INSERT INTO `student_attendance` VALUES (32, 132, 'Comp Sci and AI', 'G5005U', 7, 0, 12, 58.30, NULL);
INSERT INTO `student_attendance` VALUES (33, 133, 'Computer Science (IP)', 'G41F0U', 8, 1, 12, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (34, 134, 'Computer Science', 'G5001U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (35, 135, 'Mechanical Engineering', 'H3006U', 1, 0, 18, 5.60, NULL);
INSERT INTO `student_attendance` VALUES (36, 136, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (37, 137, 'Product Design (IP)', 'H7006U', 1, 0, 15, 6.70, NULL);
INSERT INTO `student_attendance` VALUES (38, 138, 'Product Design (IP)', 'H7006U', 11, 1, 16, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (39, 139, 'Mechanical Engineering', 'H3002U', 15, 0, 20, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (40, 140, 'Comp Sci and AI', 'G5005U', 9, 0, 12, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (41, 141, 'Comp for Bus and Mgmt', 'GH561U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (42, 142, 'Elecl Eng and Elecc Eng (IP)', 'H60F0U', 14, 0, 20, 70.00, NULL);
INSERT INTO `student_attendance` VALUES (43, 143, 'Computer Science (IP)', 'G40F0U', 8, 0, 14, 57.10, NULL);
INSERT INTO `student_attendance` VALUES (44, 144, 'GAME', 'G5027U', 6, 0, 14, 42.90, NULL);
INSERT INTO `student_attendance` VALUES (45, 145, 'Computer Science', 'G5001U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (46, 146, 'Elecl Eng and Elecc Eng', 'H5001U', 13, 0, 19, 68.40, NULL);
INSERT INTO `student_attendance` VALUES (47, 147, 'Computer Science', 'G5001U', 6, 0, 14, 42.90, NULL);
INSERT INTO `student_attendance` VALUES (48, 148, 'Comp Sci and AI (IP)', 'G42F0U', 5, 0, 12, 41.70, NULL);
INSERT INTO `student_attendance` VALUES (49, 149, 'Automotive Engineering', 'H3014U', 16, 0, 20, 80.00, NULL);
INSERT INTO `student_attendance` VALUES (50, 150, 'Computer Science', 'G5001U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (51, 151, 'Mechanical Engineering', 'H3002U', 16, 0, 20, 80.00, NULL);
INSERT INTO `student_attendance` VALUES (52, 152, 'Computer Engineering (IP)', 'H63F0U', 10, 0, 15, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (53, 153, 'Mechanical Engineering', 'H3002U', 5, 0, 20, 25.00, NULL);
INSERT INTO `student_attendance` VALUES (54, 154, 'Computing for Digital Media', 'G5020U', 4, 0, 14, 28.60, NULL);
INSERT INTO `student_attendance` VALUES (55, 155, 'GAME', 'G5027U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (56, 156, 'Comp for Bus and Mgmt', 'GH561U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (57, 157, 'Computer Science', 'G5001U', 6, 0, 14, 42.90, NULL);
INSERT INTO `student_attendance` VALUES (58, 158, 'Elecl Eng and Elecc Eng', 'H5001U', 10, 0, 21, 47.60, NULL);
INSERT INTO `student_attendance` VALUES (59, 159, 'Mechanical Engineering', 'H3002U', 1, 0, 20, 5.00, NULL);
INSERT INTO `student_attendance` VALUES (60, 160, 'Elecl Eng and Elecc Eng', 'H5001U', 16, 0, 20, 80.00, NULL);
INSERT INTO `student_attendance` VALUES (61, 161, 'Mechanical Engineering (IP)', 'H32F0U', 15, 0, 19, 78.90, NULL);
INSERT INTO `student_attendance` VALUES (62, 162, 'Computer Science', 'G5001U', 11, 0, 14, 78.60, NULL);
INSERT INTO `student_attendance` VALUES (63, 163, 'Comp Sci and AI', 'G5005U', 8, 0, 12, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (64, 164, 'Elecl Eng and Elecc Eng', 'H5001U', 16, 0, 20, 80.00, NULL);
INSERT INTO `student_attendance` VALUES (65, 165, 'Comp Sci and AI', 'G5005U', 4, 4, 12, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (66, 166, 'Comp for Dig Med (IP)', 'G45F0U', 10, 0, 14, 71.40, NULL);
INSERT INTO `student_attendance` VALUES (67, 167, 'GAME (IP)', 'G46F0U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (68, 168, 'Mechanical Engineering', 'H3002U', 9, 0, 20, 45.00, NULL);
INSERT INTO `student_attendance` VALUES (69, 169, 'Computer Science', 'G5001U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (70, 170, 'Comp for Dig Med (IP)', 'G45F0U', 3, 0, 14, 21.40, NULL);
INSERT INTO `student_attendance` VALUES (71, 171, 'Mechanical Engineering (IP)', 'H34F0U', 13, 0, 20, 65.00, NULL);
INSERT INTO `student_attendance` VALUES (72, 172, 'Elecl Eng and Elecc Eng (IP)', 'H60F0U', 0, 0, 20, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (73, 173, 'Computing for Digital Media', 'G5020U', 0, 0, 14, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (74, 174, 'Mechanical Engineering', 'H3002U', 8, 0, 19, 42.10, NULL);
INSERT INTO `student_attendance` VALUES (75, 175, 'Mechanical Engineering', 'H3002U', 0, 0, 18, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (76, 176, 'Computing for Digital Media', 'G5020U', 7, 0, 14, 50.00, NULL);
INSERT INTO `student_attendance` VALUES (77, 177, 'Computer Science', 'G5001U', 7, 0, 14, 50.00, NULL);
INSERT INTO `student_attendance` VALUES (78, 178, 'Elecl Eng and Elecc Eng (IP)', 'H60F0U', 7, 0, 20, 35.00, NULL);
INSERT INTO `student_attendance` VALUES (79, 179, 'Mechanical Engineering (IP)', 'H32F0U', 8, 0, 18, 44.40, NULL);
INSERT INTO `student_attendance` VALUES (80, 180, 'Computer Science (IP)', 'G40F0U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (81, 181, 'Product Design (IP)', 'H7006U', 8, 1, 16, 56.30, NULL);
INSERT INTO `student_attendance` VALUES (82, 182, 'Mechanical Engineering', 'H3002U', 1, 0, 18, 5.60, NULL);
INSERT INTO `student_attendance` VALUES (83, 183, 'Computer Science', 'G5001U', 9, 0, 14, 64.30, NULL);
INSERT INTO `student_attendance` VALUES (84, 184, 'GAME', 'G5027U', 2, 0, 14, 14.30, NULL);
INSERT INTO `student_attendance` VALUES (85, 185, 'Elecl Eng and Elecc Eng', 'H5001U', 15, 0, 20, 75.00, NULL);
INSERT INTO `student_attendance` VALUES (86, 186, 'V&E - Informatics', 'YY003U', 6, 0, 10, 60.00, NULL);
INSERT INTO `student_attendance` VALUES (87, 187, 'Comp Sci and AI', 'G5005U', 7, 1, 12, 66.70, NULL);
INSERT INTO `student_attendance` VALUES (88, 188, 'Automotive Engineering', 'H3014U', 0, 0, 19, 0.00, NULL);
INSERT INTO `student_attendance` VALUES (89, 189, 'Computer Science (IP)', 'G40F0U', 3, 0, 14, 21.40, NULL);

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

SET FOREIGN_KEY_CHECKS = 1;
