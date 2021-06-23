package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStagedChanges is a Querydsl query type for StagedChanges
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStagedChanges extends EntityPathBase<StagedChanges> {

    private static final long serialVersionUID = 7490909L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStagedChanges stagedChanges = new QStagedChanges("stagedChanges");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final QAuthor author;

    public final SetPath<CourseCommit, QCourseCommit> courseCommits = this.<CourseCommit, QCourseCommit>createSet("courseCommits", CourseCommit.class, QCourseCommit.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<LessonCommit, QLessonCommit> lessonCommits = this.<LessonCommit, QLessonCommit>createSet("lessonCommits", LessonCommit.class, QLessonCommit.class, PathInits.DIRECT2);

    public final SetPath<SectionCommit, QSectionCommit> sectionCommits = this.<SectionCommit, QSectionCommit>createSet("sectionCommits", SectionCommit.class, QSectionCommit.class, PathInits.DIRECT2);

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QStagedChanges(String variable) {
        this(StagedChanges.class, forVariable(variable), INITS);
    }

    public QStagedChanges(Path<? extends StagedChanges> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStagedChanges(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStagedChanges(PathMetadata metadata, PathInits inits) {
        this(StagedChanges.class, metadata, inits);
    }

    public QStagedChanges(Class<? extends StagedChanges> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.author = inits.isInitialized("author") ? new QAuthor(forProperty("author")) : null;
    }

}

