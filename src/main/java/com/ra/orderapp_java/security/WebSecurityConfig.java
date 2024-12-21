package com.ra.orderapp_java.security;


import com.ra.orderapp_java.security.jwt.CustomAccessDeniedHandler;
import com.ra.orderapp_java.security.jwt.JwtAuthTokenFilter;
import com.ra.orderapp_java.security.jwt.JwtEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Autowired
    private JwtAuthTokenFilter jwtAuthTokenFilter;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf(AbstractHttpConfigurer::disable).
                authenticationProvider(authenticationProvider()).
                authorizeHttpRequests(auth->{
//                    auth.requestMatchers(HttpMethod.POST,"/api/v1/admin").hasAuthority("ADMIN");
//                    auth.requestMatchers("/api/v1/admin").hasAnyAuthority("ADMIN","SUB_ADMIN");
//                    auth.requestMatchers("/api/v1/cart").hasAuthority("USER");
//                    auth.requestMatchers("/api/v1/user","/api/v1/auth/**").permitAll();
                    auth.requestMatchers("/**").permitAll();
                }).sessionManagement(auth->auth.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(auth->auth.authenticationEntryPoint(jwtEntryPoint)
                        .accessDeniedHandler(customAccessDeniedHandler)).
                addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class).build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Cấu hình origins cho phù hợp với yêu cầu của bạn
        config.addAllowedHeader("*"); // Chấp nhận tất cả các header
        config.addAllowedMethod("*"); // Chấp nhận tất cả các phương thức HTTP
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }



//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("*"));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setAllowCredentials(false);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
