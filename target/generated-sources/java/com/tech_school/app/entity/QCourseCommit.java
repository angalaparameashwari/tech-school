package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCourseCommit is a Querydsl query type for CourseCommit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourseCommit extends EntityPathBase<CourseCommit> {

    private static final long serialVersionUID = -743048558L;

    public static final QCourseCommit courseCommit = new QCourseCommit("courseCommit");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final StringPath commit_id = createString("commit_id");

    public final StringPath courseId = createString("courseId");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QCourseCommit(String variable) {
        super(CourseCommit.class, forVariable(variable));
    }

    public QCourseCommit(Path<? extends CourseCommit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCourseCommit(PathMetadata metadata) {
        super(CourseCommit.class, metadata);
    }

}

