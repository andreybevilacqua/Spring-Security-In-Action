package abevilacqua.formbasedloginapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationSuccessHandler successHandler;
    private final CustomAuthenticationFailureHandler failureHandler;

    public ProjectConfig(CustomAuthenticationSuccessHandler successHandler,
                         CustomAuthenticationFailureHandler failureHandler) {
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .successHandler(successHandler)
            .failureHandler(failureHandler)
            .and()
            .httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
