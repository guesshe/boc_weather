package com.boc.test.weather.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration()
@EnableWebMvc()
@EnableWebSecurity()
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     * http config for URL /weatherstations/
     */
    @Configuration
    @Order(1) // In case there is another config to load
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {

        private static final String MATCHER_URL = "/dummy/**";

        /**
         * This method configures http url mapping, session management and filter chain
         * Modify stati final variable MATCHER_URL to other values like "dummy" to skip authorization
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/")
                    .permitAll()
                    .and()
                    .authorizeRequests()
                    .antMatchers(MATCHER_URL)
                    .fullyAuthenticated()
                    .and()
                    .csrf()
                    .disable()
                    .cors();
            // For h2 db console access
            http.headers().frameOptions().disable();
        }
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/h2-console/**");
        web.ignoring().antMatchers("/detail/**");
    }
}
