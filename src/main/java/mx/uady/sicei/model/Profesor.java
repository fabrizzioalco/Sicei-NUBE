package mx.uady.sicei.model;

import java.util.ArrayList;
import java.util.Random;
import javax.validation.constraints.*;

public class Profesor {

    @NotEmpty
    @NotNull
    private Long matricula; 
    @NotEmpty
    private String nombre;
    @NotNull
    private int horasDeClase;
    @NotEmpty
    @Email
    private String correo; 
    

    public Profesor(){
    }

    public Profesor(String nombre, String apellido, String correo){
        this.nombre = nombre;
        this.matricula = new Random().nextLong();
    }

    public int getHoras(){
        return this.horasDeClase;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public String getCorreo(){
        return this.correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setHoras(int horas){
        this.horasDeClase = horas;
    }
    public Long getMatricula(){
        return this.matricula;
    }

    
    @Override
    public String toString() {
        return "{" +
            " matricula='" + getMatricula() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", Horas de clase='" + getHoras() + "'"+
            ", Correo='" + getCorreo() + "'" +
            "}";
    }
}
