CREATE TABLE posts(
    id BIGINT PRIMARY KEY NOT NULL,
    title VARCHAR(120) NOT NULL,
    description TEXT NOT NULL,
    text_article TEXT NOT NULL,
    date_created TIMESTAMP DEFAULT NOW() NOT NULL,
    date_updated TIMESTAMP
);