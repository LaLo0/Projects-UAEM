package alexisayala.com.aplicacion.aplicacion;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by alexis on 07/06/16.
 */
public class ConfigureApp extends Application{
    public static final String TAG = ConfigureApp.class.getSimpleName();

    private RequestQueue mRecuestQueue;
    public static ConfigureApp mInstance;
    @Override
    public void onCreate(){
        super.onCreate();
        mInstance = this;
    }

    public static synchronized ConfigureApp getInstance() {return mInstance;}

    public RequestQueue getRecuestQueue(){
        if(mRecuestQueue == null){
            mRecuestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRecuestQueue;
    }
    public <T> void addToRequestQueue (Request<T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRecuestQueue().add(req);
    }
    public <T> void addToRequestQueue (Request<T> req){
        req.setTag(TAG);
        getRecuestQueue().add(req);
    }
    public void cancelPendingRequest(Object tag){
        if (mRecuestQueue != null){
            mRecuestQueue.cancelAll(tag);
        }
    }
}
