package com.tech_school.core.security;


import com.tech_school.core.exceptions.handlers.CustomExceptionHandler;
import com.tech_school.core.filters.ExceptionHandlerFilter;
import com.tech_school.core.filters.UserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        private CustomExceptionHandler exceptionHandler;

        @Autowired
        public SecurityConfig() {
            this.exceptionHandler = exceptionHandler;
        }

        @Override
        public void configure(WebSecurity webSecurity) {
        }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest()
                .permitAll().and()
                .addFilter(new ExceptionHandlerFilter(exceptionHandler));


//        http
//                .csrf().disable()
//                .cors().disable()
//                .authorizeRequests().and()
//                .addFilterBefore(new ExceptionHandlerFilter(exceptionHandler), BasicAuthenticationFilter.class)
//                .addFilterBefore(new UserFilter(),ExceptionHandlerFilter.class);
    }
}
