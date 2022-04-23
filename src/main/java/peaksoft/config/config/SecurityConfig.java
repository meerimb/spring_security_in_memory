package peaksoft.config.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder user=User. withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(user.username("zamira").password("zamira").roles("Manager"))
                .withUser(user.username("nurlan").password("nurlan").roles("Student"))
                .withUser(user.username("venera").password("venera").roles("Manager","HR"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/")
                .hasAnyRole("Manager","Student","HR")
                .antMatchers("/hr-info").hasRole("HR")
                .antMatchers("/manager-info").hasRole("Manager")
                .and().formLogin().permitAll();
    }
}
