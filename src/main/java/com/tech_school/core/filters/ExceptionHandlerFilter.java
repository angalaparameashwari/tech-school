package com.tech_school.core.filters;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech_school.core.exceptions.ErrorResponse;
import com.tech_school.core.exceptions.handlers.CustomExceptionHandler;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    private CustomExceptionHandler exceptionHandler;

    public ExceptionHandlerFilter(CustomExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try{
            filterChain.doFilter(request,response);
        } catch(Exception exp){
            ResponseEntity<ErrorResponse> err = exceptionHandler.handleException(exp);
            this.sendError(err,response);
            System.out.println(exp);
            throw exp;
        } finally {
            SecurityContextHolder.clearContext();
        }
    }

    private void sendError(ResponseEntity<ErrorResponse> err, HttpServletResponse response) throws IOException {
        response.setStatus(err.getStatusCodeValue());
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(err.getBody()));
        writer.flush();
    }
}
