package com.thomas.cwr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Integer yearLower = 0;
    Integer yearUpper = 0;
    Integer measureOld = 0;
    Integer measureNew = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);



        Log.i("TOMM onCreate",Integer.toString(currentYear));
        Log.i("TOMM onCreate",Integer.toString(currentMonth));


        final List<Integer> oneToSixFour = new ArrayList<>();
        final List<String> oldYearsList = new ArrayList<>();
        final List<String> futureYearsList = new ArrayList<>();
        final List<String> monthList = new ArrayList<>();
        monthList.add("Jan");
        monthList.add("Feb");
        monthList.add("Mar");
        monthList.add("Apr");
        monthList.add("May");
        monthList.add("Jun");
        monthList.add("Jul");
        monthList.add("Aug");
        monthList.add("Sep");
        monthList.add("Oct");
        monthList.add("Nov");
        monthList.add("Dec");
        for(int i=1; i<65; i++){
            oneToSixFour.add(i);
        }
        for(int i=currentYear-20; i<=currentYear; i++){
            oldYearsList.add(Integer.toString(i));
        }
        for(int i=currentYear-20; i<=currentYear+10; i++){
            futureYearsList.add(Integer.toString(i));
        }
        Spinner svMonthOld = findViewById(R.id.spinnerMonthOld);
        ArrayAdapter<String> adapterMonthOld = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, monthList);
        adapterMonthOld.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        svMonthOld.setAdapter(adapterMonthOld);
        svMonthOld.setSelection(currentMonth);

        Spinner svMonthFuture = findViewById(R.id.spinnerMonthFuture);
        ArrayAdapter<String> adapterMonthFuture = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, monthList);
        adapterMonthFuture.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        svMonthFuture.setAdapter(adapterMonthFuture);
        svMonthFuture.setSelection(currentMonth);

        Spinner svMonthCurrent = findViewById(R.id.spinnerMonthCurrent);
        ArrayAdapter<String> adapterMonthCurrent = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, monthList);
        adapterMonthCurrent.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        svMonthCurrent.setAdapter(adapterMonthCurrent);
        svMonthCurrent.setSelection(currentMonth);

    }
}
