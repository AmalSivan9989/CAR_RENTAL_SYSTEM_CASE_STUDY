package com.hexa.car.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("amal").password("amal123").roles("ADMIN")
            .and()
            .withUser("eddy").password("eddy123").roles("CUSTOMER");
    }
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .httpBasic()
	            .and()
	            .authorizeRequests()

	         
	                .antMatchers("/addVehicle", "/deleteVehicle/*").hasRole("ADMIN") 
	                .antMatchers("/showAllVehicles", "/searchById/*", "/searchByVehicleType/*", "/searchByTypeAndModel/*")
	                    .hasAnyRole("ADMIN", "CUSTOMER") 

	                .antMatchers("/addCustomer", "/login/*", "/searchByCustId/*", "/searchByCustomerName/*", "/showCustomer")
	                    .hasAnyRole("ADMIN", "CUSTOMER")

	            
	                .anyRequest().authenticated()

	            .and()
	            .formLogin()
	            .and()
	            .csrf().disable();
	        }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return NoOpPasswordEncoder.getInstance(); // For demo only
	    }
	}

