package com.example.itachi.cds.add_crime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.itachi.cds.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

/**
 * Created by itachi on 30/3/18.
 */

public class add_crime_fragment  extends Fragment {



    private Spinner crime_spinner;
    private Spinner gender_spinner_victim;
    private Spinner gender_spinner_suspect;
    private Spinner agegroup_spinner_victim;
    private Spinner agegroup_spinner_suspect;
    private Spinner relation;
    private Button submit_button;


    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private int hour, min;
    private TextView time;
    FirebaseDatabase fdb ;
    DatabaseReference mdbr ;
    EditText victim_name_edittext,latitude_edittext,longitude_edittext;

    String victim_age_group="---",suspect_age_group="---",suspect_relation="---";
    int crime_longitude,crime_latitude;

    ChildEventListener cel;



    String crime_type,gender_type_victim,gender_type_suspect="---";






    public static add_crime_fragment  initalizeview(){
        return new add_crime_fragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_crime_fragment,container,false);
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }



}

