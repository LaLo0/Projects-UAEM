package alexisayala.com.restfulcallandroid;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText inputData;
    private Button buscardato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputData = (EditText) findViewById(R.id.inputdato);
        buscardato = (Button) findViewById(R.id.buscar);
    }
    public void buscardato(View view) {
        String titulo = inputData.getText().toString();
        if (!TextUtils.isEmpty(titulo)) {
            String url = String.format(
                    "http://mymovieapi.com/?title=%1$s&type=json&limit=10",
                    titulo);
            new LoadFilmTask().execute(url);

        }
    }
}
