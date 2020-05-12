package com.steven.majek;

import com.steven.majek.bean.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.steven.majek.bean")
@EnableJpaRepositories("com.steven.majek.repo")
public class VintedApplication {

	public static void main(String[] args) {
		SpringApplication.run(VintedApplication.class, args);
		Usuario usuario = new Usuario();
	}

}
