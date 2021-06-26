package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSectionCommit is a Querydsl query type for SectionCommit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSectionCommit extends EntityPathBase<SectionCommit> {

    private static final long serialVersionUID = -1969620196L;

    public static final QSectionCommit sectionCommit = new QSectionCommit("sectionCommit");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final StringPath commitId = createString("commitId");

    public final StringPath courseId = createString("courseId");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath sectionId = createString("sectionId");

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QSectionCommit(String variable) {
        super(SectionCommit.class, forVariable(variable));
    }

    public QSectionCommit(Path<? extends SectionCommit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSectionCommit(PathMetadata metadata) {
        super(SectionCommit.class, metadata);
    }

}

