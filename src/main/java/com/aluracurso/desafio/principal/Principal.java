package com.aluracurso.desafio.principal;

import com.aluracurso.desafio.model.Datos;
import com.aluracurso.desafio.model.DatosLibro;
import com.aluracurso.desafio.service.ConsumoAPI;
import com.aluracurso.desafio.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private static final String URL_BASE = "http://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    private  Scanner teclado = new Scanner(System.in);

    public  void muestraElMenu(){
var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);

        var datos = convierteDatos.obtnerDatos(json, Datos.class);
        System.out.println( "Es de tipo ConvierteDatos" + datos);


        // Top 10 de libros
        System.out.println("TOP 10 de Libros");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibro::numerDescargas ).reversed())
                .limit(10)
                .forEach(System.out::println);


// Busqueda de lisbros por nombre
        System.out.println("Ingrese el titulo del libro que desea buscar ");
       var tituloLibro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE + "?" + tituloLibro.replace(" ", "+"));
        var datosBusqueda =convierteDatos.obtnerDatos(json, Datos.class);
        Optional <DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                        .filter( l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                         .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("libro encontrado.");
        System.out.println(libroBuscado.get());
        } else  {
        System.out.println("libro no encontrado");
    }

        //Estadisticas
        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d -> d.numerDescargas() >0 )
                .collect(Collectors.summarizingDouble(DatosLibro::numerDescargas));
        System.out.println( " Cantidad media de Descargas " + est.getAverage());
        System.out.println(" Minimo de descaras " + est.getMin());




    }
}
