package com.jwt.movies_users.movies_users_jwt.Configurations;

import com.jwt.movies_users.movies_users_jwt.Services.TokenService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class JWTFilter extends GenericFilterBean {

    @Autowired
    private TokenService tokenService;

    public JWTFilter(TokenService tokenService) {
        this.tokenService = tokenService;

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;

        String token = httpServletRequest.getHeader("Authorization");

        if("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())){
            httpServletResponse.sendError(HttpServletResponse.SC_OK,"Success");
            return;
        }
        if(allowRequestWithoutToken(httpServletRequest)){
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(req,res);
        }
        else{
            try{
                ObjectId userId = new ObjectId(tokenService.getUserIdFromToken(token));
                httpServletRequest.setAttribute("userId",userId);
            }
            catch (IllegalArgumentException exception){
                System.out.println(exception);
            }
            filterChain.doFilter(req,res);
        }



    }


    public  boolean allowRequestWithoutToken(HttpServletRequest request){
        System.out.println(request.getRequestURI());
        if(request.getRequestURI().contains("/user"))   return true;
        return false;
    }
}
