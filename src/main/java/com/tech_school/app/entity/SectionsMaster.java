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
@Entity(name = "sections_master")
public class SectionsMaster extends CommonEntities{
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId  = UUID.randomUUID().toString();
    private String title;
    private String description;
    @Column(nullable = false, name = "course_id")
    private String courseId;
    @Column(nullable = false, name = "commit_id")
    private String commitId;
}
