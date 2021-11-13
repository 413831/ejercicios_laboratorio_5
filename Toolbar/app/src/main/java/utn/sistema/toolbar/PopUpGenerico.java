package utn.sistema.toolbar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class PopUpGenerico extends AppCompatDialogFragment
{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Titulo");
        builder.setMessage("Mensaje!!!");
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel", null);
        builder.setNeutralButton("Info", null);


        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View v = layoutInflater.inflate(R.layout.dialog,null);
        Button btn = v.findViewById(R.id.btn);

        //builder.setView(R.layout.dialog);
        return builder.create();
    }
}
