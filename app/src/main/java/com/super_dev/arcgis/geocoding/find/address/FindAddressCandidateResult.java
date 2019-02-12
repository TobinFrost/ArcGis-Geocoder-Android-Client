
package com.super_dev.arcgis.geocoding.find.address;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FindAddressCandidateResult implements Parcelable
{

    @SerializedName("spatialReference")
    @Expose
    private SpatialReference spatialReference;
    @SerializedName("candidates")
    @Expose
    private List<Candidate> candidates = new ArrayList<Candidate>();
    public final static Creator<FindAddressCandidateResult> CREATOR = new Creator<FindAddressCandidateResult>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FindAddressCandidateResult createFromParcel(Parcel in) {
            return new FindAddressCandidateResult(in);
        }

        public FindAddressCandidateResult[] newArray(int size) {
            return (new FindAddressCandidateResult[size]);
        }

    }
    ;

    protected FindAddressCandidateResult(Parcel in) {
        this.spatialReference = ((SpatialReference) in.readValue((SpatialReference.class.getClassLoader())));
        in.readList(this.candidates, (Candidate.class.getClassLoader()));
    }

    public FindAddressCandidateResult() {
    }

    public SpatialReference getSpatialReference() {
        return spatialReference;
    }

    public void setSpatialReference(SpatialReference spatialReference) {
        this.spatialReference = spatialReference;
    }

    public FindAddressCandidateResult withSpatialReference(SpatialReference spatialReference) {
        this.spatialReference = spatialReference;
        return this;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public FindAddressCandidateResult withCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("spatialReference"+ spatialReference).append("candidates"+ candidates).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(spatialReference);
        dest.writeList(candidates);
    }

    public int describeContents() {
        return  0;
    }

}
