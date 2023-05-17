package com.liuzhuo.config;

import com.liuzhuo.common.security.*;
import com.liuzhuo.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity // 开启Spring Security的功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 登录失败之后的 处理器
     */
    @Resource
    private LoginFailureHandler loginFailureHandler;

    /**
     * 权限不足的 处理器
     */
    @Resource
    private CustomerAccessDeniedHandler customerAccessDeniedHandler;

    /**
     * 未登录访问受限资源的 处理器
     */
    @Resource
    private AnonymousAuthenticationHandler anonymousAuthenticationHandler;

    /**
     * 自定义验证用户名密码服务
     */
    @Resource
    private UserDetailsServiceImpl userDetailsService;

    /**
     * 自定义token验证过滤器
     */
    @Resource
    private CheckTokenFilter checkTokenFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(

                "favicon.ico",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/v2/api-docs/**"
        );
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //登录前进行过滤
        http.formLogin()
                .failureHandler(loginFailureHandler)
                // 禁用csrf防御机制
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/user/login").permitAll() // 登录接口放行
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(anonymousAuthenticationHandler)
                .accessDeniedHandler(customerAccessDeniedHandler)
                .and().cors();//开启跨域配置

        // 开启token验证
        http.addFilterBefore(checkTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }


    /**
     * 配置认证处理器
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
