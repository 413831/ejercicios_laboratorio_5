package utn.sistema.practica_primer_parcial.clases;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Controlador implements View.OnClickListener
{
    private Usuario usuario;
    private Vista vista;
    private Activity activity;
    private List<Usuario> usuarios;
    private static Controlador controlador;
    private int indice;

    private Controlador()
    {
        this.usuarios = this.mockUsuarios();
    }

    public static Controlador getInstance()
    {
        if(Controlador.controlador == null)
        {
            Controlador.controlador = new Controlador();
        }
        return Controlador.controlador;
    }

    @Override
    public void onClick(View v)
    {
        if(Controlador.controlador.validarDatos())
        {
            Controlador.controlador.vista.cargarModelo();
            Controlador.controlador.usuarios.set(Controlador.controlador.indice,Controlador.controlador.usuario);

            Log.d("Usuario actualizado", Controlador.controlador.usuarios.get(Controlador.controlador.indice).toString());

            // Termino la actividad
            Controlador.controlador.activity.finish();
        }
    }

    private boolean validarDatos()
    {
        String mensaje = "";
        String pass = Controlador.controlador.vista.edContrasenia.getText().toString();
        String confirmacion = Controlador.controlador.vista.edConfirmacion.getText().toString();

        if(pass.equals(confirmacion) && Controlador.controlador.vista.edNombre.getText().length() >= 3)
        {
            return true;
        }
        else
        {
            if(Locale.getDefault().getLanguage() == new Locale("en").getLanguage())
            {
                mensaje = "Please check your password, enter an user name with least 3 characters";
            }
            else if(Locale.getDefault().getLanguage() == new Locale("es").getLanguage())
            {
                mensaje = "Por favor revise su contraseña, ingrese un nombre con al menos 3 caracteres";
            }
            Controlador.controlador.vista.mostrarMensaje(mensaje);
            return false;
        }
    }

    private List<Usuario> mockUsuarios()
    {
        List<Usuario> mockUsuarios = new ArrayList<>();

        mockUsuarios.add(new Usuario("Pepito","SARASA", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Manuela","SARASA", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Jose","MELON1235", TipoUsuario.ADMINISTRADOR));
        mockUsuarios.add(new Usuario("Josefina","OBELISCO99", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Francisco","MosTaZa12", TipoUsuario.ADMINISTRADOR));
        mockUsuarios.add(new Usuario("Hermeneguildo","FONTANARROSA", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Mustafa","LOSNUEVELADRONES", TipoUsuario.ADMINISTRADOR));
        mockUsuarios.add(new Usuario("Beatriz","LAZARO1235", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Mirtha","HIGHLANDER99", TipoUsuario.USUARIO));

        return mockUsuarios;
    }

    public Usuario getUsuario(int indice) {
        return Controlador.controlador.usuarios.get(indice);
    }

    public void setUsuario(Usuario usuario) {
        Controlador.controlador.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return Controlador.controlador.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        Controlador.controlador.usuarios = usuarios;
    }

    public void setVista(Vista vista) {
        Controlador.controlador.vista = vista;
    }

    public void setActivity(Activity activity) {
        Controlador.controlador.activity = activity;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }


}
