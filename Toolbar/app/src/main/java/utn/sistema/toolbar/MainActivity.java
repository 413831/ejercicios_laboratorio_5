package utn.sistema.toolbar;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);

        String nombre = preferences.getString("nombre", "sin nombre");

        if(!nombre.equals("sin nombre"))
        {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(nombre);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == R.id.opt1)
        {
            // Shared Preferences
            SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre", "Pepito");
            editor.commit();

            // Intents
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+54954354353"));
            if( ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED)
            {
                startActivity(callIntent);
            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE},0);
            }
        }
        else if(item.getItemId() == R.id.itPopup)
        {
            PopUpGenerico popUpGenerico = new PopUpGenerico();
            popUpGenerico.show(getSupportFragmentManager(), "tag");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.itBuscador);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("onQueryTextListener", query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("onQueryTextSubmit", newText);
        return false;
    }
}