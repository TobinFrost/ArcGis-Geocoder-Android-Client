
package com.super_dev.arcgis.routing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FieldAliases implements Parcelable
{

    @SerializedName("ObjectID")
    @Expose
    private String objectID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("FirstStopID")
    @Expose
    private String firstStopID;
    @SerializedName("LastStopID")
    @Expose
    private String lastStopID;
    @SerializedName("StopCount")
    @Expose
    private String stopCount;
    @SerializedName("Total_TravelTime")
    @Expose
    private String totalTravelTime;
    @SerializedName("Total_Kilometers")
    @Expose
    private String totalKilometers;
    @SerializedName("Total_Miles")
    @Expose
    private String totalMiles;
    @SerializedName("Shape_Length")
    @Expose
    private String shapeLength;
    public final static Creator<FieldAliases> CREATOR = new Creator<FieldAliases>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FieldAliases createFromParcel(Parcel in) {
            return new FieldAliases(in);
        }

        public FieldAliases[] newArray(int size) {
            return (new FieldAliases[size]);
        }

    }
    ;

    protected FieldAliases(Parcel in) {
        this.objectID = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.firstStopID = ((String) in.readValue((String.class.getClassLoader())));
        this.lastStopID = ((String) in.readValue((String.class.getClassLoader())));
        this.stopCount = ((String) in.readValue((String.class.getClassLoader())));
        this.totalTravelTime = ((String) in.readValue((String.class.getClassLoader())));
        this.totalKilometers = ((String) in.readValue((String.class.getClassLoader())));
        this.totalMiles = ((String) in.readValue((String.class.getClassLoader())));
        this.shapeLength = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FieldAliases() {
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public FieldAliases withObjectID(String objectID) {
        this.objectID = objectID;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldAliases withName(String name) {
        this.name = name;
        return this;
    }

    public String getFirstStopID() {
        return firstStopID;
    }

    public void setFirstStopID(String firstStopID) {
        this.firstStopID = firstStopID;
    }

    public FieldAliases withFirstStopID(String firstStopID) {
        this.firstStopID = firstStopID;
        return this;
    }

    public String getLastStopID() {
        return lastStopID;
    }

    public void setLastStopID(String lastStopID) {
        this.lastStopID = lastStopID;
    }

    public FieldAliases withLastStopID(String lastStopID) {
        this.lastStopID = lastStopID;
        return this;
    }

    public String getStopCount() {
        return stopCount;
    }

    public void setStopCount(String stopCount) {
        this.stopCount = stopCount;
    }

    public FieldAliases withStopCount(String stopCount) {
        this.stopCount = stopCount;
        return this;
    }

    public String getTotalTravelTime() {
        return totalTravelTime;
    }

    public void setTotalTravelTime(String totalTravelTime) {
        this.totalTravelTime = totalTravelTime;
    }

    public FieldAliases withTotalTravelTime(String totalTravelTime) {
        this.totalTravelTime = totalTravelTime;
        return this;
    }

    public String getTotalKilometers() {
        return totalKilometers;
    }

    public void setTotalKilometers(String totalKilometers) {
        this.totalKilometers = totalKilometers;
    }

    public FieldAliases withTotalKilometers(String totalKilometers) {
        this.totalKilometers = totalKilometers;
        return this;
    }

    public String getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(String totalMiles) {
        this.totalMiles = totalMiles;
    }

    public FieldAliases withTotalMiles(String totalMiles) {
        this.totalMiles = totalMiles;
        return this;
    }

    public String getShapeLength() {
        return shapeLength;
    }

    public void setShapeLength(String shapeLength) {
        this.shapeLength = shapeLength;
    }

    public FieldAliases withShapeLength(String shapeLength) {
        this.shapeLength = shapeLength;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("objectID"+ objectID).append("name"+name).append("firstStopID"+ firstStopID).append("lastStopID"+ lastStopID).append("stopCount"+ stopCount).append("totalTravelTime"+ totalTravelTime).append("totalKilometers"+ totalKilometers).append("totalMiles"+ totalMiles).append("shapeLength"+ shapeLength).toString();
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
