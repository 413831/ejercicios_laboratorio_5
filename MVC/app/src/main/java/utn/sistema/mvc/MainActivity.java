package utn.sistema.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * 1 - Aplicar patrón MVC
 * 2 - Crear nuevo XML String para multi-idiomas
 * 3 - Crear nuevo XML de Layout diferente para posición Landscape
 * 4 - Documentar con JAVADOC
 * 4 - Documentar con JAVADOC
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Modelo modelo = new Modelo();
        Vista vista = new Vista(modelo, this);
        Controlador controlador = new Controlador(modelo, vista, this);
        vista.setControlador(controlador);
    }
}