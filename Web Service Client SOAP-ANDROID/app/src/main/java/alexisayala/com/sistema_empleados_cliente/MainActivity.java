package alexisayala.com.sistema_empleados_cliente;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class MainActivity extends Activity {

    private ProgressDialog pd;
    private Context context;
    private TextView nombre;
    private TextView apellido_paterno;
    private TextView apellido_materno;
    private TextView fecha_nacimiento;
    private TextView direccion;
    private Button boton1;
    private String xml;
    private Document doc;
    private NodeList nl;
    private String name;
    private String lastnf;
    private String lastnm;
    private String birth;
    private String addr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        nombre = (TextView) findViewById(R.id.no);
        apellido_paterno = (TextView) findViewById(R.id.ap);
        apellido_materno = (TextView) findViewById(R.id.am);
        fecha_nacimiento = (TextView) findViewById(R.id.fn);
        direccion = (TextView) findViewById(R.id.dr);
        boton1 = (Button) findViewById(R.id.send);

        boton1.setOnClickListener(listener);
    }
    private OnClickListener listener = new OnClickListener() {
        public void onClick(View arg0) {
            //	Usamos un AsyncTask, para poder mostrar una ventana de por favor espere, mientras se consulta el servicio web
            new DownloadTask2().execute("");
            pd = ProgressDialog.show(context, "Por favor espere","Consultando Base de Datos", true, false);
            name = nombre.getText().toString();
            lastnf = apellido_paterno.getText().toString();
            lastnm = apellido_materno.getText().toString();
            birth = fecha_nacimiento.getText().toString();
            addr = direccion.getText().toString();

        }
    };
    //Tarea en Background
    private class DownloadTask2 extends AsyncTask<String, Void, Object> {
        protected Integer doInBackground(String... args) {
            XMLParser ws=new XMLParser();
            //Se invoca nuestro metodo
            xml=ws.getXMLUsingSoap(name, lastnf, lastnm, birth, addr);
            /*doc = ws.getDOMElement(xml);
            try {
                nl = doc.getElementsByTagName("CurrentWeather");
                pd.setCancelable(true);
                Element e = (Element) nl.item(0);
                temperatura = ws.getValue(e, "Temperature");
                resultado = "La Temperatura es: "+temperatura;
            }catch(Exception e){
                resultado = "Informacion No Disponible";
            }*/
            return 1;
        }

        protected void onPostExecute(Object result) {
            //Se elimina la pantalla de por favor espere.
            pd.dismiss();
            //Se muestra mensaje con la respuesta del servicio web
            Toast.makeText(context, xml, Toast.LENGTH_LONG).show();
            super.onPostExecute(result);
        }
    }
}