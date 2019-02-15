
package com.super_dev.arcgis.routing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Feature implements Parcelable
{

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
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
        this.attributes = ((Attributes) in.readValue((Attributes.class.getClassLoader())));
        this.geometry = ((Geometry) in.readValue((Geometry.class.getClassLoader())));
    }

    public Feature() {
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Feature withAttributes(Attributes attributes) {
        this.attributes = attributes;
        return this;
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

    @Override
    public String toString() {
        return new StringBuilder().append("attributes"+ attributes).append("geometry"+ geometry).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(attributes);
        dest.writeValue(geometry);
    }

    public int describeContents() {
        return  0;
    }

}
