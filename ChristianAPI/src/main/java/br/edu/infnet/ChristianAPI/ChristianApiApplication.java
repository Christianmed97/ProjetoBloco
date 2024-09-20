package br.edu.infnet.ChristianAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChristianApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChristianApiApplication.class, args);
	}

}
