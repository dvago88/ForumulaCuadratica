package danielvargascom.formulacuadratica;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Daniel on 12/08/2017
 */

public class DialogoAlerta extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstance) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("La letra a NO puede ser cero!!!\nPues no sería cuadrática -.-")
                .setPositiveButton("Vale tio", null);
        return builder.create();
    }
}
