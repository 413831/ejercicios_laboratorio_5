package utn.sistema.parcialUnoLabV.clases;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.Locale;

import utn.sistema.parcialUnoLabV.Objeto;

public class Controlador implements View.OnClickListener
{
    private Objeto objeto;
    private Vista vista;
    private Activity activity;
    private List<Objeto> objetos;
    private static Controlador controlador;
    private int indice;

    private Controlador()
    {
        this.objetos = this.mockObjetos();
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
            Controlador.controlador.objetos.set(Controlador.controlador.indice,Controlador.controlador.objeto);

            Log.d("Objeto actualizado", Controlador.controlador.objetos.get(Controlador.controlador.indice).toString());

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

    private List<Objeto> mockObjetos()
    {
        /*
        List<Objeto> mockObjetos = new ArrayList<>();

        mockObjetos.add(new Objeto("Pepito","SARASA", TipoObjeto.USUARIO));
        mockObjetos.add(new Objeto("Manuela","SARASA", TipoObjeto.USUARIO));
        mockObjetos.add(new Objeto("Jose","MELON1235", TipoObjeto.ADMINISTRADOR));
        mockObjetos.add(new Objeto("Josefina","OBELISCO99", TipoObjeto.USUARIO));
        mockObjetos.add(new Objeto("Francisco","MosTaZa12", TipoObjeto.ADMINISTRADOR));
        mockObjetos.add(new Objeto("Hermeneguildo","FONTANARROSA", TipoObjeto.USUARIO));
        mockObjetos.add(new Objeto("Mustafa","LOSNUEVELADRONES", TipoObjeto.ADMINISTRADOR));
        mockObjetos.add(new Objeto("Beatriz","LAZARO1235", TipoObjeto.USUARIO));
        mockObjetos.add(new Objeto("Mirtha","HIGHLANDER99", TipoObjeto.USUARIO));

        return mockObjetos;

         */
        return null;
    }

    public Objeto getObjeto(int indice) {
        return Controlador.controlador.objetos.get(indice);
    }

    public void setObjeto(Objeto objeto) {
        Controlador.controlador.objeto = objeto;
    }

    public List<Objeto> getObjetos() {
        return Controlador.controlador.objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        Controlador.controlador.objetos = objetos;
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
