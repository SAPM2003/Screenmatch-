package Screenmatchproject.principal;

import Screenmatchproject.model.DatosSerie;
import Screenmatchproject.model.DatosTemporadas;
import Screenmatchproject.service.ConsumoAPI;
import Screenmatchproject.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=7a3079be";
    private ConvierteDatos conversor = new ConvierteDatos();


    public void muestraElMenu() {
        // Busca los datos generales de las series
        System.out.println("Por favor escribe el nombre de la serie que deseas buscar: ");
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE+ nombreSerie.replace(" ","+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);
        //Busca los datos de todas las temporadas

        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
            json = consumoApi.obtenerDatos(URL_BASE+ nombreSerie.replace(" ", "+")+ "&season="+i+"&apikey=7a3079be");
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);

        }
        temporadas.forEach(System.out::println);
    }
}
