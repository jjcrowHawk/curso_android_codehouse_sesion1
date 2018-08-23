package ec.edu.espol.codehouse.cursoandroidespolsesion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    /*Estos objetos serviran para enlazar los elementos de la ventana activity_logEin.xml*/
    Button btn_login;
    EditText et_usuario, et_password;

    /*Este metodo se ejecuta cuando se crea o se inicializa la ventana del activity.
      Es en este metodo donde enlazamos los objetos con los elementos de la ventana y
      donde se declaran los eventos para los elementos que van a interactuar con el usuario
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*En esta linea se indica que ventana es la que se va a cargar.
          No olvidar que para referenciar el archivo layout (ventana) se
          debe utilizar la referencia: R.layout.nombre_archivo_layout*/
        setContentView(R.layout.activity_login);

        /*Aqui se enlazan los objetos de java con los elementos de la ventana o layout
          el metodo que hace el enlace es findViewById() y recibe como parametro el id
          del elemento (revisar el atributo id en el editor de layouts). Para acceder al
          id del elemento debemos usar la referencia: R.id.id_elemento*/
        et_usuario= (EditText) findViewById(R.id.et_usuario);
        et_password= (EditText) findViewById(R.id.et_password);
        btn_login= (Button) findViewById(R.id.btn_login);

        /*Aqui se declara la accion que debe realizar el boton cuando el usuario lo presione.
          el metodo recibe un objeto Listener de una clase anonima, lo que quiere decir que
          siempre tendremos que implementar el metodo de esa clase anonima, que en este caso
          es el metodo onClick()
         */
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Boton TOCADO!!!");

                /*Como los objetos de java ya estan enlazados a los elementos del layout, es posible
                  extraer algunos atributos de estos elementos. En este caso, como los objetos EditText et_usuario
                  y et_password estan enlazados a los EdiText Usuario y Contrasena, podemos extraer
                  el texto que se ha escrito en esos EditText con el metodo getText(), el cual
                  devuelve un objeto de tipo Editable, el cual es un String editable. Si queremos
                  obtener el texto de este objeto, basta con aplicarle el metodo toString().
                 */
                String usuario= et_usuario.getText().toString();
                String password= et_password.getText().toString();

                /*Se desafia a que ahora comparen esto con una lista de usuarios y contrasenas predefinidas*/
                if(usuario.equals("admin") && password.equals("1234")){
                    /*La clase Toast nos permite mostrar mensajes de texto al usuario por pantalla.
                      Esto es posible utilizando el metodo estatico makeText(), el cual recibe 3
                      parametros: context (La actividad de donde se lo esta invocando), text (El texto
                      que queremos mostrar y duracion (si deseamos una duracion corta o larga, esto
                      se lo especifica con los valores estaticos de Toast .LENGTH_SHORT o .LENGHT_LONG
                    *
                    Toast.makeText(LoginActivity.this, "USUARIO VALIDO!", Toast.LENGTH_SHORT).show();


                    /*La clase Intent nos permite hacer una transicion de una actividad a otra.
                      el constructor de esta clase recibe 2 parametros: el contexto (context) de
                      la actividad que lo llama y la actividad hacia donde se dirige (esta se especifica
                      con el nombre e invocando el atributo class.
                     */
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);

                    /*los intents tambien puede enviar informacion desde una actividad a otra,
                      usando el metodo putExtra, el cual recibe 2 parametros: la clave con el cual
                      se identifica el objeto y el objeto que se quiere enviar, es decir se envia
                      un par clave - valor, como si se tratara de un diccionario o Map
                    */
                    intent.putExtra("usuario",usuario);

                    //Con este metodo ocurre la transicion entre activities, pasando el intent como parametro
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "USUARIO INVALIDO! Ingrese de nuevo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
