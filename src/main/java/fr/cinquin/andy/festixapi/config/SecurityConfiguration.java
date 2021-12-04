package fr.cinquin.andy.festixapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private Environment env;

    public SecurityConfiguration(){
        super();
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.authorizeRequests()
//                Base requests
                .antMatchers("/").permitAll()
//                Artist
                .antMatchers("/artist/get/*/","/artist/list/").permitAll()
//                Festival
                .antMatchers("/festival/get/*/","/festival/list/").permitAll()
//                Event
                .antMatchers("/event/get/*/","/event/list/").permitAll()
//                Toutes les autres requêtes sont privées & nécessite une authentification
//                Admin
                .antMatchers("/admin/get/*/","/admin/list/").permitAll()
                .anyRequest().authenticated();

        http.csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

        http.logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        if( this.env.acceptsProfiles(Profiles.of("local"))){
//            web.ignoring().antMatchers("/v3/api-docs/**","/swagger-ui.html","/swagger-ui/**");
//        }
//    }
}
