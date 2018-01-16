package com.example.jakup.drcentyl;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.joda.time.Months;

import java.util.ArrayList;

import static com.example.jakup.drcentyl.lib.Poly.boysBmi18_90;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight12_10;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight12_25;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight12_3;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight12_50;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight12_75;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight12_90;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight12_97;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight18_10;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight18_25;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight18_3;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight18_50;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight18_75;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight18_90;
import static com.example.jakup.drcentyl.lib.Poly.boysHeight18_97;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight12_10;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight12_25;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight12_3;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight12_50;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight12_75;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight12_90;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight12_97;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight18_10;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight18_25;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight18_3;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight18_50;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight18_75;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight18_90;
import static com.example.jakup.drcentyl.lib.Poly.boysWeight18_97;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight12_10;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight12_25;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight12_3;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight12_50;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight12_75;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight12_90;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight12_97;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight18_10;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight18_25;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight18_3;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight18_50;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight18_75;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight18_90;
import static com.example.jakup.drcentyl.lib.Poly.girlsHeight18_97;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight12_10;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight12_25;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight12_3;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight12_50;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight12_75;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight12_90;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight12_97;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight18_10;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight18_25;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight18_3;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight18_50;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight18_75;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight18_90;
import static com.example.jakup.drcentyl.lib.Poly.girlsWeight18_97;

public class Charts extends AppCompatActivity {

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        Intent intent = getIntent();

        Double height = intent.getDoubleExtra("wzrost",100.0);
        Double weight = intent.getDoubleExtra("waga",40);
        Double ageNumber = intent.getDoubleExtra("lata", 3);
        Double monthsNumber = intent.getDoubleExtra("miesiace", 3);
        String sex = intent.getStringExtra("plec");
        String message = intent.getStringExtra("message");

        float heightAmount = height.floatValue();
        float weightAmount = weight.floatValue();
        float ageAmount = ageNumber.floatValue();
        float monthsAmount = monthsNumber.floatValue();

        lineChart = (LineChart) findViewById(R.id.lineChart);

        Highlight highlight = null;

        ArrayList<Entry> yAX97 = new ArrayList<>();
        ArrayList<Entry> yAX90 = new ArrayList<>();
        ArrayList<Entry> yAX75 = new ArrayList<>();
        ArrayList<Entry> yAX50 = new ArrayList<>();
        ArrayList<Entry> yAX25 = new ArrayList<>();
        ArrayList<Entry> yAX10 = new ArrayList<>();
        ArrayList<Entry> yAX3 = new ArrayList<>();
        ArrayList<Entry> yAXpoint = new ArrayList<>();


        float function97;
        float function90;
        float function75;
        float function50;
        float function25;
        float function10;
        float function3;
        float add = (float) 0.1;;

        double x = 1 ;
        int values = 0;

