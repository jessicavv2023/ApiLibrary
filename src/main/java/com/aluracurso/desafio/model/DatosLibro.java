package com.aluracurso.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(@JsonAlias("title") String titulo,
                         @JsonAlias("id") int id,
                       @JsonAlias("authors")  List  <DatosAutor> autor,

                         @JsonAlias("download_count") double numerDescargas) {
}
