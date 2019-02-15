package com.super_dev.arcgis.routing;

import android.content.Context;
import android.net.Uri;

import com.super_dev.arcgis.routing.constants.Constants;
import com.super_dev.arcgis.routing.request.FeatureRouteRequest;

import java.util.HashMap;
import java.util.Map;

public class RouteGenerator {

    public static final String TOKEN_KEY = "token";
    public static final String F_KEY = "f";
    public static final String FIND_BEST_SEQUENCE_KEY = "findBestSequence";
    public static final String STOPS_KEY = "stops";

    private final String f = "json";
    private final Boolean findBestSequence = true;
    private String token;
    private FeatureRouteRequest stops;
    private static Context mCtx;
    private Map<String, String> dataMap;
    public static String url;

    private static RouteGenerator mInstance;



    public RouteGenerator(String token, FeatureRouteRequest stops) {
        this.token = token;
        this.stops = stops;
        dataMap = new HashMap<String, String>();
        dataMap.put(TOKEN_KEY,token);
        dataMap.put(F_KEY,f);
        dataMap.put(FIND_BEST_SEQUENCE_KEY,findBestSequence+"");
        dataMap.put(STOPS_KEY,stops.toString());
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

    public static synchronized RouteGenerator getInstance(String token, FeatureRouteRequest stops) {
        if(mInstance == null){
            mInstance = new RouteGenerator(token , stops);
        }
        return  mInstance;
    }


}