        if(message.equals("wzrost")) { //charts of height
            //charts for boys height
            if (sex.equals("męska")) if (ageAmount == 0) { //less than 1 year old
                Entry c1e1 = new Entry(monthsAmount, heightAmount);
                yAXpoint.add(c1e1);

                values = 12;
                for (float i = 1; x < values; i = i+add) {
                    function97 = Float.parseFloat(String.valueOf(boysHeight12_97(x)));
                    function90 = Float.parseFloat(String.valueOf(boysHeight12_90(x)));
                    function75 = Float.parseFloat(String.valueOf(boysHeight12_75(x)));
                    function50 = Float.parseFloat(String.valueOf(boysHeight12_50(x)));
                    function25 = Float.parseFloat(String.valueOf(boysHeight12_25(x)));
                    function10 = Float.parseFloat(String.valueOf(boysHeight12_10(x)));
                    function3 = Float.parseFloat(String.valueOf(boysHeight12_3(x)));

                    x = x + 0.1;

                    yAX97.add(new Entry(i, function97));
                    yAX90.add(new Entry(i, function90));
                    yAX75.add(new Entry(i, function75));
                    yAX50.add(new Entry(i, function50));
                    yAX25.add(new Entry(i, function25));
                    yAX10.add(new Entry(i, function10));
                    yAX3.add(new Entry(i, function3));
                }
            } else { //boys height 1-18 years

                Entry c1e1 = new Entry(ageAmount, heightAmount);
                yAXpoint.add(c1e1);

                values = 17;
                for (float i = 1; x < values; i = i+add) {
                    function97 = Float.parseFloat(String.valueOf(boysHeight18_97(x)));
                    function90 = Float.parseFloat(String.valueOf(boysHeight18_90(x)));
                    function75 = Float.parseFloat(String.valueOf(boysHeight18_75(x)));
                    function50 = Float.parseFloat(String.valueOf(boysHeight18_50(x)));
                    function25 = Float.parseFloat(String.valueOf(boysHeight18_25(x)));
                    function10 = Float.parseFloat(String.valueOf(boysHeight18_10(x)));
                    function3 = Float.parseFloat(String.valueOf(boysHeight18_3(x)));

                    x = x + 0.1;

                    yAX97.add(new Entry(i, function97));
                    yAX90.add(new Entry(i, function90));
                    yAX75.add(new Entry(i, function75));
                    yAX50.add(new Entry(i, function50));
                    yAX25.add(new Entry(i, function25));
                    yAX10.add(new Entry(i, function10));
                    yAX3.add(new Entry(i, function3));
                }
            }
            else { //charts for girls height
                if (ageAmount == 0) {//less than 1 year
                    Entry c1e1 = new Entry(monthsAmount, heightAmount);
                    yAXpoint.add(c1e1);

                    values = 12;
                    for (float i = 1; x < values; i = i+add) {
                        function97 = Float.parseFloat(String.valueOf(girlsHeight12_97(x)));
                        function90 = Float.parseFloat(String.valueOf(girlsHeight12_90(x)));
                        function75 = Float.parseFloat(String.valueOf(girlsHeight12_75(x)));
                        function50 = Float.parseFloat(String.valueOf(girlsHeight12_50(x)));
                        function25 = Float.parseFloat(String.valueOf(girlsHeight12_25(x)));
                        function10 = Float.parseFloat(String.valueOf(girlsHeight12_10(x)));
                        function3 = Float.parseFloat(String.valueOf(girlsHeight12_3(x)));

                        x = x + 0.1;

                        yAX97.add(new Entry(i, function97));
                        yAX90.add(new Entry(i, function90));
                        yAX75.add(new Entry(i, function75));
                        yAX50.add(new Entry(i, function50));
                        yAX25.add(new Entry(i, function25));
                        yAX10.add(new Entry(i, function10));
                        yAX3.add(new Entry(i, function3));
                    }
                } else { //girls height 1-18 years
                    Entry c1e1 = new Entry(ageAmount, heightAmount);
                    yAXpoint.add(c1e1);

                    values = 17;
                    for (float i = 1; x < values; i = i+add) {
                        function97 = Float.parseFloat(String.valueOf(girlsHeight18_97(x)));
                        function90 = Float.parseFloat(String.valueOf(girlsHeight18_90(x)));
                        function75 = Float.parseFloat(String.valueOf(girlsHeight18_75(x)));
                        function50 = Float.parseFloat(String.valueOf(girlsHeight18_50(x)));
                        function25 = Float.parseFloat(String.valueOf(girlsHeight18_25(x)));
                        function10 = Float.parseFloat(String.valueOf(girlsHeight18_10(x)));
                        function3 = Float.parseFloat(String.valueOf(girlsHeight18_3(x)));

                        x = x + 0.1;

                        yAX97.add(new Entry(i, function97));
                        yAX90.add(new Entry(i, function90));
                        yAX75.add(new Entry(i, function75));
                        yAX50.add(new Entry(i, function50));
                        yAX25.add(new Entry(i, function25));
                        yAX10.add(new Entry(i, function10));
                        yAX3.add(new Entry(i, function3));
                    }
                }
            }
        }else{ //charts of WEIGHT
            //charts for boys weight
            if (sex.equals("męska")) if (ageAmount == 0) { //less than 1 year old
                Entry c1e1 = new Entry(monthsAmount, weightAmount);
                yAXpoint.add(c1e1);

                values = 12;
                for (float i = 1; x < values; i = i + add) {
                    function97 = Float.parseFloat(String.valueOf(boysWeight12_97(x)));
                    function90 = Float.parseFloat(String.valueOf(boysWeight12_90(x)));
                    function75 = Float.parseFloat(String.valueOf(boysWeight12_75(x)));
                    function50 = Float.parseFloat(String.valueOf(boysWeight12_50(x)));
                    function25 = Float.parseFloat(String.valueOf(boysWeight12_25(x)));
                    function10 = Float.parseFloat(String.valueOf(boysWeight12_10(x)));
                    function3 = Float.parseFloat(String.valueOf(boysWeight12_3(x)));

                    x = x + 0.1;

                    yAX97.add(new Entry(i, function97));
                    yAX90.add(new Entry(i, function90));
                    yAX75.add(new Entry(i, function75));
                    yAX50.add(new Entry(i, function50));
                    yAX25.add(new Entry(i, function25));
                    yAX10.add(new Entry(i, function10));
                    yAX3.add(new Entry(i, function3));
                }
            } else {//boys weight 1-18 years
                Entry c1e1 = new Entry(ageAmount, weightAmount);
                yAXpoint.add(c1e1);

                values = 17;
                for (float i = 1; x < values; i = i + add) {
                    function97 = Float.parseFloat(String.valueOf(boysWeight18_97(x)));
                    function90 = Float.parseFloat(String.valueOf(boysWeight18_90(x)));
                    function75 = Float.parseFloat(String.valueOf(boysWeight18_75(x)));
                    function50 = Float.parseFloat(String.valueOf(boysWeight18_50(x)));
                    function25 = Float.parseFloat(String.valueOf(boysWeight18_25(x)));
                    function10 = Float.parseFloat(String.valueOf(boysWeight18_10(x)));
                    function3 = Float.parseFloat(String.valueOf(boysWeight18_3(x)));

                    x = x + 0.1;

                    yAX97.add(new Entry(i, function97));
                    yAX90.add(new Entry(i, function90));
                    yAX75.add(new Entry(i, function75));
                    yAX50.add(new Entry(i, function50));
                    yAX25.add(new Entry(i, function25));
                    yAX10.add(new Entry(i, function10));
                    yAX3.add(new Entry(i, function3));
                }
            }
            else { //charts for girls weight
                if (ageAmount == 0) { //less that 1 year
                    Entry c1e1 = new Entry(monthsAmount, weightAmount);
                    yAXpoint.add(c1e1);

                    values = 12;
                    for (float i = 1; x < values; i = i+add) {
                        function97 = Float.parseFloat(String.valueOf(girlsWeight12_97(x)));
                        function90 = Float.parseFloat(String.valueOf(girlsWeight12_90(x)));
                        function75 = Float.parseFloat(String.valueOf(girlsWeight12_75(x)));
                        function50 = Float.parseFloat(String.valueOf(girlsWeight12_50(x)));
                        function25 = Float.parseFloat(String.valueOf(girlsWeight12_25(x)));
                        function10 = Float.parseFloat(String.valueOf(girlsWeight12_10(x)));
                        function3 = Float.parseFloat(String.valueOf(girlsWeight12_3(x)));

                        x = x + 0.1;

                        yAX97.add(new Entry(i, function97));
                        yAX90.add(new Entry(i, function90));
                        yAX75.add(new Entry(i, function75));
                        yAX50.add(new Entry(i, function50));
                        yAX25.add(new Entry(i, function25));
                        yAX10.add(new Entry(i, function10));
                        yAX3.add(new Entry(i, function3));
                    }
                } else { //girls weight 1-18 years
                    Entry c1e1 = new Entry(ageAmount, weightAmount);
                    yAXpoint.add(c1e1);

                    values = 17;
                    for (float i = 1; x < values; i = i+add) {
                        function97 = Float.parseFloat(String.valueOf(girlsWeight18_97(x)));
                        function90 = Float.parseFloat(String.valueOf(girlsWeight18_90(x)));
                        function75 = Float.parseFloat(String.valueOf(girlsWeight18_75(x)));
                        function50 = Float.parseFloat(String.valueOf(girlsWeight18_50(x)));
                        function25 = Float.parseFloat(String.valueOf(girlsWeight18_25(x)));
                        function10 = Float.parseFloat(String.valueOf(girlsWeight18_10(x)));
                        function3 = Float.parseFloat(String.valueOf(girlsWeight18_3(x)));

                        x = x + 0.1;

                        yAX97.add(new Entry(i, function97));
                        yAX90.add(new Entry(i, function90));
                        yAX75.add(new Entry(i, function75));
                        yAX50.add(new Entry(i, function50));
                        yAX25.add(new Entry(i, function25));
                        yAX10.add(new Entry(i, function10));
                        yAX3.add(new Entry(i, function3));
                    }
                }
            }
      }
        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet lineDataSet1 = new LineDataSet(yAX3,"3");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.BLUE);

        LineDataSet lineDataSet2 = new LineDataSet(yAX10,"10");
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColor(Color.GREEN);

        LineDataSet lineDataSet3 = new LineDataSet(yAX25,"25");
        lineDataSet3.setDrawCircles(false);
        lineDataSet3.setColor(Color.RED);

        LineDataSet lineDataSet4 = new LineDataSet(yAX50,"50");
        lineDataSet4.setDrawCircles(false);
        lineDataSet4.setColor(Color.YELLOW);

        LineDataSet lineDataSet5 = new LineDataSet(yAX75,"75");
        lineDataSet5.setDrawCircles(false);
        lineDataSet5.setColor(Color.CYAN);

        LineDataSet lineDataSet6 = new LineDataSet(yAX90,"90");
        lineDataSet6.setDrawCircles(false);
        lineDataSet6.setColor(Color.MAGENTA);

        LineDataSet lineDataSet7 = new LineDataSet(yAX97,"97");
        lineDataSet7.setDrawCircles(false);
        lineDataSet7.setColor(Color.BLACK);

        LineDataSet lineDataSet8 = new LineDataSet(yAXpoint,"C");
        lineDataSet8.setDrawCircles(true);

        lineDataSets.add(lineDataSet1);
        lineDataSets.add(lineDataSet2);
        lineDataSets.add(lineDataSet3);
        lineDataSets.add(lineDataSet4);
        lineDataSets.add(lineDataSet5);
        lineDataSets.add(lineDataSet6);
        lineDataSets.add(lineDataSet7);
        lineDataSets.add(lineDataSet8);

        lineDataSet1.setDrawValues(false);
        lineDataSet2.setDrawValues(false);
        lineDataSet3.setDrawValues(false);
        lineDataSet4.setDrawValues(false);
        lineDataSet5.setDrawValues(false);
        lineDataSet6.setDrawValues(false);
        lineDataSet7.setDrawValues(false);

        lineChart.setData(new LineData(lineDataSets));
    }
}
