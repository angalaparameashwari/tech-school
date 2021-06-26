package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSectionsMaster is a Querydsl query type for SectionsMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSectionsMaster extends EntityPathBase<SectionsMaster> {

    private static final long serialVersionUID = 2032502672L;

    public static final QSectionsMaster sectionsMaster = new QSectionsMaster("sectionsMaster");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final StringPath commitId = createString("commitId");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final StringPath externalId = createString("externalId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QSectionsMaster(String variable) {
        super(SectionsMaster.class, forVariable(variable));
    }

    public QSectionsMaster(Path<? extends SectionsMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSectionsMaster(PathMetadata metadata) {
        super(SectionsMaster.class, metadata);
    }

}

