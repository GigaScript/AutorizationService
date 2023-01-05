package com.example.autorizationservice;

import com.example.autorizationservice.exception.InvalidCredentials;
import com.example.autorizationservice.model.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UserAuthResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return User.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String username = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");
        if (username == null || isEmpty(username) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty!");
        }
        User user = new User();
        user.setUser(username);
        user.setPassword(password);
        return user;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
