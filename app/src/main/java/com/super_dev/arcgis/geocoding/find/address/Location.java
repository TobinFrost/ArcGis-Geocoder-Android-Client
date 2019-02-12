
package com.super_dev.arcgis.geocoding.find.address;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Location implements Parcelable
{

    @SerializedName("x")
    @Expose
    private double x;
    @SerializedName("y")
    @Expose
    private double y;
    public final static Creator<Location> CREATOR = new Creator<Location>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        public Location[] newArray(int size) {
            return (new Location[size]);
        }

    }
    ;

    protected Location(Parcel in) {
        this.x = ((double) in.readValue((double.class.getClassLoader())));
        this.y = ((double) in.readValue((double.class.getClassLoader())));
    }

    public Location() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Location withX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Location withY(double y) {
        this.y = y;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("x"+ x).append("y"+ y).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(x);
        dest.writeValue(y);
    }

    public int describeContents() {
        return  0;
    }

}
