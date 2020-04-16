package com.song;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableHasor()
@EnableHasorWeb()
@SpringBootApplication(scanBasePackages = { "com.song.hasor" })
public class DatawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatawayApplication.class, args);
	}

}
