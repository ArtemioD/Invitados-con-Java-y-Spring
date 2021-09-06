package com.invitados.dao;

import com.invitados.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona, Long> {
     
}
