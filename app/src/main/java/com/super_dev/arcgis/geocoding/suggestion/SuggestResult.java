
package com.super_dev.arcgis.geocoding.suggestion;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SuggestResult implements Parcelable
{

    @SerializedName("suggestions")
    @Expose
    private List<Suggestion> suggestions = new ArrayList<Suggestion>();
    public final static Parcelable.Creator<SuggestResult> CREATOR = new Creator<SuggestResult>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SuggestResult createFromParcel(Parcel in) {
            return new SuggestResult(in);
        }

        public SuggestResult[] newArray(int size) {
            return (new SuggestResult[size]);
        }

    }
    ;

    protected SuggestResult(Parcel in) {
        in.readList(this.suggestions, (Suggestion.class.getClassLoader()));
    }

    public SuggestResult() {
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public SuggestResult withSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("suggestions"+ suggestions).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(suggestions);
    }

    public int describeContents() {
        return  0;
    }

}
