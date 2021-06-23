package com.tech_school.app.api_models.courses;

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
public class CreateCourseApiModel extends ApiModel {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Size(max = 500, message = "exception.param.size")
    private String id;

    @JsonProperty("title")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")
    private String title;

    @JsonProperty("description")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")
    private String description;

}
