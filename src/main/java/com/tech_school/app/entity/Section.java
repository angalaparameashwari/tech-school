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
@Entity(name = "sections")
public class Section extends CommonEntities{
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId  = UUID.randomUUID().toString();
    private String title;
    private String description;
    private String state;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private Set<SectionCommit> sectionCommits;
}
