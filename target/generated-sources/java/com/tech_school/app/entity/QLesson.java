package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLesson is a Querydsl query type for Lesson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLesson extends EntityPathBase<Lesson> {

    private static final long serialVersionUID = -2120811880L;

    public static final QLesson lesson = new QLesson("lesson");

    public final QCommonEntities _super = new QCommonEntities(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath external_id = createString("external_id");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<LessonCommit, QLessonCommit> lessonCommits = this.<LessonCommit, QLessonCommit>createSet("lessonCommits", LessonCommit.class, QLessonCommit.class, PathInits.DIRECT2);

    public final StringPath state = createString("state");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QLesson(String variable) {
        super(Lesson.class, forVariable(variable));
    }

    public QLesson(Path<? extends Lesson> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLesson(PathMetadata metadata) {
        super(Lesson.class, metadata);
    }

}

