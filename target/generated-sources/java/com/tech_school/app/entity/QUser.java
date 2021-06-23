package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 967905579L;

    public static final QUser user = new QUser("user");

    public final QCommonEntities _super = new QCommonEntities(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath email = createString("email");

    public final StringPath externalId = createString("externalId");

    public final StringPath first_name = createString("first_name");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath last_name = createString("last_name");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final SetPath<UserCourse, QUserCourse> userCourses = this.<UserCourse, QUserCourse>createSet("userCourses", UserCourse.class, QUserCourse.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

