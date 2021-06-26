package com.tech_school.app.api_models.sections;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech_school.app.api_models.ApiModel;
import com.tech_school.app.api_models.lessons.LessonApiModel;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Generated
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionApiModel extends ApiModel {

    private static final long serialVersionUID = 1L;

    private String id;

    private String course_id;

    private String title;

    private String description;

    @JsonProperty("lessons")
    @Builder.Default
    @Valid
    private List<LessonApiModel> lessons = null;

}
