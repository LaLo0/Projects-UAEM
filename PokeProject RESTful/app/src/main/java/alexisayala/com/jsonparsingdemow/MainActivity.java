package alexisayala.com.jsonparsingdemow;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity implements OnClickListener {
    private TextView numeropk;
    private String numerin;
    private String URL;
    private String FinalURL;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttn).setOnClickListener(this);
        numeropk = (TextView) findViewById(R.id.numbr);

    }

    @Override
    public void onClick(View arg0) {
        Button b = (Button)findViewById(R.id.buttn);
        b.setClickable(false);
        new LongRunningGetIO().execute();
    }

    private class LongRunningGetIO extends AsyncTask <Void, Void, String> {

        protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
            InputStream in = entity.getContent();
            StringBuffer out = new StringBuffer();
            int n = 1;
            while (n>0) {
                byte[] b = new byte[4096];
                n =  in.read(b);
                if (n>0) out.append(new String(b, 0, n));
            }
            return out.toString();
        }

        @Override
        protected String doInBackground(Void... params) {

            URL = "http://pokeapi.co/api/v2/pokemon/";
            numerin = numeropk.getText().toString();
            FinalURL = URL+numerin;

            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpGet httpGet = new HttpGet(FinalURL);
            String text = null;
            try {
                HttpResponse response = httpClient.execute(httpGet, localContext);
                HttpEntity entity = response.getEntity();
                text = getASCIIContentFromEntity(entity);
            } catch (Exception e) {
                return e.getLocalizedMessage();
            }
            return text;
        }

        protected void onPostExecute(String results) {
            if (results!=null) {
                EditText et = (EditText)findViewById(R.id.resut);
                et.setText(results);
            }
            Button b = (Button)findViewById(R.id.buttn);
            b.setClickable(true);
        }
    }
}

