
package com.super_dev.arcgis.routing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Attributes implements Parcelable
{

    @SerializedName("ObjectID")
    @Expose
    private int objectID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("FirstStopID")
    @Expose
    private int firstStopID;
    @SerializedName("LastStopID")
    @Expose
    private int lastStopID;
    @SerializedName("StopCount")
    @Expose
    private int stopCount;
    @SerializedName("Total_TravelTime")
    @Expose
    private double totalTravelTime;
    @SerializedName("Total_Kilometers")
    @Expose
    private double totalKilometers;
    @SerializedName("Total_Miles")
    @Expose
    private double totalMiles;
    @SerializedName("Shape_Length")
    @Expose
    private double shapeLength;
    public final static Creator<Attributes> CREATOR = new Creator<Attributes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes createFromParcel(Parcel in) {
            return new Attributes(in);
        }

        public Attributes[] newArray(int size) {
            return (new Attributes[size]);
        }

    }
    ;

    protected Attributes(Parcel in) {
        this.objectID = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.firstStopID = ((int) in.readValue((int.class.getClassLoader())));
        this.lastStopID = ((int) in.readValue((int.class.getClassLoader())));
        this.stopCount = ((int) in.readValue((int.class.getClassLoader())));
        this.totalTravelTime = ((double) in.readValue((double.class.getClassLoader())));
        this.totalKilometers = ((double) in.readValue((double.class.getClassLoader())));
        this.totalMiles = ((double) in.readValue((double.class.getClassLoader())));
        this.shapeLength = ((double) in.readValue((double.class.getClassLoader())));
    }

    public Attributes() {
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public Attributes withObjectID(int objectID) {
        this.objectID = objectID;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes withName(String name) {
        this.name = name;
        return this;
    }

    public int getFirstStopID() {
        return firstStopID;
    }

    public void setFirstStopID(int firstStopID) {
        this.firstStopID = firstStopID;
    }

    public Attributes withFirstStopID(int firstStopID) {
        this.firstStopID = firstStopID;
        return this;
    }

    public int getLastStopID() {
        return lastStopID;
    }

    public void setLastStopID(int lastStopID) {
        this.lastStopID = lastStopID;
    }

    public Attributes withLastStopID(int lastStopID) {
        this.lastStopID = lastStopID;
        return this;
    }

    public int getStopCount() {
        return stopCount;
    }

    public void setStopCount(int stopCount) {
        this.stopCount = stopCount;
    }

    public Attributes withStopCount(int stopCount) {
        this.stopCount = stopCount;
        return this;
    }

    public double getTotalTravelTime() {
        return totalTravelTime;
    }

    public void setTotalTravelTime(double totalTravelTime) {
        this.totalTravelTime = totalTravelTime;
    }

    public Attributes withTotalTravelTime(double totalTravelTime) {
        this.totalTravelTime = totalTravelTime;
        return this;
    }

    public double getTotalKilometers() {
        return totalKilometers;
    }

    public void setTotalKilometers(double totalKilometers) {
        this.totalKilometers = totalKilometers;
    }

    public Attributes withTotalKilometers(double totalKilometers) {
        this.totalKilometers = totalKilometers;
        return this;
    }

    public double getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(double totalMiles) {
        this.totalMiles = totalMiles;
    }

    public Attributes withTotalMiles(double totalMiles) {
        this.totalMiles = totalMiles;
        return this;
    }

    public double getShapeLength() {
        return shapeLength;
    }

    public void setShapeLength(double shapeLength) {
        this.shapeLength = shapeLength;
    }

    public Attributes withShapeLength(double shapeLength) {
        this.shapeLength = shapeLength;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("objectID"+ objectID).append("name"+ name).append("firstStopID"+ firstStopID).append("lastStopID"+ lastStopID).append("stopCount"+ stopCount).append("totalTravelTime"+ totalTravelTime).append("totalKilometers"+ totalKilometers).append("totalMiles"+ totalMiles).append("shapeLength"+ shapeLength).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(objectID);
        dest.writeValue(name);
        dest.writeValue(firstStopID);
        dest.writeValue(lastStopID);
        dest.writeValue(stopCount);
        dest.writeValue(totalTravelTime);
        dest.writeValue(totalKilometers);
        dest.writeValue(totalMiles);
        dest.writeValue(shapeLength);
    }

    public int describeContents() {
        return  0;
    }

}
