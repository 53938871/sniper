package com.bangduoduo;

import com.bangduoduo.monkey.ApplicationContextProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonkeyApplication {



	public static void main(String[] args) {
		SpringApplication.run(MonkeyApplication.class, args);
	}
}
