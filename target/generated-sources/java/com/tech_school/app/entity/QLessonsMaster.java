package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLessonsMaster is a Querydsl query type for LessonsMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLessonsMaster extends EntityPathBase<LessonsMaster> {

    private static final long serialVersionUID = -1987240163L;

    public static final QLessonsMaster lessonsMaster = new QLessonsMaster("lessonsMaster");

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

    public final StringPath sectionId = createString("sectionId");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QLessonsMaster(String variable) {
        super(LessonsMaster.class, forVariable(variable));
    }

    public QLessonsMaster(Path<? extends LessonsMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLessonsMaster(PathMetadata metadata) {
        super(LessonsMaster.class, metadata);
    }

}

