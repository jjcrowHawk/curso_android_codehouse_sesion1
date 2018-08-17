package ec.edu.espol.codehouse.cursoandroidespolsesion1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, "Bienvenido, "+usuario, Toast.LENGTH_SHORT).show();

        tv_bienvenida = (TextView) findViewById(R.id.tv_bienvenida);

        String usuario= getIntent().getStringExtra("usuario");

        tv_bienvenida.setText("Bienvenido, " + usuario);
    }
}
