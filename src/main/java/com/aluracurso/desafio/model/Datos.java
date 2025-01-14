package com.aluracurso.desafio.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        //estos son datos generales
       @JsonAlias("results") List  <DatosLibro> resultados

) {
}
