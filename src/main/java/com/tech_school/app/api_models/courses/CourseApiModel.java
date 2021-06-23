package com.tech_school.app.api_models.courses;

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
public class CourseApiModel extends ApiModel {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String description;

    private String state;

}
