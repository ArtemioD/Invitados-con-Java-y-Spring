package com.invitados.servicio;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import com.invitados.dao.IUsuarioDao;
import com.invitados.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {

    @Autowired
    private IUsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // recuperamos el usuario filtrado por username
        Usuario usuario = usuarioDao.findByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        // recuperamos los roles del usuario
        var roles = new ArrayList<GrantedAuthority>();
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        // return el objeto con los parametros recuperados
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}