package alexisayala.com.androidxmlparsingactivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MainActivity extends Activity {

    //parameters
    private ProgressDialog pd;
    private TextView ciudad;
    private TextView pais;
    private Button boton1;
    private String xml;
    private Context context;
    private Document doc;
    private NodeList nl;
    public String temperatura ;
    public String resultado;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //Buscamos los items por id
        ciudad   =(TextView)  findViewById(R.id.city);
        pais     =(TextView)  findViewById(R.id.coun);
        boton1   =(Button)    findViewById(R.id.button1);

        //asignamos el listener al boton
        boton1.setOnClickListener(listener);
    }
    private OnClickListener listener = new OnClickListener() {
        public void onClick(View arg0) {
            //	Usamos un AsyncTask, para poder mostrar una ventana de por favor espere, mientras se consulta el servicio web
            new DownloadTask2().execute("");
            pd = ProgressDialog.show(context, "Por favor espere","Consultando Clima", true, false);

        }
    };
    //Tarea en Background
    private class DownloadTask2 extends AsyncTask<String, Void, Object> {
        protected Integer doInBackground(String... args) {
            XMLParser ws=new XMLParser();
            //Se invoca nuestro metodo
            xml=ws.getXMLUsingSoap(ciudad.getText().toString(), pais.getText().toString());
            doc = ws.getDOMElement(xml);
            try {
                nl = doc.getElementsByTagName("CurrentWeather");
                pd.setCancelable(true);
                Element e = (Element) nl.item(0);
                temperatura = ws.getValue(e, "Temperature");
                resultado = "La Temperatura es: "+temperatura;
            }catch(Exception e){
                resultado = "Informacion No Disponible";
            }
            return 1;
        }

        protected void onPostExecute(Object result) {
            //Se elimina la pantalla de por favor espere.
            pd.dismiss();
            //Se muestra mensaje con la respuesta del servicio web
            Toast.makeText(context, resultado, Toast.LENGTH_LONG).show();
            super.onPostExecute(result);
        }
    }
}