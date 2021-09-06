package com.invitados.servicio;

import com.invitados.domain.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> listarPersona();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona econtrarPersona(Persona persona);
    
    /*
    Podemos agregar mas metodos si necesitamos.
    Son basicos para CRUD = Create, Read, Update, Delete
    */
    
}
