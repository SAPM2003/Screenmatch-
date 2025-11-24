package Screenmatchproject;

import Screenmatchproject.model.DatosEpisodio;
import Screenmatchproject.model.DatosSerie;
import Screenmatchproject.model.DatosTemporadas;
import Screenmatchproject.principal.Principal;
import Screenmatchproject.service.ConsumoAPI;
import Screenmatchproject.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.muestraElMenu();


    }
}
