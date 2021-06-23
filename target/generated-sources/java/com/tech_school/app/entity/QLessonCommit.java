package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLessonCommit is a Querydsl query type for LessonCommit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLessonCommit extends EntityPathBase<LessonCommit> {

    private static final long serialVersionUID = 810204655L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLessonCommit lessonCommit = new QLessonCommit("lessonCommit");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final QCommit commit;

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath external_id = createString("external_id");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QLesson lesson;

    public final QStagedChanges stagedChanges;

    public final StringPath state = createString("state");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QLessonCommit(String variable) {
        this(LessonCommit.class, forVariable(variable), INITS);
    }

    public QLessonCommit(Path<? extends LessonCommit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLessonCommit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLessonCommit(PathMetadata metadata, PathInits inits) {
        this(LessonCommit.class, metadata, inits);
    }

    public QLessonCommit(Class<? extends LessonCommit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commit = inits.isInitialized("commit") ? new QCommit(forProperty("commit"), inits.get("commit")) : null;
        this.lesson = inits.isInitialized("lesson") ? new QLesson(forProperty("lesson")) : null;
        this.stagedChanges = inits.isInitialized("stagedChanges") ? new QStagedChanges(forProperty("stagedChanges"), inits.get("stagedChanges")) : null;
    }

}

