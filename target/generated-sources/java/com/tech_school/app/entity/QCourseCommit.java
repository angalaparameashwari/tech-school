package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourseCommit is a Querydsl query type for CourseCommit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourseCommit extends EntityPathBase<CourseCommit> {

    private static final long serialVersionUID = -743048558L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCourseCommit courseCommit = new QCourseCommit("courseCommit");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final QCommit commit;

    public final QCourse course;

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QStagedChanges stagedChanges;

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QCourseCommit(String variable) {
        this(CourseCommit.class, forVariable(variable), INITS);
    }

    public QCourseCommit(Path<? extends CourseCommit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCourseCommit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCourseCommit(PathMetadata metadata, PathInits inits) {
        this(CourseCommit.class, metadata, inits);
    }

    public QCourseCommit(Class<? extends CourseCommit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commit = inits.isInitialized("commit") ? new QCommit(forProperty("commit"), inits.get("commit")) : null;
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course")) : null;
        this.stagedChanges = inits.isInitialized("stagedChanges") ? new QStagedChanges(forProperty("stagedChanges"), inits.get("stagedChanges")) : null;
    }

}

