package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCoursesMaster is a Querydsl query type for CoursesMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCoursesMaster extends EntityPathBase<CoursesMaster> {

    private static final long serialVersionUID = 1401517786L;

    public static final QCoursesMaster coursesMaster = new QCoursesMaster("coursesMaster");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final StringPath commitId = createString("commitId");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath previousCommit = createString("previousCommit");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QCoursesMaster(String variable) {
        super(CoursesMaster.class, forVariable(variable));
    }

    public QCoursesMaster(Path<? extends CoursesMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCoursesMaster(PathMetadata metadata) {
        super(CoursesMaster.class, metadata);
    }

}

