package dev.naimsulejmani.grupi3fleetmanagement.security;

import dev.naimsulejmani.grupi3fleetmanagement.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class CookieSessionSimpleFilter extends OncePerRequestFilter {

    private final UserService userService;

    public CookieSessionSimpleFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        if (request.getRequestURI().contains("/assets")) {
            filterChain.doFilter(request, response);
            return;
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user-id")) {

                    long userId = Long.parseLong(cookie.getValue());
                    var user = userService.findById(userId);
                    if (user == null) {
                        break;
                    }
                    request.setAttribute("user", user);
                    // get user model from repository
                    //var user = userservice.findById(Long.parseLong(cookie.getValue()));
                    // append user to request
                    //request.setAttribute("user", user);

                    if (!(request.getRequestURI().equals("/login") || request.getRequestURI().equals("/register"))) {
                        filterChain.doFilter(request, response);
                    } else {
                        response.sendRedirect("/");
                    }
                    return;
                }
            }
        }

        if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/register")) {
            filterChain.doFilter(request, response);
            return;
        }

//        response.encodeRedirectURL("/login");
        response.sendRedirect("/login");
    }
}
