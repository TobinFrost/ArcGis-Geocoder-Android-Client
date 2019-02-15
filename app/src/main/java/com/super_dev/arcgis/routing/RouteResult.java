
package com.super_dev.arcgis.routing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RouteResult implements Parcelable
{

    @SerializedName("routes")
    @Expose
    private Routes routes;
    public final static Creator<RouteResult> CREATOR = new Creator<RouteResult>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RouteResult createFromParcel(Parcel in) {
            return new RouteResult(in);
        }

        public RouteResult[] newArray(int size) {
            return (new RouteResult[size]);
        }

    }
    ;

    protected RouteResult(Parcel in) {
        this.routes = ((Routes) in.readValue((Routes.class.getClassLoader())));
    }

    public RouteResult() {
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    public RouteResult withRoutes(Routes routes) {
        this.routes = routes;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("routes"+ routes).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(routes);
    }

    public int describeContents() {
        return  0;
    }

}
