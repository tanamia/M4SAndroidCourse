package com.example.aminatambengue.stateslistproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware","Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri","Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
        List<String> USstates = new ArrayList<String>(Arrays.asList(states));

        ArrayAdapter<String> USAdapter = new ArrayAdapter<String>(getActivity(),
            R.layout.textview,
             R.id.textviewitem,
                USstates);

        ListView lv = (ListView) rootView.findViewById(R.id.listviewlayout);
        lv.setAdapter(USAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  if (position == 2){
                      Intent intent = new Intent(getActivity(), MapsActivity.class);
                      startActivity(intent);
                  }
              }

           });



        return rootView;
    }
}
