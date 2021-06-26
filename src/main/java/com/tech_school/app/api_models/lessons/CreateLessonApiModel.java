package com.tech_school.app.api_models.lessons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech_school.app.api_models.ApiModel;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
@Generated
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLessonApiModel extends ApiModel {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Size(max = 500, message = "exception.param.size")
    private String id;

    @JsonProperty("course_id")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")
    private String courseId;

    @JsonProperty("section_id")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")
    private String sectionId;

    @JsonProperty("title")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")
    private String title;

    @JsonProperty("description")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")
    private String description;

    @JsonProperty("url")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")
    private String url;

    @JsonProperty("content_type")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")
    private String content;

    @JsonProperty("author_id")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")
    private String authorId;

}
