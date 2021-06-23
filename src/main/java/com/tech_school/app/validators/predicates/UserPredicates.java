package com.tech_school.app.validators.predicates;

import java.util.function.Predicate;

public interface UserPredicates {
    Predicate<String> isNotNull = str -> str != null && !str.equals("");
}
