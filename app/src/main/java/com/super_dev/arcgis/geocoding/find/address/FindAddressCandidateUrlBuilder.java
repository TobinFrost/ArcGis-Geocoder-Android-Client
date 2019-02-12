package com.super_dev.arcgis.geocoding.find.address;

import android.net.Uri;

import com.super_dev.arcgis.geocoding.constants.Constants;

public class FindAddressCandidateUrlBuilder {

    private Uri.Builder findAddressUriBuilder;
    private String findAddressURL;

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

        findAddressURL = findAddressUriBuilder.build().toString();
    }

    public String getFindAddressURL() {
        return findAddressURL;
    }

    public Uri.Builder getFindAddressUriBuilder() {
        return findAddressUriBuilder;
    }

    public void setMagicKey(String magicKey) {
        getFindAddressUriBuilder().appendQueryParameter(Constants.MAGIC_KEY, magicKey);
    }

    public void setSingleLine(String singleLine) {
        getFindAddressUriBuilder().appendQueryParameter(Constants.SINGLE_LINE, singleLine);
    }

    public void setOutField(String outField) {
        getFindAddressUriBuilder().appendQueryParameter(Constants.OUTFIELDS, outField);
    }

    public void setF(String f) {
        getFindAddressUriBuilder().appendQueryParameter(Constants.F, Constants.F_JSON);
    }

    public void setCountryCode(String countryCode) {
        getFindAddressUriBuilder().appendQueryParameter(Constants.COUNTRY_CODE, countryCode);
    }


}
