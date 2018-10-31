package com.bobby.springjokes;

import com.bobby.springjokes.chuck.Joke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class SpringJokesApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringJokesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringJokesApplication.class);
    }

		@Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder){
			return builder.build();
		}

		@Bean
		public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
			return args -> {
				Joke joke = restTemplate.getForObject("http://api.icndb.com/jokes/random", Joke.class);
				log.info(joke.toString());
			};
		}
	}
