insert into author (name) values ('Test author');

insert into author (name) values ('Test author 2');

insert into genre (name) values ('Test genre');

insert into genre (name) values ('Test genre 2');

insert into book (name, author_id, genre_id) values ('Test book', 1, 1);

insert into comment (text, book_id) values ('Test comment', 1);
