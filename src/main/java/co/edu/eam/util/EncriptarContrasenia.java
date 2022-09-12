package co.edu.eam.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarContrasenia {
    public static void main(String[] args) {
        var pass = "docente";
        System.out.println("Contraseña encriptada: " + encriptar(pass));
    }

    public static String encriptar(String pass){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(pass);
    }
}
