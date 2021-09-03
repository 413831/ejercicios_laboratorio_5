package utn.sistema.claseuno2020;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ClickBoton implements View.OnClickListener
{
    private Activity activity;
    private TextView txtView;
    private EditText editView;

    ClickBoton(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    public void onClick(View view)
    {
        Log.d("click","Se hizo un click");
        if(txtView == null)
        {
            this.txtView = this.activity.findViewById(R.id.txtSaludo);
        }

        if(view.getId() == R.id.btn)
        {
            if(editView == null)
            {
                this.editView = this.activity.findViewById(R.id.inputTxt);
            }
            this.txtView.setText(editView.getText().toString());
        }
        else if(view.getId() == R.id.btn2)
        {
            this.txtView.setText("OTRO TEXTO");
        }
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
