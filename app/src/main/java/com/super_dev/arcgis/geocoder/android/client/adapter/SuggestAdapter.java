package com.super_dev.arcgis.geocoder.android.client.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.super_dev.arcgis.geocoder.android.client.R;
import com.super_dev.arcgis.geocoding.suggestion.Suggestion;

import java.util.ArrayList;
import java.util.List;

public class SuggestAdapter extends ArrayAdapter<Suggestion> implements Filterable {

    private List<Suggestion> mlistData;
    public SuggestAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        mlistData = new ArrayList<>();
    }

    public void setData(List<Suggestion> list) {
        mlistData.clear();
        mlistData.addAll(list);
    }

    @Override
    public int getCount() {
        return mlistData.size();
    }

    @Nullable
    @Override
    public Suggestion getItem(int position) {
        return mlistData.get(position);
    }

    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView, @NonNull ViewGroup parent) {

        Suggestion  suggestion = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_suggestion_result, parent, false);
        }
        TextView txtResult = (TextView) convertView.findViewById(R.id.txt_suggestion_result);
        txtResult.setText(suggestion.getText());

        return convertView;
    }



        @NonNull
    @Override
    public Filter getFilter() {
        Filter dataFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.values = mlistData;
                    filterResults.count = mlistData.size();
                } else {
//                    perform filtering (oh yeah)
                    List<String> mList = new ArrayList<>();

                    for(Suggestion s: mlistData) {
                        if(s.getText().toUpperCase().startsWith(constraint.toString().toUpperCase())){
                            mList.add(s.getText());
                        }
                    }
                    filterResults.values = mList;
                    filterResults.count = mList.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && (results.count > 0)) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return dataFilter;
    }
}
