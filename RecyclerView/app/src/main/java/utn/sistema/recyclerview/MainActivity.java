package utn.sistema.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.*;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static final int PERSONAS = 1;
    public static final int IMAGEN = 2;
    List<Persona> personas;
    PersonaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.personas = new ArrayList<>();
        this.adapter = new PersonaAdapter(this.personas);

        ActionBar actionBar = getSupportActionBar();

        TextView textView = findViewById(R.id.sa);

        actionBar.setTitle("Segunda activity");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Handler handler = new Handler(this);
        MiConsulta consulta = new MiConsulta(handler, true);
        consulta.start();
        MiConsulta consultaImagen = new MiConsulta(handler,false);
        consultaImagen.start();

        personas.add(new Persona("nombre1", "apellido1"));
        personas.add(new Persona("nombre2", "apellido2"));
        personas.add(new Persona("nombre3", "apellido3"));

        RecyclerView recyclerView = super.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                                                                            LinearLayoutManager.VERTICAL,
                                                                            false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean handleMessage(@NonNull Message msg)
    {
        if(msg.arg1 == PERSONAS)
        {
            // Una accion
            TextView textView = findViewById(R.id.txt);

            try
            {
                JSONArray lista = new JSONArray(msg.obj.toString());

                for (int i = 0; i < lista.length(); i++)
                {
                    JSONObject personaJSON = lista.getJSONObject(i);
                    String nombre = personaJSON.getString("nombre");
                    String apellido = personaJSON.getString("apellido");
                    Persona persona = new Persona(nombre, apellido);
                    /** TODO
                     * Recuperar imagen de forma asíncrona
                     */
                    personas.add(persona);
                }
                adapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }
            textView.setText(msg.obj.toString());

        }
        else if(msg.arg1 == IMAGEN)
        {
            ImageView imageView = findViewById(R.id.imageView);

            byte[] imagen = (byte[]) msg.obj;
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(imagen,0,imagen.length));
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.opcion1:
                Log.d("Opcion 1", "Se hizo click en opcion 1");
                break;
            case R.id.opcion2:
                Log.d("Opcion 2", "Se hizo click en opcion 2");
                Intent intent = new Intent(this, CargarPersona.class);

                intent.putExtra("numero", 123);
                startActivity(intent);

                break;
            case R.id.opcion3:
                Log.d("Opcion 3", "Se hizo click en opcion 3");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}