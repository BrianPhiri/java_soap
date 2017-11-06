package com.brianphiri.soapConsume;

import hello.wsdl.Country;
import hello.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapConsumeApplication.class, args);

	}

	@Bean
	CommandLineRunner lookup(CountryClient countryClient){
		return args -> {
			String name = "Kenya";
			if (args.length > 0){
				name = args[0];
			}
			GetCountryResponse response = countryClient.getCountryResponse(name);
			Country countryResponse = response.getCountry();
			System.err.println(
					" Name : "+countryResponse.getName()+
							"\n Capital : "+countryResponse.getCapital()+
							"\n Population : "+countryResponse.getPopulation()+
							"\n Currency : "+countryResponse.getCurrency()
			);

		};
	}
}
