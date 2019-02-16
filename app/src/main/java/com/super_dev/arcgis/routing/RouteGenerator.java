package com.super_dev.arcgis.routing;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.super_dev.arcgis.operator.ApiCall;
import com.super_dev.arcgis.routing.constants.Constants;
import com.super_dev.arcgis.routing.interfaces.RouteGeneratorListener;
import com.super_dev.arcgis.routing.request.FeatureRouteRequest;
import com.super_dev.arcgis.routing.request.Geometry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteGenerator {

    public static final String TOKEN_KEY = "token";
    public static final String F_KEY = "f";
    public static final String FIND_BEST_SEQUENCE_KEY = "findBestSequence";
    public static final String STOPS_KEY = "stops";

    private final String f = "json";
    private final Boolean findBestSequence = true;
    private String token;
    private String stops;
    private static Context mCtx;
    private Map<String, String> dataMap;
    public static String url;

    private static RouteGenerator mInstance;
    private List<Pair<Double,Double>> requestResponse;

    public RouteGenerator(Context context, String token) {
        mCtx = context;
        this.token = token;
        dataMap = new HashMap<String, String>();
        dataMap.put(TOKEN_KEY,token);
        dataMap.put(F_KEY,f);
        dataMap.put(FIND_BEST_SEQUENCE_KEY,findBestSequence+"");

        Uri.Builder builder = new Uri.Builder();
        builder.scheme(Constants.SHEME)
                .authority(Constants.AUTHORITY)
                .appendPath(Constants.PATH1)
                .appendPath(Constants.PATH2)
                .appendPath(Constants.PATH3)
                .appendPath(Constants.PATH4)
                .appendPath(Constants.PATH5)
                .appendPath(Constants.PATH6)
                .appendPath(Constants.PATH7)
                .appendPath(Constants.PATH8);
        url = builder.build().toString();
    }

    public static synchronized RouteGenerator getInstance(Context context,String token) {
        if(mInstance == null){
            mInstance = new RouteGenerator(context, token);
        }
        return  mInstance;
    }

    public void generate(Geometry origin, Geometry destination, final RouteGeneratorListener listener) {
        requestResponse = new ArrayList<>();
        FeatureRouteRequest fRequest = FeatureRouteRequest.build(origin,destination);
        mInstance.stops = fRequest.toJson();
        dataMap.put(STOPS_KEY,stops);
        ApiCall.makePost(mCtx, url, dataMap, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("JSON", "EXC: " + response);
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONObject routesResponse = jsonResponse.getJSONObject("routes");
                    JSONArray featuresResponse = routesResponse.getJSONArray("features");
                    for (int i = 0; i < featuresResponse.length(); i++) {
                        JSONObject featureResponse = featuresResponse.getJSONObject(i);
                        JSONObject geometryFeatureResponse = featureResponse.getJSONObject("geometry");
                        JSONArray pathGeometry = geometryFeatureResponse.getJSONArray("paths");
                        for (int j = 0; j <  pathGeometry.length(); j++) {

                            for (int k = 0; k < pathGeometry.getJSONArray(j).length(); k++) {
                                JSONArray path = pathGeometry.getJSONArray(j).getJSONArray(k);
                                Double longitude = path.getDouble(0);
                                Double latitude = path.getDouble(1);
                                Pair<Double,Double> coordinate = new Pair<>(longitude,latitude);
                                requestResponse.add(coordinate);

                            }
                        }
                    }
                    listener.success(true,requestResponse);
                } catch (JSONException e) {
                    Log.v("JSON", "EXC: " + e.getLocalizedMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.success(false,null);
                Log.e("API", "Err" + error.getLocalizedMessage());
            }
        });

    }


}
