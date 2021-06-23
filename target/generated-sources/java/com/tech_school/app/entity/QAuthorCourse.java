package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuthorCourse is a Querydsl query type for AuthorCourse
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAuthorCourse extends EntityPathBase<AuthorCourse> {

    private static final long serialVersionUID = -1830215962L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuthorCourse authorCourse = new QAuthorCourse("authorCourse");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final QAuthor author;

    public final QCourse course;

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath external_id = createString("external_id");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QAuthorCourse(String variable) {
        this(AuthorCourse.class, forVariable(variable), INITS);
    }

    public QAuthorCourse(Path<? extends AuthorCourse> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAuthorCourse(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAuthorCourse(PathMetadata metadata, PathInits inits) {
        this(AuthorCourse.class, metadata, inits);
    }

    public QAuthorCourse(Class<? extends AuthorCourse> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.author = inits.isInitialized("author") ? new QAuthor(forProperty("author")) : null;
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course")) : null;
    }

}

