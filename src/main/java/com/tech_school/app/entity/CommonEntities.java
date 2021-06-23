package com.tech_school.app.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Contains the common column attributes of the db table entity.
 */

@Getter
@Setter
@MappedSuperclass
public abstract class CommonEntities implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date updatedAt;

    private String deleted;

    // when entity is created
    @PrePersist
    public void onCreate() {

        this.setCreatedAt(new Date());
        this.setUpdatedAt(new Date());

    }

    // when entity is updated
    @PreUpdate
    public void onUpdate() {
        this.setUpdatedAt(new Date());
    }

    // when entity is deleted
    @PostRemove
    public void onDelete() {
        this.setUpdatedAt(new Date());
        this.setDeleted(UUID.randomUUID().toString());
    }

}
