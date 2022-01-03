package com.ms.apigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private JwtTokenStore tokenStore;

    public static String[] publicRouters = { "/ms-auth/oauth/token" };
    public static String[] operatorRouters = { "/ms-worker/**" };
    public static String[] adminRouters = { "/ms-payroll/**", "/ms-user/**" };

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(publicRouters).permitAll()
                .antMatchers(HttpMethod.GET, operatorRouters).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(adminRouters).hasAnyRole("ADMIN")
                .anyRequest().authenticated();
    }

}
