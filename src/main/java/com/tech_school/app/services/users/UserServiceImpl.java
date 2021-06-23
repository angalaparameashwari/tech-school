package com.tech_school.app.services.users;

import com.tech_school.app.dao.repositories.CourseRepository;
import com.tech_school.app.dao.repositories.UserRepository;
import com.tech_school.app.entity.User;
import com.tech_school.core.exceptions.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    UserRepository repo;


    @Autowired
    public UserServiceImpl(UserRepository repo){
        this.repo = repo;
    }

    @Override
    public Optional<User> create(@Valid User user) {
        Optional<User> availableUser = repo.findByGivenId(user.getExternalId());
        if(availableUser.isPresent()){
            logger.info("user_already_available", "true");
            throw new GeneralException("User already available with the same id ");
        }
        logger.info("user_id", user.getExternalId());
        Optional<User> response = Optional.of(repo.save(user));
        System.out.println();
        return response;
    }
}
