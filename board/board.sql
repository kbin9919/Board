create table users (
id int not null,
username varchar(20) UNIQUE,
user_id varchar(10) not null,
user_pwd varchar(20) not null,
created_date datetime default current_timestamp,
deleted char(1) default 'N',
deleted_date datetime
);

alter table users add constraint pk_user_id primary key (id);
alter table users add constraint uk_user_id unique (username);

create table board (
id int not null,
title varchar(100) not null,
content varchar(2000) not null,
created_date datetime default current_timestamp,
updated_date datetime,
deleted char(1) default 'N',
deleted_date date
);

alter table board add constraint pk_board_id primary key (id);