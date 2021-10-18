package utn.sistema.practica_primer_parcial.listeners;

import android.app.Activity;
import android.view.View;

import java.util.List;

import utn.sistema.practica_primer_parcial.clases.Usuario;

public class ClickGuardar implements View.OnClickListener
{
    List<Usuario> usuarios;
    Usuario usuario;
    int posicion;

    public ClickGuardar(List<Usuario> usuarios)
    {
        this.usuarios = usuarios;
    }

    @Override
    public void onClick(View v)
    {

    }

    public List<Usuario> getUsuarios()
    {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios)
    {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public int getPosicion()
    {
        return posicion;
    }

    public void setPosicion(int posicion)
    {
        this.posicion = posicion;
    }
}
