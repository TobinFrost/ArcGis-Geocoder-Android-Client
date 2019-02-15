
package com.super_dev.arcgis.routing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SpatialReference implements Parcelable
{

    @SerializedName("wkid")
    @Expose
    private int wkid;
    @SerializedName("latestWkid")
    @Expose
    private int latestWkid;
    public final static Creator<SpatialReference> CREATOR = new Creator<SpatialReference>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SpatialReference createFromParcel(Parcel in) {
            return new SpatialReference(in);
        }

        public SpatialReference[] newArray(int size) {
            return (new SpatialReference[size]);
        }

    }
    ;

    protected SpatialReference(Parcel in) {
        this.wkid = ((int) in.readValue((int.class.getClassLoader())));
        this.latestWkid = ((int) in.readValue((int.class.getClassLoader())));
    }

    public SpatialReference() {
    }

    public int getWkid() {
        return wkid;
    }

    public void setWkid(int wkid) {
        this.wkid = wkid;
    }

    public SpatialReference withWkid(int wkid) {
        this.wkid = wkid;
        return this;
    }

    public int getLatestWkid() {
        return latestWkid;
    }

    public void setLatestWkid(int latestWkid) {
        this.latestWkid = latestWkid;
    }

    public SpatialReference withLatestWkid(int latestWkid) {
        this.latestWkid = latestWkid;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("wkid"+ wkid).append("latestWkid"+ latestWkid).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(wkid);
        dest.writeValue(latestWkid);
    }

    public int describeContents() {
        return  0;
    }

}
