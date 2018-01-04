Create database sample;
Use sample;

drop table if exists course_category;

/*==============================================================*/
/* Table: course_category                                       */
/*==============================================================*/
create table course_category (
   id   int(11) not null auto_increment comment '主键',
   category_name varchar(50) not null comment '课程分类名称',
   status tinyint(1) not null default 0 comment '状态 1:有效0无效-1删除',
   create_time  datetime comment '创建时间',
   parent_id int(11) default 0 comment '父ID ',
  sort  int(11) default 0 comment '排序字段', primary key (id)
);
alter table course_category comment '课程分类表';

drop table if exists course;
/*=================*/
/* Table: course *//*======================================*/
create table course(   	 	
	id     int(10) not null auto_increment,  	 	
	course_name  varchar(300) not null comment '课程名称',    	
	status   int(10) not null default 0 comment '0:编辑 1上架 2:下架   3:删除',  	 	
	category_id      int(11) default 0 comment '课程专业ID ',  	 	
	description      varchar(1000) comment '课程描述 ',	 	
	create_time       datetime comment '添加时间 ',  		
	update_time     datetime comment '最后更新时间 ',    		
	primary key (id)
);
alter table course comment '课程表';
