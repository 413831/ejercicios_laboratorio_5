package utn.sistema.formulario.clases;

import java.util.Objects;

public class Persona
{
    private String nombre;
    private String apellido;
    private String dni;
    private String sexo;

    public Persona(String nombre, String apellido, String dni, String sexo)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString()
    {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nombre.equals(persona.nombre) && apellido.equals(persona.apellido) && dni.equals(persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, dni);
    }
}
