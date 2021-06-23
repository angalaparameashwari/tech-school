package com.tech_school.app.services.users;

import com.tech_school.app.entity.User;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

public interface UserService {

    Optional<User> create(@Valid User user);
}
