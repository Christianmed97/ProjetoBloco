package br.edu.infnet.AppChristian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppChristianApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppChristianApplication.class, args);
	}

}
