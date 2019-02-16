package com.super_dev.arcgis.routing.request;

import com.google.gson.Gson;

public class SuperJSON {

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
