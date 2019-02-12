
package com.super_dev.arcgis.geocoding.find.address;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Candidate implements Parcelable
{

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("extent")
    @Expose
    private Extent extent;
    public final static Creator<Candidate> CREATOR = new Creator<Candidate>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Candidate createFromParcel(Parcel in) {
            return new Candidate(in);
        }

        public Candidate[] newArray(int size) {
            return (new Candidate[size]);
        }

    }
    ;

    protected Candidate(Parcel in) {
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.score = ((int) in.readValue((int.class.getClassLoader())));
        this.attributes = ((Attributes) in.readValue((Attributes.class.getClassLoader())));
        this.extent = ((Extent) in.readValue((Extent.class.getClassLoader())));
    }

    public Candidate() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Candidate withAddress(String address) {
        this.address = address;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Candidate withLocation(Location location) {
        this.location = location;
        return this;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Candidate withScore(int score) {
        this.score = score;
        return this;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Candidate withAttributes(Attributes attributes) {
        this.attributes = attributes;
        return this;
    }

    public Extent getExtent() {
        return extent;
    }

    public void setExtent(Extent extent) {
        this.extent = extent;
    }

    public Candidate withExtent(Extent extent) {
        this.extent = extent;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("address"+ address).append("location"+ location).append("score"+ score).append("attributes"+ attributes).append("extent"+ extent).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(address);
        dest.writeValue(location);
        dest.writeValue(score);
        dest.writeValue(attributes);
        dest.writeValue(extent);
    }

    public int describeContents() {
        return  0;
    }

}
