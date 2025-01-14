package com.aluracurso.desafio.principal;

import com.aluracurso.desafio.service.ConsumoAPI;
import com.aluracurso.desafio.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {

    private static final String URL_BASE = "http://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();


    public  void muestraElMenu(){
var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
    }
}
