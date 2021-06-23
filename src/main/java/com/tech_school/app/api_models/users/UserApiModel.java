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
public class UserApiModel extends ApiModel {

    private static final long serialVersionUID = 1L;

    private String id;

    private String first_name;

    private String last_name;

    private String email;
}
