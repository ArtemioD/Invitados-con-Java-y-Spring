package com.invitados.web;

import com.invitados.domain.Persona;
import com.invitados.servicio.IPersonaService;
import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controlador {
    
    @Autowired
    private IPersonaService pService;
    
    @GetMapping("/") // el objeto persona es para uasr en index
    public String inicio(Model model, Persona perosna) {
        //List<Persona> personas = test();
        List<Persona> personas = pService.listarPersona();
        model.addAttribute("personas", personas);
        model.addAttribute("fecha", fecha());
        return "index";
    }
    
    @GetMapping("/agregar") // spring inyecta Prsona de forma automatica 
    public String agregar(@Valid Persona persona, Errors error) { 
        if (error.hasErrors()) {
            return "redirect:/";
        }
        pService.guardar(persona);
        return "redirect:/"; // redirect a la pagina de inicio
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona) {
        pService.eliminar(persona);
        return "redirect:/";
    }
    
    private String fecha() {
        Calendar cal = Calendar.getInstance();
        //System.out.println("The Current Year is:" + cal.get(Calendar.YEAR));
        return "" + cal.get(Calendar.YEAR);
    }
    
    private List test() {
        Persona persona1 = new Persona();
        persona1.setNombre("Juan");
        
        Persona persona2 = new Persona();
        persona2.setNombre("Alma");
        
        Persona persona3 = new Persona();
        persona3.setNombre("Marco Antonio");
        
        return Arrays.asList(persona1, persona2, persona3);
    }
    
}
