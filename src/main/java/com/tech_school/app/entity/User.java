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
@Entity(name = "users")
public class User extends CommonEntities{
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId = UUID.randomUUID().toString();
    private String first_name;
    private String last_name;
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserCourse> userCourses;
}
