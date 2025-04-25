package com.ra.orderapp_java.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final Logger LOG = LoggerFactory.getLogger(Interceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws IOException {
        log.info("BasicAuthInterceptor::preHandle()");

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Basic ")) {

            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedCredentials = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedCredentials, StandardCharsets.UTF_8);

            String[] parts = credentials.split(":");
            String username = parts[0];
            String password = parts[1];

            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                return true;
            }
        }

//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//        return false;

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model){
        LOG.info("Handler execution is complete");
        System.out.println("Handler execution is complete");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception){
        LOG.info("Request is complete");
        System.out.println("Request is complete");
    }
}