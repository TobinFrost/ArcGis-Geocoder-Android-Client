package com.super_dev.arcgis.operator;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import java.util.Map;


// Thanks to Truiton.com for this

public class ApiCall {

    private static ApiCall mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    public ApiCall(Context ctx) {
        mCtx = ctx;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized ApiCall getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ApiCall(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public static void make(Context ctx, String url, Response.Listener<JSONObject>
            listener, Response.ErrorListener errorListener) {
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                listener, errorListener);
        ApiCall.getInstance(ctx).addToRequestQueue(getRequest);
    }

    public static void makePost(Context ctx, String url, final Map<String, String> params, Response.Listener<String> listener, Response.ErrorListener errorListener){

            StringRequest postRequest = new StringRequest (Request.Method.POST, url,
                    listener, errorListener)
            {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    return params;
                }
            }
            ;

            ApiCall.getInstance(ctx).addToRequestQueue(postRequest);

    }
}
