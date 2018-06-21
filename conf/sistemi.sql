# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table users (
  id                            bigint auto_increment not null,
  email                         varchar(255),
  username                      varchar(255),
  password                      varchar(255),
  role                          integer,
  constraint ck_users_role check ( role in (2,1)),
  constraint uq_users_email unique (email),
  constraint uq_users_username unique (username),
  constraint pk_users primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
