DROP DATABASE IF EXISTS sbb;
CREATE DATABASE sbb;
USE sbb;

CREATE TABLE Article (
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `subject` VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    create_date DATETIME NOT NULL,
    reply_id INT(11) UNSIGNED
);

INSERT INTO Article SET
create_date = NOW(),
`subject` = '질문 1',
content = '질문내용 1',
reply_id = 1;

INSERT INTO Article SET
create_date = NOW(),
`subject` = '질문 2',
content = '질문내용 2',
reply_id = 2;

INSERT INTO Article SET
create_date = NOW(),
`subject` = '질문 3',
content = '질문내용 3',
reply_id = 3;

CREATE TABLE Reply (
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    create_date DATETIME NOT NULL,
    article_id INT(11) UNSIGNED NOT NULL
);

INSERT INTO Reply SET
create_date = NOW(),
content = '답변내용 1',
article_id = 1;

INSERT INTO Reply SET
create_date = NOW(),
content = '답변내용 2',
article_id = 2;

INSERT INTO Reply SET
create_date = NOW(),
content = '답변내용 3',
article_id = 3;

ALTER TABLE Article ADD view_count INT(11) DEFAULT 0;
SELECT * FROM Article;
SELECT * FROM Reply;