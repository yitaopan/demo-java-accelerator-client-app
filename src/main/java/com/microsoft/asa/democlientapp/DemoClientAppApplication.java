package com.microsoft.asa.democlientapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoClientAppApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoClientAppApplication.class, args);
	}

}
