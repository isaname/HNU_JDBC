CREATE TABLE department09060424(dno CHAR(2) not null COMMENT '学院编号',
    name VARCHAR (20) not null COMMENT '学院名称' ,
    dean char(7) COMMENT '院长(外键:引用教师表的主键)',
    addr VARCHAR (40) COMMENT '院系办公地址',
    phone VARCHAR (12) COMMENT '联系电话',
    PRIMARY KEY (dno)
) ENGINE = INNODB DEFAULT charset=utf8;
CREATE TABLE course09060424(
    con char(10) not null COMMENT '课程编号',
    name VARCHAR(20) not null COMMENT '课程名称',
    spno char(2) COMMENT '专业代码(外键)',
    ctno char(1) COMMENT '课程类型编号(外键)',
    experiment Smallint COMMENT '实验时数',
    PRIMARY key(con)
)ENGINE=INNODB DEFAULT charset=utf8;

CREATE TABLE teacher09060424
(tno CHAR(7) not null COMMENT '教师工号',
    name VARCHAR (8) not null COMMENT '教师姓名',
    sex char(2) COMMENT '教师性别',
    birthday date COMMENT '教师出生日期',
    rank VARCHAR(10) not null COMMENT '教师职称',
    salary char(10) not null COMMENT '月工资',
    home VARCHAR(40) COMMENT '教师家庭住址',
    zipcode char(6) COMMENT '邮政编码',
    tel VARCHAR(12) COMMENT '联系电话',
    email VARCHAR(32) COMMENT '电子邮件',
    dno char(2) COMMENT '教师所在学院编号' 
    PRIMARY KEY (tno)
) ENGINE = INNODB DEFAULT charset=utf8;

CREATE TABLE course09060424(
    con char(10) not null COMMENT '课程编号',
    name VARCHAR(20) not null COMMENT '课程名称',
    spno char(2) COMMENT '专业代码(外键)',
    ctno char(1) COMMENT '课程类型编号(外键)',
    experiment Smallint COMMENT '实验时数',
    PRIMARY key(con)
)ENGINE=INNODB DEFAULT charset=utf8;

CREATE TABLE student09060424(
    sno char(11) not null COMMENT '学生学号',
    sname VARCHAR(8) not null COMMENT '学生姓名',
    sex char(2) COMMENT '学生性别',
    nation VARCHAR(20) COMMENT '民族',
    birthday date COMMENT '学生出生日期',
    spno char(4) COMMENT '专业代码(外键)'
    classno char(7) COMMENT '行政班级号',
    entime char(4) COMMENT '学生入学年纪',
    home VARCHAR(40) COMMENT '学生家庭住址',
    tel VARCHAR(40) COMMENT '学生联系电话',
    dno char(2) COMMENT '学生所在院系编号',
    PRIMARY key(sno) 
)ENGINE=INNODB DEFAULT charset=utf8;

CREATE TABLE teach09060424(
    tno char(7) not null COMMENT '教师编号(外键)',
    cno char(10) not null COMMENT '课程编号(外键)',
    year_semester char(6) not null COMMENT '学年学期',
    classno char(1) not null COMMENT '上课的班级号',
    PRIMARY key(tno,cno,year_semester,classno)
)ENGINE=INNODB DEFAULT charset=utf8;

CREATE TABLE enroll09060424(
    sno char(10) not null COMMENT '学生学号',
    cno char(10) not null COMMENT '课程编号',
    year_semester char(6) not null COMMENT '学年学期',
    tno char(8) COMMENT '教师编号(外键)',
    classno char(1) COMMENT '上课的班级号',
    score float COMMENT '学生成绩',
    PRIMARY key (sno,cno,year_semester)
)ENGINE=INNODB DEFAULT charset=utf8;

CREATE TABLE speciality09060424(
    spno char(2) not null COMMENT '专业代码',
    dno char(2) not null COMMENT '所属院系编号',
    name VARCHAR(20) not null COMMENT '专业名称'
    PRIMARY key (spno)
)ENGINE=INNODB DEFAULT charset=utf8;


CREATE TABLE coursetype09060424(
    ctno char(1) not null COMMENT '类型编号',
    name VARCHAR(16) not null COMMENT '类型名称'
    PRIMARY key (ctno)
)ENGINE=INNODB DEFAULT charset=utf8;
