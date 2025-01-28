package com.example.Server;

import com.example.Server.db.MessageService;
import com.example.Server.db.MessageServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
/**
 * Точка запуска приложения
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class ServerApplication {
	@Bean
	public MessageService messageService() {
		return new MessageServiceImpl();
	}
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
