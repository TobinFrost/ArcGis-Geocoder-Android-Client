package com.super_dev.arcgis.geocoding.suggestion;

import android.net.Uri;

import com.super_dev.arcgis.geocoding.constants.Constants;

public class SuggestionUrlBuilder {

    private Uri.Builder suggestionUriBuilder;

    private String suggestionURL;
    private String countryCode;
    private String text;
    private String f;

    public SuggestionUrlBuilder() {
        suggestionUriBuilder = new Uri.Builder();
        suggestionUriBuilder.scheme(Constants.SHEME)
                .authority(Constants.AUTHORITY)
                .appendPath(Constants.PATH1)
                .appendPath(Constants.PATH2)
                .appendPath(Constants.PATH3)
                .appendPath(Constants.PATH4)
                .appendPath(Constants.PATH5)
                .appendPath(Constants.SUGGEST_PATH);

        suggestionURL = suggestionUriBuilder.build().toString();
        setCountryCode("");
        setText("");
        setF("");
    }

    public Uri.Builder getSuggestionUriBuilder() {
        return suggestionUriBuilder;
    }


    public String getSuggestionURL() {
        getSuggestionUriBuilder().appendQueryParameter(Constants.COUNTRY_CODE, countryCode);
        getSuggestionUriBuilder().appendQueryParameter(Constants.TEXT, text);
        getSuggestionUriBuilder().appendQueryParameter(Constants.F, Constants.F_JSON);
        suggestionURL = suggestionUriBuilder.build().toString();
        return suggestionURL;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;

    }

    public void setText(String text) {
        this.text = text;

    }

    public void setF(String f) {
        this.f = f;

    }



}
