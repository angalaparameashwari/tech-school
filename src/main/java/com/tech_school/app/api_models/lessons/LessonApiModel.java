package com.tech_school.app.api_models.lessons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech_school.app.api_models.ApiModel;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Generated
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonApiModel extends ApiModel {

    private static final long serialVersionUID = 1L;

    private String id;

    @JsonProperty("course_id")
    private String courseId;

    @JsonProperty("section_id")
    private String sectionId;

    private String title;

    private String description;

    private String url;
    private String type;

}
