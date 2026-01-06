package net.irq3.blog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "text_article")
    String textArticle;

    @Column(name = "date_created", insertable = false, updatable = false)
    Date dateCreated;

    @Column(name = "date_updated")
    Date dateUpdated;

    @Column(name = "author")
    Long authorId;
}
/*
CREATE TABLE posts(
    id BIGINT PRIMARY KEY NOT NULL,
    title VARCHAR(120) NOT NULL,
    description TEXT NOT NULL,
    text_article TEXT NOT NULL,
    date_created TIMESTAMP DEFAULT NOW() NOT NULL,
    date_updated TIMESTAMP
);
 */