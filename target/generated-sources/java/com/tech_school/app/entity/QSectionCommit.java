package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSectionCommit is a Querydsl query type for SectionCommit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSectionCommit extends EntityPathBase<SectionCommit> {

    private static final long serialVersionUID = -1969620196L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSectionCommit sectionCommit = new QSectionCommit("sectionCommit");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final QCommit commit;

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QSection section;

    public final QStagedChanges stagedChanges;

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QSectionCommit(String variable) {
        this(SectionCommit.class, forVariable(variable), INITS);
    }

    public QSectionCommit(Path<? extends SectionCommit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSectionCommit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSectionCommit(PathMetadata metadata, PathInits inits) {
        this(SectionCommit.class, metadata, inits);
    }

    public QSectionCommit(Class<? extends SectionCommit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commit = inits.isInitialized("commit") ? new QCommit(forProperty("commit"), inits.get("commit")) : null;
        this.section = inits.isInitialized("section") ? new QSection(forProperty("section")) : null;
        this.stagedChanges = inits.isInitialized("stagedChanges") ? new QStagedChanges(forProperty("stagedChanges"), inits.get("stagedChanges")) : null;
    }

}

