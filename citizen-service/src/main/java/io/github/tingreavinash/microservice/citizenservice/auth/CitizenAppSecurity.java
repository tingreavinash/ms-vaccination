package io.github.tingreavinash.microservice.citizenservice.auth;

import io.github.tingreavinash.microservice.citizenservice.entity.MyUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity
public class CitizenAppSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/citizen/getAllCitizens").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                MyUserDetails myUserDetails = new MyUserDetails();

                //Load these below user details from actual source
                myUserDetails.setUsername("avinash");
                myUserDetails.setPassword("$2a$16$wArRCYvU6D3CkfTeAIimDuJMzMMC2PWrh18yhp78UtIjZVEB73.nG");
                myUserDetails.setEnabled(true);
                myUserDetails.setAccountNonExpired(true);
                myUserDetails.setCredentialsNonExpired(true);
                myUserDetails.setAccountNonLocked(true);
                return myUserDetails;
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(16);
    }
}
