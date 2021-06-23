package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSection is a Querydsl query type for Section
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSection extends EntityPathBase<Section> {

    private static final long serialVersionUID = 582147461L;

    public static final QSection section = new QSection("section");

    public final QCommonEntities _super = new QCommonEntities(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<SectionCommit, QSectionCommit> sectionCommits = this.<SectionCommit, QSectionCommit>createSet("sectionCommits", SectionCommit.class, QSectionCommit.class, PathInits.DIRECT2);

    public final StringPath state = createString("state");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QSection(String variable) {
        super(Section.class, forVariable(variable));
    }

    public QSection(Path<? extends Section> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSection(PathMetadata metadata) {
        super(Section.class, metadata);
    }

}

