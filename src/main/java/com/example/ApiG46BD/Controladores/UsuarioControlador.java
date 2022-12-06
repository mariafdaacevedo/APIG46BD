package com.example.ApiG46BD.Controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiG46BD.Modelos.UsuarioModelo;
import com.example.ApiG46BD.Servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
//http://localhost:8080/usuario
public class UsuarioControlador {
    @Autowired
    UsuarioServicio servicio;


    @PostMapping("/guardar")
    //http://localhost:8080/usuario/guardar
    // metodo que reciba los datos para guardarlos
    public UsuarioModelo guardaUsuario(@RequestBody UsuarioModelo usuario){
        return servicio.guardaUsuario(usuario);
    }

    @GetMapping("/consultar")
    //http://localhost:8080/usuario/consultar
    // metodo que nos da la lista de usuarios guardados 
    public ArrayList<UsuarioModelo> consultaUsuarios(){
        return servicio.consultarUsuarios();
    }

    @GetMapping("/consultardocumento/{documento}")
    //http://localhost:8080/usuario/consultardocumento/123345
    public Optional<UsuarioModelo> consultarDocumento(@PathVariable("documento") Long documento){
        return servicio.consultarDocumento(documento);
    }

    @DeleteMapping("/eliminar/{documento}")
    //http://localhost:8080/usuario/eliminar/123345
    public boolean eliminarUsuario(@PathVariable Long documento){
        return servicio.eliminarUsuario(documento);
    }

    @GetMapping("/filtrarxapellido/{apellido}")
    //http://localhost:8080/usuario/filtrarxapellido/acevedo
    public ArrayList<UsuarioModelo> filtrarXapellido(@PathVariable("apellido") String apellido){
        return servicio.buscarXapellido(apellido);
    }

    @GetMapping("/filtrarxnombre/{nombre}")
    //http://localhost:8080/usuario/filtrarxnombre/maria
    public ArrayList<UsuarioModelo> filtrarXnombre(@PathVariable("nombre") String nombre){
        return servicio.buscarXnombre(nombre);
    }

    @GetMapping("/filtrarxcorreo/{correo}")
    //http://localhost:8080/usuario/filtrarxacorreo/carlos@gmail.com
    public ArrayList<UsuarioModelo> filtrarXcorreo(@PathVariable("correo") String correo){
        return servicio.buscarXcorreo(correo);
    }
}
