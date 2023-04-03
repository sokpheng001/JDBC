/*
 Navicat Premium Data Transfer

 Source Server         : postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 120014
 Source Host           : localhost:5432
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120014
 File Encoding         : 65001

 Date: 03/04/2023 23:30:04
*/


-- ----------------------------
-- Table structure for istad_teacher
-- ----------------------------
DROP TABLE IF EXISTS "public"."istad_teacher";
CREATE TABLE "public"."istad_teacher" (
  "teacher_name" char(20) COLLATE "pg_catalog"."default",
  "teacher_age" int4,
  "teacher_id" int4 NOT NULL
)
;

-- ----------------------------
-- Records of istad_teacher
-- ----------------------------
INSERT INTO "public"."istad_teacher" VALUES ('Chan Chaya          ', 26, 1001);
INSERT INTO "public"."istad_teacher" VALUES ('Mom Reaksmey        ', 27, 1002);
INSERT INTO "public"."istad_teacher" VALUES ('Kit Tara            ', 24, 1003);
INSERT INTO "public"."istad_teacher" VALUES ('Kay keo             ', 25, 1004);
INSERT INTO "public"."istad_teacher" VALUES ('Sang Sokea          ', 23, 1005);

-- ----------------------------
-- Primary Key structure for table istad_teacher
-- ----------------------------
ALTER TABLE "public"."istad_teacher" ADD CONSTRAINT "istad_teacher_pkey" PRIMARY KEY ("teacher_id");
