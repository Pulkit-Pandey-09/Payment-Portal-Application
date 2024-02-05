package demo.ongrid.payment.config.security;

import demo.ongrid.payment.service.CustomUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private CustomUserDetailService customUserDetailService;
    private JwtTokenHelper jwtTokenHelper;
    @Autowired
    public JwtAuthenticationFilter(CustomUserDetailService customUserDetailService, JwtTokenHelper jwtTokenHelper){
        this.customUserDetailService = customUserDetailService;
        this.jwtTokenHelper = jwtTokenHelper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {


//      1. get JWT token from request. Key value pair(where key is "Authorizatio
        String requestToken = request.getHeader("Authorization");
        /*
                request token       Bearer 2e2hedhuiedh
                index               01234567
         */

        String token = null;    // this string gets mapped with 2e2hedhuiedh
        if(requestToken != null && requestToken.startsWith("Bearer")){
            token = requestToken.substring(7);  // 2e2hedhuiedh starts at index 7. This token would be without "Bearer"
        }else{
            System.out.println("JWT token does not begin with Bearer");
        }

        /* 2. once we get the token, we will validate the token and set authentication context
               StringUtils.hasText(requestToken) checks if the requestToken variable contains any content.
               If the requestToken is not null, not empty, and contains at least one non-whitespace character, the condition will evaluate to true
        */
        if(StringUtils.hasText(requestToken) && jwtTokenHelper.validateToken(token)){
            String username = jwtTokenHelper.getUsernameFromToken(token);
            UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, null);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
