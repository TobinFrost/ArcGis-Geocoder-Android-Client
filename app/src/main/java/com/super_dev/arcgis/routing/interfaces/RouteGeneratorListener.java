package com.super_dev.arcgis.routing.interfaces;

import android.util.Pair;

import java.util.List;

public interface RouteGeneratorListener {
    void success(Boolean success, List<Pair<Double,Double>> response);
}
