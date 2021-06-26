package com.tech_school.app.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "courses_master")
public class CoursesMaster extends CommonEntities{
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId  = UUID.randomUUID().toString();
    private String name;
    private String title;
    private String description;
    @Column(nullable = false, name = "commit_id")
    private String commitId;
    @Column(nullable = false, name = "previous_commit")
    private String previousCommit;
}
