package utn.sistema.mvc;

import android.app.Activity;

public class Modelo
{
    private String nombre;
    private String apellido;
    private Integer dni;
    private Boolean sexo;

    public Modelo()
    {
    }

    public Modelo(String nombre, String apellido, Integer dni, Boolean sexo)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Modelo{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", dni=").append(dni);
        sb.append(", sexo=").append(sexo);
        sb.append('}');
        return sb.toString();
    }
}
