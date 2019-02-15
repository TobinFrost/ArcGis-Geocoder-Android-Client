
package com.super_dev.arcgis.routing.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpatialReference implements Parcelable
{

    @SerializedName("wkid")
    @Expose
    private String wkid;
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
        this.wkid = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SpatialReference() {
    }

    public String getWkid() {
        return wkid;
    }

    public void setWkid(String wkid) {
        this.wkid = wkid;
    }

    public SpatialReference withWkid(String wkid) {
        this.wkid = wkid;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(wkid);
    }

    public int describeContents() {
        return  0;
    }

}
