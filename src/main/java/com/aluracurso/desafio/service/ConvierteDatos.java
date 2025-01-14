package com.aluracurso.desafio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParseException;

public class ConvierteDatos  implements IConvertirDatos{
private ObjectMapper mapper = new ObjectMapper();
//para usar jakson se importa en el pom.mx
 @Override
 public  <T> T obtnerDatos(String json, Class <T> clase) {
     try {
         return mapper.readValue(json.toString(), clase);
     } catch (JsonMappingException e) {
         throw new RuntimeException(e);
     } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
     }


 }


}
