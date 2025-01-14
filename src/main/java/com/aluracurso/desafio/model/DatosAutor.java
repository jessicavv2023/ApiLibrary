package com.aluracurso.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
@JsonIgnoreProperties (ignoreUnknown = true)

public record DatosAutor(

        @JsonAlias ("name") String autor,
        @JsonAlias ("birth_year") String fechaNacimiento


        ) {
}
