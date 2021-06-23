package com.tech_school.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "authors")
public class Author extends CommonEntities {
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId  = UUID.randomUUID().toString();
    private String first_name;
    private String last_name;
    private String email;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<AuthorCourse> authorCourses;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Commit> commits;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<StagedChanges> stagedChanges;
}
