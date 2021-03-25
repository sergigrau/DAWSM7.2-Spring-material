package edu.fje.daw2.m07;

import edu.fje.daw2.m07.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
public class M07Application {

	public static void main(String[] args) {
		SpringApplication.run(M07Application.class, args);
	}

    /**
     * Classe principal d'Spring
     * utilitza un microservei per accedir a MongoDB.
     * A més realitza una càrrega inicial de dades
     * @author sergi.grau@fje.edu
     * @version  1.0 4.4.2019
     */
    @SpringBootApplication
    @RestController
    public static class M07uf2Application implements CommandLineRunner {


        @Autowired
        private ClientRepositori repositori;

        public static void main(String[] args) {
            SpringApplication.run(M07uf2Application.class, args);
        }

        @RequestMapping(value = "/user")
        public Principal user(Principal principal) {
            return principal;
        }

        @Override
        public void run(String... args) throws Exception {

            repositori.deleteAll();

            repositori.save(new Client("Sergi", "Grau", 1000));
            repositori.save(new Client("Joan", "Grau", 2000));

            for (Client c : repositori.findAll()) {
                System.out.println(c);
            }
            System.out.println();
            System.out.println(repositori.findByCognom("Sergi"));

            for (Client c : repositori.findByCognom("Grau")) {
                System.out.println(c);
            }

        }
    }
}
