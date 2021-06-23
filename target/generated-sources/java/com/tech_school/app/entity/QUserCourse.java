package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserCourse is a Querydsl query type for UserCourse
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserCourse extends EntityPathBase<UserCourse> {

    private static final long serialVersionUID = 372511014L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserCourse userCourse = new QUserCourse("userCourse");

    public final QCommonEntities _super = new QCommonEntities(this);

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

    public final QUser user;

    public QUserCourse(String variable) {
        this(UserCourse.class, forVariable(variable), INITS);
    }

    public QUserCourse(Path<? extends UserCourse> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserCourse(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserCourse(PathMetadata metadata, PathInits inits) {
        this(UserCourse.class, metadata, inits);
    }

    public QUserCourse(Class<? extends UserCourse> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

