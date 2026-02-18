package com.example.temple_run;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
public class Controlador_web {
    private Sistema_Juego sistema = new Sistema_Juego();

    // 1. Recibe los datos del REGISTRO desde la web
    @PostMapping("/api/registro")
    public String registrar(@RequestBody Map<String, String> datos) {
        // Sacamos los datos del JSON que envía la web
        String nombre = datos.get("nombre");
        String pass = datos.get("password");
        String email = datos.get("email");
        String telf = datos.get("telefono");

        // Creamos el nuevo usuario
        Usuario nuevo = new Usuario(nombre, pass, email, telf);

        // Intentamos guardarlo en el sistema
        if (sistema.crearUsuario(nuevo)) {
            return "OK";
        } else {
            return "ERROR: Ese nombre de usuario ya está cogido.";
        }
    }
    // 2. Recibe los datos del LOGIN desde la web
    @PostMapping("/api/login")
    public String login(@RequestBody Map<String, String> datos) {
        String nombre = datos.get("nombre");
        String pass = datos.get("password");

        // Buscamos al usuario
        Usuario u = sistema.consultarUsuario(nombre);

        // Verificamos: 1) Que el usuario exista Y 2) Que la contraseña coincida
        if (u != null && u.getPassword().equals(pass)) {
            return "OK";
        }
        return "ERROR: Usuario o contraseña incorrectos.";
    }
}

