package danielvargascom.formulacuadratica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CuadracticFormulaActivity extends AppCompatActivity {

    private EditText letraA;
    private EditText letraB;
    private EditText letraC;
    private TextView resultado;
    private TextView resultado2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadractic_formula);

        Button calcularButton = (Button) findViewById(R.id.calcularButton);
        resultado = (TextView) findViewById(R.id.resultado);
        resultado2 = (TextView) findViewById(R.id.resultado2);
        letraA = (EditText) findViewById(R.id.letraA);
        letraB = (EditText) findViewById(R.id.letraB);
        letraC = (EditText) findViewById(R.id.letraC);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float a = Float.parseFloat(String.valueOf(letraA.getText()));
                    float b = Float.parseFloat(String.valueOf(letraB.getText()));
                    float c = Float.parseFloat(String.valueOf(letraC.getText()));
                    boolean esImaginario = b * b - 4 * a * c < 0;
                    if (a == 0) {
                        DialogoAlerta dialog = new DialogoAlerta();
                        dialog.show(getFragmentManager(), "error_dialog");
                        if (b == 0) {
                            Toast.makeText(CuadracticFormulaActivity.this, "Y si la berraca b es cero menos que se va a poder!!", Toast.LENGTH_SHORT).show();
                        } else {
                            float veaPues = -c / b;
                            resultado.setText(String.format("%s", veaPues));
                            resultado2.setText(R.string.soloHayUnaRespuesta);
                            Toast.makeText(CuadracticFormulaActivity.this, "Igual lo resolví... -.-", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        if (esImaginario) {
                            resultado.setText(R.string.ResultadoImaginario);
                            resultado2.setText(R.string.ResultadoImaginario);
                        } else {
                            double result = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                            double result2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

                            resultado.setText(String.valueOf(result));
                            resultado2.setText(String.valueOf(result2));
                        }
                    }
                } catch (NumberFormatException nf) {
                    resultado.setText(R.string.camposIncompletos);
                    resultado2.setText(R.string.camposIncompletos);
                }
            }
        };
        calcularButton.setOnClickListener(listener);

    }
}
