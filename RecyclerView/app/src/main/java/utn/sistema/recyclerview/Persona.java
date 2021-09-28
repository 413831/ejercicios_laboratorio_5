package utn.sistema.recyclerview;

import java.util.Objects;

public class Persona
{
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido)
    {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return getNombre().equals(persona.getNombre()) && getApellido().equals(persona.getApellido());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getApellido());
    }
}
