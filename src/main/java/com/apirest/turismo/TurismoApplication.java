package com.apirest.turismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Turismo API.
 *
 * Esta clase inicia la aplicación Spring Boot.
 *
 */
@SpringBootApplication
public class TurismoApplication {
	/**
	 * Método principal que arranca la aplicación.
	 *
	 * @param args argumentos de la línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(TurismoApplication.class, args);
	}
}

