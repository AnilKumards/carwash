package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
@SpringBootApplication
public class CarwashApplication  {
	
	/*@Autowired
	private CustomerRepository customerRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(CarwashApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}/*
	 @Bean
	    public Docket swaggerConfiguration() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .paths(PathSelectors.ant("/api/*"))
	                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
	                .build();

/*	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Customer c1=new Customer("111","akshay","kumar","akshay@gmail.com","akshay","11111111");
		Customer c2=new Customer("222","arsv","kfd","arsv@gmail.com","arsv","22222222");
		Customer c3=new Customer("333","arun","khar","arun@gmail.com","arun","333333333");
		Customer c4=new Customer("444","varun","ka","varun@gmail.com","varun","444444444");
		
		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);
		customerRepository.save(c4);
		
		System.out.println("****************");
		
		List<Customer> customers=customerRepository.findAll();
		for(Customer c:customers)
			System.out.println(c.toString());
	}*/
	 }

