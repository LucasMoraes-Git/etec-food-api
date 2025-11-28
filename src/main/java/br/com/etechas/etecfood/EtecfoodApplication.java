package br.com.etechas.etecfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Classe principal da aplicação Spring Boot
// Responsável por inicializar o contexto do Spring e iniciar o servidor
@SpringBootApplication
public class EtecfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtecfoodApplication.class, args);
	}

}
