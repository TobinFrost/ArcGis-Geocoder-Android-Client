
package com.super_dev.arcgis.routing;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Geometry implements Parcelable
{

    @SerializedName("paths")
    @Expose
    private List<List<List<Double>>> paths = new ArrayList<List<List<Double>>>();
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
//        in.readList(this.paths, (List<List<Double>>.class.getClassLoader()));
    }

    public Geometry() {
    }

    public List<List<List<Double>>> getPaths() {
        return paths;
    }

    public void setPaths(List<List<List<Double>>> paths) {
        this.paths = paths;
    }

    public Geometry withPaths(List<List<List<Double>>> paths) {
        this.paths = paths;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("paths"+ paths).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(paths);
    }

    public int describeContents() {
        return  0;
    }

}
