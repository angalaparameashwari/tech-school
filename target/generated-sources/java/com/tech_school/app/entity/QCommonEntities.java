package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommonEntities is a Querydsl query type for CommonEntities
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QCommonEntities extends EntityPathBase<CommonEntities> {

    private static final long serialVersionUID = -1543919572L;

    public static final QCommonEntities commonEntities = new QCommonEntities("commonEntities");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath deleted = createString("deleted");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QCommonEntities(String variable) {
        super(CommonEntities.class, forVariable(variable));
    }

    public QCommonEntities(Path<? extends CommonEntities> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommonEntities(PathMetadata metadata) {
        super(CommonEntities.class, metadata);
    }

}

