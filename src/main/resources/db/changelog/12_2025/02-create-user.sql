CREATE TABLE users(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(80) NOT NULL,
    email VARCHAR(100),
    password VARCHAR(150),
    url_image VARCHAR(300),
    date_created DATE DEFAULT NOW() NOT NULL
);