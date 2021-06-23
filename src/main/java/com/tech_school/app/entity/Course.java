package com.tech_school.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "courses")
public class Course extends CommonEntities{
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId = UUID.randomUUID().toString();
    private String title;
    private String description;
    private String state;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<AuthorCourse> authorCourses;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserCourse> userCourses;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<CourseCommit> courseCommits;
//    external_id VARCHAR(250) NOT NULL UNIQUE,
//    title VARCHAR(500) NOT NULL,
//    description text NOT NULL,
//    created_by INT REFERENCES authors(id),
//    state VARCHAR(250) NOT NULL,
}
