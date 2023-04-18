package ma.enset.hospitalapp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//au niveau du controller cest a nous de protger les methodes directement avec lannotation @preauthorized
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;

    /*preciser en memoire les utilisateurs qui on le droit dacceder a lapp*/
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("USER","ADMIN").build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        /*lauthentification renvoie vers /login , permitall pour tout le monde*/
        httpSecurity.formLogin().loginPage("/login").permitAll();

        /*la case a cocher*/
        httpSecurity.rememberMe();

        /* toute les ressources necessite docn je ne peux pas avoir meme bootstrap, meme pour h2 si on est en train de lutiliser*/
        httpSecurity.authorizeHttpRequests().requestMatchers("webjars/**","/h2-console/**").permitAll();

        /*toute les requetes http dans le path contient user/qlqchose necessite davoire le role user */
        //httpSecurity.authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER");
        //httpSecurity.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN");



        /*toute les requetes necessite une authentification*/
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();

        /*si je tente d'acceder a une ressource dont jai pas le droit la redirection se fait vers /notauthorized*/
        httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");

        return httpSecurity.build();
    }
}