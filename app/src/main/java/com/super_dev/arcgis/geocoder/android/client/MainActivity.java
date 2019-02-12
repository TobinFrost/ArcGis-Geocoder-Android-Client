package com.super_dev.arcgis.geocoder.android.client;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.super_dev.arcgis.geocoder.android.client.adapter.SuggestAdapter;
import com.super_dev.arcgis.geocoding.operator.ApiCall;
import com.super_dev.arcgis.geocoding.suggestion.Suggestion;
import com.super_dev.arcgis.geocoding.suggestion.SuggestionUrlBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int TRIGGER_AUTO_COMPLETE = 100;
    private static final long AUTO_COMPLETE_DELAY = 300;
    private Handler handler;

    private SuggestAdapter suggestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.auto_complete_edit_text);
        final TextView selectedText =  (TextView) findViewById(R.id.selected_address);

        final SuggestionUrlBuilder suggestionUrlBuilder = new SuggestionUrlBuilder();
        suggestionUrlBuilder.setCountryCode("SN");
        suggestionUrlBuilder.setF("json");

        //Setting up the adapter for AutoSuggest
        suggestAdapter = new SuggestAdapter(this,
                android.R.layout.simple_dropdown_item_1line);
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setAdapter(suggestAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                autoCompleteTextView.setText(suggestAdapter.getItem(i).getText());
                selectedText.setText(suggestAdapter.getItem(i).getText());
            }
        });

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                handler.removeMessages(TRIGGER_AUTO_COMPLETE);
                handler.sendEmptyMessageDelayed(TRIGGER_AUTO_COMPLETE,
                        AUTO_COMPLETE_DELAY);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == TRIGGER_AUTO_COMPLETE) {
                    if (!TextUtils.isEmpty(autoCompleteTextView.getText())) {
                        suggestionUrlBuilder.getSuggestionUriBuilder().clearQuery();
                        suggestionUrlBuilder.setText(autoCompleteTextView.getText().toString());
                        String url = suggestionUrlBuilder.getSuggestionURL();
                        makeSuggestionApiCall(url);
                    }
                }
                return false;
            }
        });

    }

    private void makeSuggestionApiCall(String url) {
        ApiCall.make(this, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                List<Suggestion> suggestionList = new ArrayList<>();
                try {
                    JSONArray suggestions = response.getJSONArray("suggestions");

                    for (int i = 0; i < suggestions.length(); i ++ ) {

                        JSONObject result = suggestions.getJSONObject(i);
                        String result_text = result.getString("text");
                        String result_magicKey = result.getString("magicKey");
                        Boolean result_isCollection = result.getBoolean("isCollection");

                        Suggestion suggestion = new Suggestion();
                        suggestion.setText(result_text);
                        suggestion.setMagicKey(result_magicKey);
                        suggestion.setIsCollection(result_isCollection);

                        suggestionList.add(suggestion);
                    }

                } catch (JSONException e) {
                    Log.v("JSON", "EXC: " + e.getLocalizedMessage());
                }
                suggestAdapter.setData(suggestionList);
                suggestAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("API", "Err" + error.getLocalizedMessage());
            }
        });
    }
}
