package com.efi.scrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.efi.scrapper.scrapp.SagaScrapper;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ScrapperEfiApplication  implements CommandLineRunner{

	@Autowired SagaScrapper scrapperService;
	
	public static void main(String[] args) {
		SpringApplication.run(ScrapperEfiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		scrapperService.scraping();
	}

}
