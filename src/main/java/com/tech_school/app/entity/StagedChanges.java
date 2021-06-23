package com.tech_school.app.entity;

import com.tech_school.app.enums.CommitStates;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "staged_changes")
public class StagedChanges extends CommonEntities {
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId  = UUID.randomUUID().toString();
    private int state;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<CourseCommit> courseCommits;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private Set<SectionCommit> sectionCommits;
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private Set<LessonCommit> lessonCommits;
}
