
package com.invitados.servicio;

import com.invitados.dao.IPersonaDao;
import com.invitados.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaSetviceImp implements IPersonaService {
    
    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true) // solo lectura
    public List<Persona> listarPersona() {
        return (List<Persona>) personaDao.findAll(); 
        /* metodo findAll() de personaDao de interfce JpaRepository 
        para recuperar a todos los objetos de tipo persona de BBDD */
    }

    @Override
    @Transactional // hace commit o rollback
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional // hace commit o rollback
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true) // solo lectura
    public Persona econtrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null); 
        // si no encuentra devuelve un null
    }
    
}
