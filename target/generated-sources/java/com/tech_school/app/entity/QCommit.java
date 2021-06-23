package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommit is a Querydsl query type for Commit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommit extends EntityPathBase<Commit> {

    private static final long serialVersionUID = 1925543575L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommit commit = new QCommit("commit");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final QAuthor author;

    public final SetPath<CourseCommit, QCourseCommit> courseCommits = this.<CourseCommit, QCourseCommit>createSet("courseCommits", CourseCommit.class, QCourseCommit.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath external_id = createString("external_id");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<LessonCommit, QLessonCommit> lessonCommits = this.<LessonCommit, QLessonCommit>createSet("lessonCommits", LessonCommit.class, QLessonCommit.class, PathInits.DIRECT2);

    public final StringPath message = createString("message");

    public final StringPath sate = createString("sate");

    public final SetPath<SectionCommit, QSectionCommit> sectionCommits = this.<SectionCommit, QSectionCommit>createSet("sectionCommits", SectionCommit.class, QSectionCommit.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QCommit(String variable) {
        this(Commit.class, forVariable(variable), INITS);
    }

    public QCommit(Path<? extends Commit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommit(PathMetadata metadata, PathInits inits) {
        this(Commit.class, metadata, inits);
    }

    public QCommit(Class<? extends Commit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.author = inits.isInitialized("author") ? new QAuthor(forProperty("author")) : null;
    }

}

