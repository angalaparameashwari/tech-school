package com.tech_school.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course_commits")
public class CourseCommit extends CommonEntities {
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId  = UUID.randomUUID().toString();

    @Column(nullable = false, name = "course_id")
    private String courseId;
    private String name;
    private String title;
    private String description;
//    @Column(nullable = false, name = "commit_id")
//    @OneToMany(mappedBy = "course_commits", cascade = CascadeType.ALL)
//    private List<Commit> commits = new ArrayList<>();

    @Column(nullable = false, name = "commit_id")
    private String commitId;
}
