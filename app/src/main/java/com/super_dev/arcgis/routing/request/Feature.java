
package com.super_dev.arcgis.routing.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature implements Parcelable
{

    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    public final static Creator<Feature> CREATOR = new Creator<Feature>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Feature createFromParcel(Parcel in) {
            return new Feature(in);
        }

        public Feature[] newArray(int size) {
            return (new Feature[size]);
        }

    }
    ;

    protected Feature(Parcel in) {
        this.geometry = ((Geometry) in.readValue((Geometry.class.getClassLoader())));
    }

    public Feature() {
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Feature withGeometry(Geometry geometry) {
        this.geometry = geometry;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(geometry);
    }

    public int describeContents() {
        return  0;
    }

}
