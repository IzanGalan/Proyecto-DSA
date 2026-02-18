package com.example.temple_run;

public class Usuario {
    //DATOS DE REGISTRO (WEB)
    private String nombre;
    private String password;
    private String email;
    private String telefono;

    //DATOS DEL JUEGO (temple run)
    private int nivel;
    private int ataque;
    private int defensa;
    private int resistencia;

    // CONSTRUCTOR: Se ejecuta cuando alguien se registra
    public Usuario(String nombre, String password, String email, String telefono) {
        // Guardamos los datos del formulario
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.telefono = telefono;

        // Inicializamos las estadísticas para un JUGADOR NUEVO (Nivel 1)
        this.nivel = 1;
        this.ataque = 10;      // Valor inicial ejemplo
        this.defensa = 5;      // Valor inicial ejemplo
        this.resistencia = 5;  // Valor inicial ejemplo
    }

    // GETTERS (Necesarios para que el sistema lea los datos)

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNivel() {
        return nivel;
    }

    //SETTERS (Por si necesitas cambiar algo, como subir de nivel)

    public void subirNivel() {
        this.nivel++;
        this.ataque += 2; // Al subir nivel, mejora el ataque
        this.defensa += 1;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + " | Nivel: " + nivel;
    }

}
