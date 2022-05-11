drop table if exists author;
create table author(id bigint auto_increment primary key, name varchar(255));

drop table if exists genre;
create table genre(id bigint auto_increment primary key, name varchar(255));

drop table if exists book;
create table book(id bigint auto_increment primary key, name varchar(255), author_id bigint references author(id) on delete cascade, genre_id bigint references genre(id) on delete cascade);

drop table if exists comment;
create table comment(id bigint auto_increment primary key, text varchar(255), book_id bigint references book(id) on delete cascade);
