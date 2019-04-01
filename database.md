<font color="">
# 概览
数据库包含4个表，分别为学生表，老师表，社团表，学院表以及专业表。
## 管理员表administrator
- 管理员号x4 administrator_id charx4
- 管理员姓名 administrator_name varchar(16)
- 密码 administrator_password
## 学生表student
学生表有两个字段，学号和姓名。主键为学号。
- 学号pk student_id char(10)
	- 入学年份x2
	- 学院专业x4
	- 班级x2
	- 学号x2
- 学院  fk  学院表.学院号 student_department_id char(2)
- 专业  fk  专业表.专业代码 student_profession_id char(4)
- 姓名	student_name varchar(16)
- 昵称	student_pickname varchar(16)
- 密码	student_password varchar(16)
## 老师表	teacher
老师表有两个字段，一个是职工号，一个是姓名。
- 职工号pk teacher_id char(10)
  - 入编年份x2
  - 学位x1
  - 学院专业
  - 职工号x3
- 姓名 teacher_name varchar(16) nn
- 昵称 teacher_pickname varchar(16) null
- 密码 teacher_password varchar(16) nn
- 所在学院 fk 学院表.id teacher_department_id char(2)
## 社团表 club
- 社团id pk club_id char(6)
  - 注册年份x2
  - 社团类型x2
  - 挂靠学院x2
- 社团名称 club_name varchar(16) nn uq
- 注册日期 club_registered_time date nn
- 审批人  fk  管理员表.职工号  club_reviewer_administrator_id char(4) 
- 社长  fk  学生表.学号	club_student_id	char(10)
- 挂靠学院  fk  学院表.学院号  club_department_id char(2)
- 指导老师  fk  老师表.职工号 club_teacher_id char(10)
- logo（存储路径） club_logo text
- 社团标语 club_slogn char(32)
- 社团简介 club_introduction text
- 社团类型 club_club_type_id   fk  社团类型.类型id tinyint
## 学院表 department
- 学院id x2 pk department_id char(2) 
- 学院全称 department_name varchar(16) uq
- 学院logo（路径） department_logo text 
## 专业表profession
- 专业id x4 pk	profession_id char(6) 
- 专业名称 profession_name varchar(16) 
- 所在学院  fk  学院表.学院号码 profession_department_id char(2)
## 活动表 activities
- 活动id pk activities_id char(12) 
  - 活动时间x12
- 负责社团  fk  社团表.社团号 activities_club_id char(6)
- 状态代码（结束，进行，审批中） activities_status TINYINT
## 评价表 comment
- 评价id comment_id char(11) 
	- 评价时间x8
	- 评价号码x3
- 所属活动  fk  活动表.活动编码 comment_activities_id char(12) 
- 评价人  fk   comment_user_id char(10)
	- 学生表.学号 
	- 教师表.职工号
- 楼层 comment_floor unsigned int 
- 内容 comment_content varchar(256)
## 回复表 reply
- 回复id pk reply_id char(12) 
	- 回复时间x12
- 所属评价  fk  评价表.评价id reply_comment_id char(11)
- 回复人  fk   reply_user_id char(10)
	- 学生表.学号
	- 教师表.职工号
- 被回复人  fk   reply_reciver_user_id char(10)
	- 学生表.学号
	- 教师表.职工号
- 内容 reply_content varchar(256)
## 社团类型club_type
- 类型 club_type_id char(2)
- 名称 club_type_name varchar(16) uq
- 描述 club_type_introduction text