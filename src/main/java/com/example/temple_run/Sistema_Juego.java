package com.example.temple_run;

import java.util.HashMap;
import java.util.Map;

public class Sistema_Juego {
    // Aquí guardamos los usuarios.
    private Map<String, Usuario> usuariosBD = new HashMap<>();

    public boolean crearUsuario(Usuario u) {
        // Consultamos si el nombre ya existe en el mapa
        if (usuariosBD.containsKey(u.getNombre())) {
            return false; // Error: Ya existe
        }

        // Si no existe, lo guardamos
        usuariosBD.put(u.getNombre(), u);
        return true; // Ok
    }

    public Usuario consultarUsuario(String nombre) {
        return usuariosBD.get(nombre); // Devuelve el usuario o null si no existe
    }

}
