package com.thomas.cwr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    Integer yearLower = 0;
    Integer yearUpper = 0;
    Integer measureOld = 0;
    Integer measureNew = 0;
    ArrayList<Integer> oldYearsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);


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
        for (int i = 1; i < 65; i++) {
            oneToSixFour.add(i);
        }
        for (int i = currentYear - 20; i <= currentYear; i++) {
            oldYearsList.add(Integer.toString(i));
        }
        for (int i = currentYear - 20; i <= currentYear + 10; i++) {
            futureYearsList.add(Integer.toString(i));
        }
        final Spinner svMonthOld = findViewById(R.id.spinnerMonthOld);
        ArrayAdapter<String> adapterMonthOld = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, monthList);
        adapterMonthOld.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        svMonthOld.setAdapter(adapterMonthOld);
        svMonthOld.setSelection(currentMonth);

        final Spinner svMonthFuture = findViewById(R.id.spinnerMonthFuture);
        ArrayAdapter<String> adapterMonthFuture = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, monthList);
        svMonthFuture.setAdapter(adapterMonthFuture);
        svMonthFuture.setSelection(currentMonth);

        final Spinner svMonthCurrent = findViewById(R.id.spinnerMonthCurrent);
        ArrayAdapter<String> adapterMonthCurrent = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, monthList);
        svMonthCurrent.setAdapter(adapterMonthCurrent);
        svMonthCurrent.setSelection(currentMonth);
//
        final Spinner svYearOld = findViewById(R.id.spinnerYearOld);
        ArrayAdapter<String> adapterYearOld = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, oldYearsList);
        svYearOld.setAdapter(adapterYearOld);
        svYearOld.setSelection(oldYearsList.indexOf(Integer.toString(currentYear - 3)));

        final Spinner svYearFuture = findViewById(R.id.spinnerYearFuture);
        ArrayAdapter<String> adapterYearFuture = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, futureYearsList);
        svYearFuture.setAdapter(adapterYearFuture);
        svYearFuture.setSelection(futureYearsList.indexOf(Integer.toString(currentYear)));

        final Spinner svYearCurrent = findViewById(R.id.spinnerYearCurrent);
        ArrayAdapter<String> adapterYearCurrent = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, futureYearsList);
        svYearCurrent.setAdapter(adapterYearCurrent);
        svYearCurrent.setSelection(futureYearsList.indexOf(Integer.toString(currentYear)));

        final Spinner svMeasureFuture = findViewById(R.id.spinnerMeasureFuture);
        ArrayAdapter<Integer> adapterMeasureFuture = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, oneToSixFour);
        svMeasureFuture.setAdapter(adapterMeasureFuture);
        svMeasureFuture.setSelection(15);

        final Spinner svMeasureCurrent = findViewById(R.id.spinnerMeasureCurrent);
        ArrayAdapter<Integer> adapterMeasureCurrent = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, oneToSixFour);
        svMeasureCurrent.setAdapter(adapterMeasureCurrent);
        svMeasureCurrent.setSelection(31);

        final Spinner svMeasureOld = findViewById(R.id.spinnerMeasureOld);
        ArrayAdapter<Integer> adapterMeasureOld = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, oneToSixFour);
        svMeasureOld.setAdapter(adapterMeasureOld);
        svMeasureOld.setSelection(47);


        svMonthOld.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dateChanged(svMonthOld);}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        svMonthCurrent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dateChanged(svMonthCurrent);}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        svYearOld.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dateChanged(svYearOld);}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        svYearCurrent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dateChanged(svYearCurrent);}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        svMeasureOld.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dateChanged(svMeasureOld);}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        svMeasureCurrent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dateChanged(svMeasureCurrent);}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        svMeasureFuture.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dateChanged(svMeasureFuture);}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

    }
    public void dateChanged(View view){
        Spinner svMO = findViewById(R.id.spinnerMonthOld);
        int intMO = svMO.getSelectedItemPosition()+1;
        Spinner svMC = findViewById(R.id.spinnerMonthCurrent);
        int intMC = svMC.getSelectedItemPosition()+1;
        Spinner svMF = findViewById(R.id.spinnerMonthFuture);
        int intMF = svMF.getSelectedItemPosition()+1;

        Spinner svYO = findViewById(R.id.spinnerYearOld);
        int intYO = (Integer) Integer.parseInt(svYO.getSelectedItem().toString());
        Spinner svYC = findViewById(R.id.spinnerYearCurrent);
        int intYC = (Integer) Integer.parseInt(svYC.getSelectedItem().toString());
        Spinner svYF = findViewById(R.id.spinnerYearFuture);
        int intYF = (Integer) Integer.parseInt(svYF.getSelectedItem().toString());

        Spinner svSO = findViewById(R.id.spinnerMeasureOld);
        int intSO =  svSO.getSelectedItemPosition()+1;
        Spinner svSC = findViewById(R.id.spinnerMeasureCurrent);
        int intSC = svSC.getSelectedItemPosition()+1;
        Spinner svSF = findViewById(R.id.spinnerMeasureFuture);
        int intSF = svSF.getSelectedItemPosition()+1;



        int intMeasureDifference = intSO-intSC;

        if (intMeasureDifference>0) {
        int monthsOld=intYO*12+intMO;
        int monthsCurrent = intYC*12+intMC;
        int monthsDifference=monthsCurrent-monthsOld;
        float changeRate = intMeasureDifference*1.0f/(monthsDifference* 1.0f);
        int wearToGo = intSC-intSF;
        double monthsToGO = Math.ceil(wearToGo*1.0/changeRate*1.0);
        double futureMonth = (((monthsToGO)%12)+intMC)%12;
        double futureYear = Math.floor((monthsToGO+intMC)/12+intYC);
            if(futureMonth==0){
                futureMonth=12;
                futureYear=futureYear-1;
            }
            Log.i("tomm",""+futureMonth);
        svMF.setSelection((int) futureMonth-1);
            Log.i("tomm",""+futureYear);
        svYF.setSelection((int) futureYear-Calendar.getInstance().get(Calendar.YEAR)+20);

        }
//            svMF.setSelection(monthsYearsOut);
//            svYF.setSelection(yearPosition);
//        }


    }

}


