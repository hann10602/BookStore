CREATE TABLE book (
id BIGINT NOT NULL primary key auto_increment,
price BIGINT NULL,
title VARCHAR(255),
thumbnail VARCHAR(255) NULL,
description VARCHAR(255) NULL,
quantity BIGINT NULL,
category_id BIGINT NOT NULL,
created_by VARCHAR(255) NULL,
created_date TIMESTAMP NULL,
modified_by VARCHAR(255) NULL,
modified_date TIMESTAMP NULL
);

CREATE TABLE category (
id BIGINT NOT NULL primary key auto_increment,
code VARCHAR(255) NULL,
name VARCHAR(255) NULL,
created_by VARCHAR(255) NULL,
created_date TIMESTAMP NULL,
modified_by VARCHAR(255) NULL,
modified_date TIMESTAMP NULL
);

CREATE TABLE role (
id BIGINT NOT NULL primary key auto_increment,
code VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
created_by VARCHAR(255) NULL,
created_date TIMESTAMP NULL,
modified_by VARCHAR(255) NULL,
modified_date TIMESTAMP NULL
);

CREATE TABLE user (
id BIGINT NOT NULL primary key auto_increment,
username VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
fullname VARCHAR(255) NULL,
status INT NOT NULL,
role_id BIGINT NOT NULL,
created_by VARCHAR(255) NULL,
created_date TIMESTAMP NULL,
modified_by VARCHAR(255) NULL,
modified_date TIMESTAMP NULL
);

CREATE TABLE cart (
id BIGINT NOT NULL PRIMARY KEY auto_increment,
quantity INT NOT NULL,
user_id BIGINT NOT NULL,
book_id BIGINT NOT NULL,
created_by VARCHAR(255) NULL,
created_date TIMESTAMP NULL,
modified_by VARCHAR(255) NULL,
modified_date TIMESTAMP NULL
);

CREATE TABLE comment (
id BIGINT PRIMARY KEY auto_increment,
content INT NOT NULL,
user_id BIGINT NOT NULL,
book_id BIGINT NOT NULL,
created_by VARCHAR(255) NULL,
created_date TIMESTAMP NULL,
modified_by VARCHAR(255) NULL,
modified_date TIMESTAMP NULL
);

ALTER TABLE cart ADD CONSTRAINT FK_cart_user FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE cart ADD CONSTRAINT FK_cart_book FOREIGN KEY (book_id) REFERENCES book(id);
ALTER TABLE comment ADD CONSTRAINT FK_comment_user FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE comment ADD CONSTRAINT FK_comment_book FOREIGN KEY (book_id) REFERENCES book(id);
ALTER TABLE book ADD CONSTRAINT FK_book_category FOREIGN KEY (category_id) REFERENCES category(id);
ALTER TABLE user ADD CONSTRAINT FK_user_role FOREIGN KEY (role_id) REFERENCES role(id);