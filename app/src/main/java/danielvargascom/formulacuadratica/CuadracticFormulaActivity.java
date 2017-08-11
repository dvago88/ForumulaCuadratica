package danielvargascom.formulacuadratica;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CuadracticFormulaActivity extends AppCompatActivity {

    private EditText letraA;
    private EditText letraB;
    private EditText letraC;
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView resultado;
    private TextView resultado2;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadractic_formula);

        calcularButton = (Button) findViewById(R.id.calcularButton);
        a=(TextView) findViewById(R.id.a);
        b=(TextView) findViewById(R.id.b);
        c=(TextView) findViewById(R.id.c);
        resultado=(TextView) findViewById(R.id.resultado);
        resultado2=(TextView) findViewById(R.id.resultado2);
        letraA=(EditText)findViewById(R.id.letraA);
        letraB=(EditText)findViewById(R.id.letraB);
        letraC=(EditText)findViewById(R.id.letraC);

        View.OnClickListener listener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float aNumero= Float.parseFloat(String.valueOf(letraA.getText()));
                float bNumero= Float.parseFloat(String.valueOf(letraB.getText()));
                float cNumero= Float.parseFloat(String.valueOf(letraC.getText()));

                double result=(-bNumero+Math.sqrt(bNumero*bNumero-4*aNumero*cNumero))/(2*aNumero);
                double result2=(-bNumero-Math.sqrt(bNumero*bNumero-4*aNumero*cNumero))/(2*aNumero);

                resultado.setText(String.valueOf(result));
                resultado2.setText(String.valueOf(result2));
            }
        };
        calcularButton.setOnClickListener(listener);

    }
}
