package com.example.ApiG46BD.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiG46BD.Modelos.UsuarioModelo;
import com.example.ApiG46BD.Repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    
    // instanciamos modelos de repository para usar
    @Autowired
    UsuarioRepositorio repositorio;

    // metodo guardar dato usuario despues de public se escribe que retorna el metodo, en el parentesis lo que recibe
    //retorna un usuario modelo y revibe un usurio modelo para almacenar en mongo
    // al objeto le llame usuario

    public UsuarioModelo guardaUsuario(UsuarioModelo usuario){
        //metodo pre hecho del repositorio que guarda los datos que manda el cliente del usuario
        return repositorio.save(usuario);
    }

    // metodo uque recopila y muestra todos los datos de los usuario en la base de datos 
    public ArrayList<UsuarioModelo> consultarUsuarios(){
        return (ArrayList<UsuarioModelo>) repositorio.findAll();
    }

    //metodo para buscar un susurio por documento
    public Optional<UsuarioModelo> consultarDocumento(Long documento){
        return repositorio.findById(documento);
    }

    //metodo para eliminar un usuario- returna un boolena , si elimino true sino elimino false
    public boolean eliminarUsuario(Long documento){
        if (repositorio.existsById(documento)){
            repositorio.deleteById(documento);
            return true;
        }
        else{
            return false;
        }
    }

    //metodo para filtrar por apellido
    public ArrayList<UsuarioModelo> buscarXapellido( String apellido){
        return repositorio.findByApellido(apellido);
    }

    //metodo para filtrar por apellido
    public ArrayList<UsuarioModelo> buscarXnombre( String nombre){
        return repositorio.findByNombre(nombre);
    }

    //metodo para filtrar por apellido
    public ArrayList<UsuarioModelo> buscarXcorreo( String correo){
        return repositorio.findByCorreo(correo);
    }
}


//min38