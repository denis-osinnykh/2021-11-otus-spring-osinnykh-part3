insert into author (name) values ('Same author');

insert into author (name) values ('Same author2');

insert into genre (name) values ('Same genre');

insert into genre (name) values ('Same genre2');

insert into book (name, author_id, genre_id) values ('Same book1', 1, 1);
insert into book (name, author_id, genre_id) values ('Same book2', 2, 2);
insert into book (name, author_id, genre_id) values ('Same book3', 1, 2);

insert into comment (text, book_id) values ('Same comment', 1);
insert into comment (text, book_id) values ('Same comment2', 1);