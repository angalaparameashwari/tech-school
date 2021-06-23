package com.tech_school.app.mapper;

import com.tech_school.app.api_models.users.CreateUserApiModel;
import com.tech_school.app.api_models.users.UserApiModel;
import com.tech_school.app.entity.User;
import com.tech_school.app.validators.predicates.UserPredicates;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User createApiToDbMapper(CreateUserApiModel createUserApiModel){
        User user = new User();
        if(UserPredicates.isNotNull.test(createUserApiModel.getEmail())) {
            user.setEmail(createUserApiModel.getEmail());
        }
        if(UserPredicates.isNotNull.test(createUserApiModel.getFirstName())){
            user.setFirst_name(createUserApiModel.getFirstName());
        }
        if(UserPredicates.isNotNull.test(createUserApiModel.getLastName())){
            user.setLast_name(createUserApiModel.getLastName());
        }
        if(UserPredicates.isNotNull.test(createUserApiModel.getId())){
            user.setExternalId(createUserApiModel.getId());
        }
        return user;
    }


    public UserApiModel dbToApiMapper(User user){
        UserApiModel userApiModel = new UserApiModel();
        if(UserPredicates.isNotNull.test(user.getEmail())) {
            userApiModel.setEmail(user.getEmail());
        }
        if(UserPredicates.isNotNull.test(user.getFirst_name())){
            userApiModel.setFirst_name(user.getFirst_name());
        }
        if(UserPredicates.isNotNull.test(user.getLast_name())){
            userApiModel.setLast_name(user.getLast_name());
        }
        if(UserPredicates.isNotNull.test(user.getExternalId())){
            userApiModel.setId(user.getExternalId());
        }
        userApiModel.setId(user.getExternalId());
        return userApiModel;
    }
}
