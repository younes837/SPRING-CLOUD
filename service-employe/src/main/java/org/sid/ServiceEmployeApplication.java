package org.sid;

import org.sid.dao.EmployeRepository;
import org.sid.entities.Employe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceEmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEmployeApplication.class, args);
	}
	@Bean
	CommandLineRunner start(EmployeRepository companyRepository){
		return  args -> {
			Stream.of("Youness","Ahmed","Houssam").forEach(cn->{
				companyRepository.save(new Employe(null,cn,Math.floor(10000+Math.random()*900)));
			});
			companyRepository.findAll().forEach(System.out::println);
		};
	}

}
