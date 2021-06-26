package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLessonCommit is a Querydsl query type for LessonCommit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLessonCommit extends EntityPathBase<LessonCommit> {

    private static final long serialVersionUID = 810204655L;

    public static final QLessonCommit lessonCommit = new QLessonCommit("lessonCommit");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final StringPath commit_id = createString("commit_id");

    public final StringPath course_id = createString("course_id");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath lessonId = createString("lessonId");

    public final StringPath session_id = createString("session_id");

    public final StringPath state = createString("state");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QLessonCommit(String variable) {
        super(LessonCommit.class, forVariable(variable));
    }

    public QLessonCommit(Path<? extends LessonCommit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLessonCommit(PathMetadata metadata) {
        super(LessonCommit.class, metadata);
    }

}

