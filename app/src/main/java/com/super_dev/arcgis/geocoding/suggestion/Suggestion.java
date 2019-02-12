
package com.super_dev.arcgis.geocoding.suggestion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Suggestion implements Parcelable
{

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("magicKey")
    @Expose
    private String magicKey;
    @SerializedName("isCollection")
    @Expose
    private boolean isCollection;
    public final static Parcelable.Creator<Suggestion> CREATOR = new Creator<Suggestion>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Suggestion createFromParcel(Parcel in) {
            return new Suggestion(in);
        }

        public Suggestion[] newArray(int size) {
            return (new Suggestion[size]);
        }

    }
    ;

    protected Suggestion(Parcel in) {
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.magicKey = ((String) in.readValue((String.class.getClassLoader())));
        this.isCollection = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    public Suggestion() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Suggestion withText(String text) {
        this.text = text;
        return this;
    }

    public String getMagicKey() {
        return magicKey;
    }

    public void setMagicKey(String magicKey) {
        this.magicKey = magicKey;
    }

    public Suggestion withMagicKey(String magicKey) {
        this.magicKey = magicKey;
        return this;
    }

    public boolean isIsCollection() {
        return isCollection;
    }

    public void setIsCollection(boolean isCollection) {
        this.isCollection = isCollection;
    }

    public Suggestion withIsCollection(boolean isCollection) {
        this.isCollection = isCollection;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("text"+ text).append("magicKey"+ magicKey).append("isCollection"+ isCollection).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(text);
        dest.writeValue(magicKey);
        dest.writeValue(isCollection);
    }

    public int describeContents() {
        return  0;
    }

}
