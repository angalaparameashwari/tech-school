package com.tech_school.app.api_models.users;

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
public class CreateUserApiModel extends ApiModel {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Size(max = 500, message = "exception.param.size")
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    @NotNull(message = "exception.param.notNull")
    @NotBlank(message = "exception.param.notBlank")

    @Size(max = 500, message = "exception.param.size")
    private String email;
}
