package com.super_dev.arcgis.geocoding.find.address;

import android.net.Uri;

import com.super_dev.arcgis.geocoding.constants.Constants;

public class FindAddressCandidateUrlBuilder {

    private Uri.Builder findAddressUriBuilder;
    private String findAddressURL;
    private String countryCode;
    private String singleLine;
    private String magicKey;
    private String outField;
    private String f;

    public FindAddressCandidateUrlBuilder() {
        findAddressUriBuilder = new Uri.Builder();
        findAddressUriBuilder.scheme(Constants.SHEME)
                .authority(Constants.AUTHORITY)
                .appendPath(Constants.PATH1)
                .appendPath(Constants.PATH2)
                .appendPath(Constants.PATH3)
                .appendPath(Constants.PATH4)
                .appendPath(Constants.PATH5)
                .appendPath(Constants.FINDADDRESS_PATH);

        setCountryCode("");
        setMagicKey("");
        setOutField("");
        setSingleLine("");
        setF("");

        findAddressURL = findAddressUriBuilder.build().toString();
    }

    public String getFindAddressURL() {
        getFindAddressUriBuilder().appendQueryParameter(Constants.MAGIC_KEY, magicKey);
        getFindAddressUriBuilder().appendQueryParameter(Constants.OUTFIELDS, outField);
        getFindAddressUriBuilder().appendQueryParameter(Constants.F, Constants.F_JSON);
        getFindAddressUriBuilder().appendQueryParameter(Constants.COUNTRY_CODE, countryCode);
        getFindAddressUriBuilder().appendQueryParameter(Constants.SINGLE_LINE, singleLine);
        findAddressURL = findAddressUriBuilder.build().toString();
        return findAddressURL;
    }

    public Uri.Builder getFindAddressUriBuilder() {
        return findAddressUriBuilder;
    }

    public void setMagicKey(String magicKey) {
        this.magicKey = magicKey;
    }

    public void setSingleLine(String singleLine) {
        this.singleLine = singleLine;
    }

    public void setOutField(String outField) {
        this.outField = outField;
    }

    public void setF(String f) {
        this.f = f;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


}
