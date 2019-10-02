package br.org.senaies.appcalculadora;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_RESULTADO = 546; //Podemos criar classe externa só de constantes

    private Button btnSomar;
    private Button btnSubtrair;
    private Button btnMultiplicar;
    private Button btnDividir;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSomar = findViewById(R.id.btnSomar);
        btnSubtrair = findViewById(R.id.btnSubtrair);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void somar (View v){
        Intent i = new Intent();
        i.setClass(MainActivity.this, ResultadoActivity.class);
        i.putExtra("operacao", "somar");
        startActivityForResult(i, REQUEST_RESULTADO);
    }
    public void subtrair (View v){
        Intent i = new Intent();
        i.setClass(MainActivity.this, ResultadoActivity.class);
        i.putExtra("operacao", "subtrair");
        startActivityForResult(i, REQUEST_RESULTADO);
    }
    public void multiplicar (View v){
        Intent i = new Intent();
        i.setClass(MainActivity.this, ResultadoActivity.class);
        i.putExtra("operacao", "multiplicar");
        startActivityForResult(i, REQUEST_RESULTADO);
    }
    public void dividir (View v){
        Intent i = new Intent();
        i.setClass(MainActivity.this, ResultadoActivity.class);
        i.putExtra("operacao", "dividir");
        startActivityForResult(i, REQUEST_RESULTADO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_RESULTADO && resultCode == RESULT_OK){
            txtResultado.setText(String.valueOf(data.getDoubleExtra("resultado",0)));
        }

    }
}
