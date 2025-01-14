package com.aluracurso.desafio;

import com.aluracurso.desafio.model.Datos;
import com.aluracurso.desafio.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	// Inyectamos la clase Principal para que Spring la maneje

	public static void main(String[] args) {
		// Arrancamos la aplicación Spring Boot
		SpringApplication.run(DesafioApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	Principal principal = new Principal();
		principal.muestraElMenu();
	}





}
