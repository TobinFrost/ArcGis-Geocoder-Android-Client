
package com.super_dev.arcgis.routing.request;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeatureRouteRequest implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<Feature> features = new ArrayList<Feature>();
    public final static Creator<FeatureRouteRequest> CREATOR = new Creator<FeatureRouteRequest>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FeatureRouteRequest createFromParcel(Parcel in) {
            return new FeatureRouteRequest(in);
        }

        public FeatureRouteRequest[] newArray(int size) {
            return (new FeatureRouteRequest[size]);
        }

    }
    ;

    protected FeatureRouteRequest(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.features, (Feature.class.getClassLoader()));
    }

    public FeatureRouteRequest() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FeatureRouteRequest withType(String type) {
        this.type = type;
        return this;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public FeatureRouteRequest withFeatures(List<Feature> features) {
        this.features = features;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeList(features);
    }

    public int describeContents() {
        return  0;
    }

}
