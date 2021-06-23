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
@Entity(name = "commits")
public class Commit extends CommonEntities {
    @Column(nullable = false)
    @Builder.Default
    private String external_id  = UUID.randomUUID().toString();
    private String message;
    private String sate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<CourseCommit> courseCommits;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private Set<SectionCommit> sectionCommits;
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private Set<LessonCommit> lessonCommits;
//    author_id INT REFERENCES authors(id),
//    previous_commit INT REFERENCES commits(id),
//    message text NOT NULL,
//    state VARCHAR(250) NOT NULL,
}
