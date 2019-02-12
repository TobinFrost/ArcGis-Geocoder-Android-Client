
package com.super_dev.arcgis.geocoding.find.address;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Attributes implements Parcelable
{

    @SerializedName("Match_addr")
    @Expose
    private String matchAddr;
    @SerializedName("Addr_type")
    @Expose
    private String addrType;
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
        this.matchAddr = ((String) in.readValue((String.class.getClassLoader())));
        this.addrType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes() {
    }

    public String getMatchAddr() {
        return matchAddr;
    }

    public void setMatchAddr(String matchAddr) {
        this.matchAddr = matchAddr;
    }

    public Attributes withMatchAddr(String matchAddr) {
        this.matchAddr = matchAddr;
        return this;
    }

    public String getAddrType() {
        return addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    public Attributes withAddrType(String addrType) {
        this.addrType = addrType;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("matchAddr"+ matchAddr).append("addrType"+ addrType).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(matchAddr);
        dest.writeValue(addrType);
    }

    public int describeContents() {
        return  0;
    }

}
