package com.tech_school.app.api_models.courses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech_school.app.api_models.ApiModel;
import com.tech_school.app.api_models.sections.SectionApiModel;
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
public class CourseApiModel extends ApiModel {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String name;

    private String description;

    private String state;

    @JsonProperty("sections")
    @Builder.Default
    @Valid
    private List<SectionApiModel> sections = null;

}
