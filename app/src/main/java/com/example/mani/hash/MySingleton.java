package com.example.mani.hash;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by mani on 3/10/18.
 */

public class MySingleton {

    private static MySingleton mInstance;
    private static RequestQueue requestQueue;
    private static Context mCtx;

    private MySingleton(Context context)
    {
        mCtx = context;
        requestQueue = getRequestQueue();

    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());

        return requestQueue;
    }

    public static synchronized MySingleton getmInstance(Context context)
    {
        if(mInstance == null)
            mInstance = new MySingleton(context);
        return mInstance;

    }

    public <T> void addRequestQueue(Request<T> request)
    {
        requestQueue.add(request);
    }

}