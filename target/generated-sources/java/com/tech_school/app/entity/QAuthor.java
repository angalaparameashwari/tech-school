package com.tech_school.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuthor is a Querydsl query type for Author
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAuthor extends EntityPathBase<Author> {

    private static final long serialVersionUID = 1874030315L;

    public static final QAuthor author = new QAuthor("author");

    public final QCommonEntities _super = new QCommonEntities(this);

    public final SetPath<AuthorCourse, QAuthorCourse> authorCourses = this.<AuthorCourse, QAuthorCourse>createSet("authorCourses", AuthorCourse.class, QAuthorCourse.class, PathInits.DIRECT2);

    public final SetPath<Commit, QCommit> commits = this.<Commit, QCommit>createSet("commits", Commit.class, QCommit.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath deleted = _super.deleted;

    public final StringPath email = createString("email");

    public final StringPath externalId = createString("externalId");

    public final StringPath first_name = createString("first_name");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath last_name = createString("last_name");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QAuthor(String variable) {
        super(Author.class, forVariable(variable));
    }

    public QAuthor(Path<? extends Author> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthor(PathMetadata metadata) {
        super(Author.class, metadata);
    }

}

