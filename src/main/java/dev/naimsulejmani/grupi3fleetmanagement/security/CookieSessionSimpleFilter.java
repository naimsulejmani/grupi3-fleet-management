package dev.naimsulejmani.grupi3fleetmanagement.security;

import dev.naimsulejmani.grupi3fleetmanagement.dtos.UserDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class CookieSessionSimpleFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        if (request.getRequestURI().contains("/assets")) {
            filterChain.doFilter(request, response);
            return; // return to stop the execution of the method
        }

        if (request.getRequestURI().startsWith("/api/v1")) {
            filterChain.doFilter(request, response);
            return;
        }

//        System.out.println(request.getMethod() + " -> " + request.getRequestURI());


//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("user-id")) {
//                    var user = badUserService.findById(Long.parseLong(cookie.getValue()));
//                    if (user == null) {
//                        break;
//                    }
//                    request.setAttribute("user", user);
//
//                    HttpSession session = request.getSession(false);
//                    if (session == null || session.getAttribute("user") == null) {
//                        session = request.getSession();
//                        session.setAttribute("user", user);
//                    } else {
//                        var sessionUser = (UserDto) session.getAttribute("user");
//                        if (!sessionUser.getId().equals(user.getId())) {
//                            if (!request.getRequestURI().startsWith("/error500"))
//                                response.sendRedirect("/error500");
//                            else
//                                filterChain.doFilter(request, response);
//                            return;
//                        }
//                    }
//
////                    long userId = Long.parseLong(cookie.getValue());
////                    var user = userService.findById(userId);
////                    if (user == null) {
////                        break;
////                    }
//
////                    request.setAttribute("user", user);
//                    // get user model from repository
//                    //var user = userservice.findById(Long.parseLong(cookie.getValue()));
//                    // append user to request
//                    //request.setAttribute("user", user);
//
//                    if (!(request.getRequestURI().equals("/login") || request.getRequestURI().equals("/register"))) {
//                        filterChain.doFilter(request, response);
//                    } else {
//                        response.sendRedirect("/");
//                    }
//                    return;
//                }
//            }
//        }

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/register")) {
                response.sendRedirect("/");
                return;
            }

            UserDto userDto = (UserDto) session.getAttribute("user");

            //request.setAttribute("user", userDto);
//            if(userDto.getRole().equals("ROLE_ADMIN")) {
//                AdminRoleFilter.doFilter(request, response, filterChain);
//                return;
//            } else if(userDto.getRole().equals("ROLE_USER")) {
//                UserRoleFilter.doFilter(request, response, filterChain);
//                return;
//            }

            filterChain.doFilter(request, response);
            return;
        }

        if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/register")) {
            filterChain.doFilter(request, response);
            return;
        }

//        response.encodeRedirectURL("/login");
        response.sendRedirect("/login?returnUrl=" + request.getRequestURI());
    }
}
