package com.super_dev.arcgis.oauth2.token;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.super_dev.arcgis.geocoding.operator.ApiCall;
import com.super_dev.arcgis.oauth2.token.constants.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TokenGenerator {

    public static final String CLIENT_ID_KEY = "client_id";
    public static final String CLIENT_SECRET_KEY = "client_secret";
    public static final String GRANT_TYPE_KEY = "grant_type";

    private String client_id;
    private String client_secret;
    private final String grant_type = "client_credentials";
    private static Context mCtx;
    private Map<String, String> dataMap;
    private static String url;
    private Response request_response;

    private static TokenGenerator mInstance;

    public TokenGenerator(Context context, String client_id, String client_secret) {
        mCtx = context;
        this.client_id = client_id;
        this.client_secret = client_secret;
        dataMap = new HashMap<String, String>();
        dataMap.put(CLIENT_ID_KEY, client_id);
        dataMap.put(CLIENT_SECRET_KEY, client_secret);
        dataMap.put(GRANT_TYPE_KEY, grant_type);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(Constants.SHEME)
                .authority(Constants.AUTHORITY)
                .appendPath(Constants.PATH1)
                .appendPath(Constants.PATH2)
                .appendPath(Constants.PATH3)
                .appendPath(Constants.PATH4);
        url = builder.build().toString();

    }

    public static synchronized TokenGenerator getInstance(Context context, String client_id, String client_secret) {
        if(mInstance == null){
            mInstance = new TokenGenerator(context, client_id, client_secret);
        }
        return mInstance;
    }

    public Response generate(){

        ApiCall.makePost(mCtx, url,dataMap, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Response returnedResponse = new Response();
                try {
                String access_token = response.getString("access_token");
                String expires_in = response.getString("expires_in");
                returnedResponse.setAccess_token(access_token);
                returnedResponse.setExpires_in(expires_in);

                } catch (JSONException e) {
                    Log.v("JSON", "EXC: " + e.getLocalizedMessage());
                }
                request_response = returnedResponse;
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return request_response;

    }


    public class Response {
        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(String expires_in) {
            this.expires_in = expires_in;
        }

        private String access_token;
        private String expires_in;

        public Response(){}
        public Response(String access_token, String expires_in) {
            this.access_token = access_token;
            this.expires_in = expires_in;
        }
    }
}
