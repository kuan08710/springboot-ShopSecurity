package com.louis.shopsecurity.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.shopsecurity.controller.result.BaseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess (
            HttpServletRequest request , HttpServletResponse response , Authentication authentication
    ) throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);

        BaseResult result = new BaseResult(HttpServletResponse.SC_OK , "登錄成功");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);

        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
    }
}