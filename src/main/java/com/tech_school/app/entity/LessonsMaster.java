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
@Entity(name = "lessons_master")
public class LessonsMaster extends CommonEntities{
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId  = UUID.randomUUID().toString();
    @Column(nullable = false, name = "section_id")
    private String sectionId;
    private String title;
    private String description;
    private String url;
    private String type;
    @Column(nullable = false, name = "commit_id")
    private String commitId;
//    section INT REFERENCES sections(id),
//    title VARCHAR(500) NOT NULL,
//    description text NOT NULL,
//    url VARCHAR(500) NOT NULL,
//    type VARCHAR(250) NOT NULL,
//    state VARCHAR(250) NOT NULL,
}
