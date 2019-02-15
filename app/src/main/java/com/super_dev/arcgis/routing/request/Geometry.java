
package com.super_dev.arcgis.routing.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geometry implements Parcelable
{

    @SerializedName("x")
    @Expose
    private double x;
    @SerializedName("y")
    @Expose
    private double y;
    @SerializedName("spatialReference")
    @Expose
    private SpatialReference spatialReference;
    public final static Creator<Geometry> CREATOR = new Creator<Geometry>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Geometry createFromParcel(Parcel in) {
            return new Geometry(in);
        }

        public Geometry[] newArray(int size) {
            return (new Geometry[size]);
        }

    }
    ;

    protected Geometry(Parcel in) {
        this.x = ((double) in.readValue((double.class.getClassLoader())));
        this.y = ((double) in.readValue((double.class.getClassLoader())));
        this.spatialReference = ((SpatialReference) in.readValue((SpatialReference.class.getClassLoader())));
    }

    public Geometry() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Geometry withX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Geometry withY(double y) {
        this.y = y;
        return this;
    }

    public SpatialReference getSpatialReference() {
        return spatialReference;
    }

    public void setSpatialReference(SpatialReference spatialReference) {
        this.spatialReference = spatialReference;
    }

    public Geometry withSpatialReference(SpatialReference spatialReference) {
        this.spatialReference = spatialReference;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(x);
        dest.writeValue(y);
        dest.writeValue(spatialReference);
    }

    public int describeContents() {
        return  0;
    }

}
