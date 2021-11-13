package utn.sistema.toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class ClickListener implements DialogInterface.OnClickListener {
    @Override
    public void onClick(DialogInterface dialog, int which)
    {
        if(which == AlertDialog.BUTTON_POSITIVE)
        {
            Log.d("click","El positive button");
        }
        else if(which == AlertDialog.BUTTON_NEGATIVE)
        {
            Log.d("click","El negative button");
        }
        else if(which == AlertDialog.BUTTON_NEUTRAL)
        {
            Log.d("click","El neutral button")
        }

    }
}
