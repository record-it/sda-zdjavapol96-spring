package pl.sda.springproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.springproject.service.UserAppService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserAppService userAppService;

    public SecurityConfiguration(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/book/vote").authenticated()
                .antMatchers("/book/add", "/book/vote").authenticated()
                .antMatchers("/car/**").hasRole("ADMIN")
                .antMatchers("/power").anonymous()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("ewa").password("$2a$12$f.EW5Zs49ExVkQs33u0O3.MBvienwh3Vn0nPe5BI7IR4XBhRUNrnC").roles("USER")
//                .and()
//                .withUser("adam").password("$2a$12$f.EW5Zs49ExVkQs33u0O3.MBvienwh3Vn0nPe5BI7IR4XBhRUNrnC").roles("ADMIN")
//                .and()
//                .passwordEncoder(passwordEncoder());
        auth
                .userDetailsService(userAppService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
