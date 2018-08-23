package ec.edu.espol.codehouse.cursoandroidespolsesion1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*Este objeto se enlazara con el TextView que se encuentra en el layout activity_main.xml*/
    TextView tv_bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*En esta linea se indica que ventana es la que se va a cargar.
          No olvidar que para referenciar el archivo layout (ventana) se
          debe utilizar la referencia: R.layout.nombre_archivo_layout*/
        setContentView(R.layout.activity_main);

        /*Se realiza el enlace del objeto al elemento del layout mediante su id*/
        tv_bienvenida = (TextView) findViewById(R.id.tv_bienvenida);

        /* Cuando una activity envia datos a otra activity con el intent por medio del
           metodo putExtra, la actividad que RECIBE el intent puede extraer los datos por
           medio de ESTE INTENT utilizando la misma CLAVE con la que se enviaron estos datos.
           En este caso queremos obtener el String con el nombre de usuario, y para eso en el
           metodo getStringExtra() pasamos como clave la palabra "usuario", ya que esta palabra
           fue la clave con la que la se envio este dato.
         */
        String usuario= getIntent().getStringExtra("usuario");

        /*Ahora especificamos el texto que va a tener el textView de bienvenida*/
        tv_bienvenida.setText("Bienvenido, " + usuario);

        /*--------------------AQUI VA EL CODIGO DE LA SEGUNDA SESION-------------------------*/

    }
}
