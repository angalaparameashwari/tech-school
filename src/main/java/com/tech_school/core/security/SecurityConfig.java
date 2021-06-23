//package com.tech_school.core.security;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////        private CustomExceptionHandler exceptionHandler;
//
//        @Autowired
//        public SecurityConfig() {
////            this.exceptionHandler = exceptionHandler;
//        }
//
//        @Override
//        public void configure(WebSecurity webSecurity) {
//        }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll();
//
////        http.authorizeRequests().anyRequest().permitAll()
////                .and()
////                .addFilter(new UserFilter());
////
////        http
////                .csrf().disable() //
////                //@todo siva anonymous disable
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .authorizeRequests()
////                .anyRequest().authenticated().and()
////                .exceptionHandling().and()
////                .addFilter(new UserFilter());
////                .addFilterBefore(new UserFilter(), UsernamePasswordAuthenticationFilter.class)
////                .addFilterBefore(new ExceptionHandlerFilter(exceptionHandler), UserFilter.class);
//
////        http
////                .csrf().disable()
////                .cors().disable()
////                .authorizeRequests().and()
////                .addFilterBefore(new ExceptionHandlerFilter(exceptionHandler), BasicAuthenticationFilter.class)
////                .addFilterBefore(new UserFilter(),ExceptionHandlerFilter.class);
//    }
//}
