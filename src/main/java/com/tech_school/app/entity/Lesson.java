package com.tech_school.app.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "lessons")
public class Lesson extends CommonEntities{
    @Column(nullable = false)
    @Builder.Default
    private String external_id  = UUID.randomUUID().toString();
    private String title;
    private String description;
    private String url;
    private String type;
    private String state;
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private Set<LessonCommit> lessonCommits;
//    section INT REFERENCES sections(id),
//    title VARCHAR(500) NOT NULL,
//    description text NOT NULL,
//    url VARCHAR(500) NOT NULL,
//    type VARCHAR(250) NOT NULL,
//    state VARCHAR(250) NOT NULL,
}
