
package com.super_dev.arcgis.routing;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Routes implements Parcelable
{

    @SerializedName("fieldAliases")
    @Expose
    private FieldAliases fieldAliases;
    @SerializedName("geometryType")
    @Expose
    private String geometryType;
    @SerializedName("spatialReference")
    @Expose
    private SpatialReference spatialReference;
    @SerializedName("features")
    @Expose
    private List<Feature> features = new ArrayList<Feature>();
    public final static Creator<Routes> CREATOR = new Creator<Routes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Routes createFromParcel(Parcel in) {
            return new Routes(in);
        }

        public Routes[] newArray(int size) {
            return (new Routes[size]);
        }

    }
    ;

    protected Routes(Parcel in) {
        this.fieldAliases = ((FieldAliases) in.readValue((FieldAliases.class.getClassLoader())));
        this.geometryType = ((String) in.readValue((String.class.getClassLoader())));
        this.spatialReference = ((SpatialReference) in.readValue((SpatialReference.class.getClassLoader())));
        in.readList(this.features, (Feature.class.getClassLoader()));
    }

    public Routes() {
    }

    public FieldAliases getFieldAliases() {
        return fieldAliases;
    }

    public void setFieldAliases(FieldAliases fieldAliases) {
        this.fieldAliases = fieldAliases;
    }

    public Routes withFieldAliases(FieldAliases fieldAliases) {
        this.fieldAliases = fieldAliases;
        return this;
    }

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public Routes withGeometryType(String geometryType) {
        this.geometryType = geometryType;
        return this;
    }

    public SpatialReference getSpatialReference() {
        return spatialReference;
    }

    public void setSpatialReference(SpatialReference spatialReference) {
        this.spatialReference = spatialReference;
    }

    public Routes withSpatialReference(SpatialReference spatialReference) {
        this.spatialReference = spatialReference;
        return this;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Routes withFeatures(List<Feature> features) {
        this.features = features;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("fieldAliases"+ fieldAliases).append("geometryType"+ geometryType).append("spatialReference"+ spatialReference).append("features"+ features).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fieldAliases);
        dest.writeValue(geometryType);
        dest.writeValue(spatialReference);
        dest.writeList(features);
    }

    public int describeContents() {
        return  0;
    }

}
