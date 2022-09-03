package com.debasish.Rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestApplication {

	private static final Logger log = LoggerFactory.getLogger(RestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Autowired
	Repository repository;
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Result result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/2", Result.class);
			log.info("==== RESTful API Response using Spring RESTTemplate START =======");
			log.info(result.toString());
			log.info("==== RESTful API Response using Spring RESTTemplate END =======");

			ResponseEntity<Result> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/3", Result.class);
			Result entity = response.getBody();
			log.info(entity.toString());

			repository.save(entity);

		};

	}
}



