package net.irq3.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.irq3.blog.utils.PermissionConverter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    @JsonIgnore
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "permissions",columnDefinition = "TEXT")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Convert(converter = PermissionConverter.class)
    private List<Permissions> permissions;
}
/*
CREATE TABLE users(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(80) NOT NULL,
    email VARCHAR(100),
    password VARCHAR(150),
    url_image VARCHAR(300),
    date_created DATE DEFAULT NOW() NOT NULL,
);
 */
