
package com.super_dev.arcgis.geocoding.find.address;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Extent implements Parcelable
{

    @SerializedName("xmin")
    @Expose
    private double xmin;
    @SerializedName("ymin")
    @Expose
    private double ymin;
    @SerializedName("xmax")
    @Expose
    private double xmax;
    @SerializedName("ymax")
    @Expose
    private double ymax;
    public final static Creator<Extent> CREATOR = new Creator<Extent>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Extent createFromParcel(Parcel in) {
            return new Extent(in);
        }

        public Extent[] newArray(int size) {
            return (new Extent[size]);
        }

    }
    ;

    protected Extent(Parcel in) {
        this.xmin = ((double) in.readValue((double.class.getClassLoader())));
        this.ymin = ((double) in.readValue((double.class.getClassLoader())));
        this.xmax = ((double) in.readValue((double.class.getClassLoader())));
        this.ymax = ((double) in.readValue((double.class.getClassLoader())));
    }

    public Extent() {
    }

    public double getXmin() {
        return xmin;
    }

    public void setXmin(double xmin) {
        this.xmin = xmin;
    }

    public Extent withXmin(double xmin) {
        this.xmin = xmin;
        return this;
    }

    public double getYmin() {
        return ymin;
    }

    public void setYmin(double ymin) {
        this.ymin = ymin;
    }

    public Extent withYmin(double ymin) {
        this.ymin = ymin;
        return this;
    }

    public double getXmax() {
        return xmax;
    }

    public void setXmax(double xmax) {
        this.xmax = xmax;
    }

    public Extent withXmax(double xmax) {
        this.xmax = xmax;
        return this;
    }

    public double getYmax() {
        return ymax;
    }

    public void setYmax(double ymax) {
        this.ymax = ymax;
    }

    public Extent withYmax(double ymax) {
        this.ymax = ymax;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("xmin"+ xmin).append("ymin"+ ymin).append("xmax"+ xmax).append("ymax"+ ymax).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(xmin);
        dest.writeValue(ymin);
        dest.writeValue(xmax);
        dest.writeValue(ymax);
    }

    public int describeContents() {
        return  0;
    }

}
