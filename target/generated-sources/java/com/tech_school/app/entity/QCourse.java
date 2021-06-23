package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourse is a Querydsl query type for Course
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourse extends EntityPathBase<Course> {

    private static final long serialVersionUID = 1925787003L;

    public static final QCourse course = new QCourse("course");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final SetPath<AuthorCourse, QAuthorCourse> authorCourses = this.<AuthorCourse, QAuthorCourse>createSet("authorCourses", AuthorCourse.class, QAuthorCourse.class, PathInits.DIRECT2);

    public final SetPath<CourseCommit, QCourseCommit> courseCommits = this.<CourseCommit, QCourseCommit>createSet("courseCommits", CourseCommit.class, QCourseCommit.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath state = createString("state");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final SetPath<UserCourse, QUserCourse> userCourses = this.<UserCourse, QUserCourse>createSet("userCourses", UserCourse.class, QUserCourse.class, PathInits.DIRECT2);

    public QCourse(String variable) {
        super(Course.class, forVariable(variable));
    }

    public QCourse(Path<? extends Course> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCourse(PathMetadata metadata) {
        super(Course.class, metadata);
    }

}

