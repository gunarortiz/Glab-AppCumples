package com.gunar.cumple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gunar.cumple.adapter.RecyclerAdapter;
import com.gunar.cumple.model.Cumple;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nombre, fecha;
    Button boton;

    private List<Cumple> soliList = new ArrayList<>();
    private RecyclerView soliRecycler;
    private RecyclerAdapter soliAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nNombre);
        fecha = (EditText) findViewById(R.id.nFecha);

        soliRecycler = (RecyclerView) findViewById(R.id.re);
        soliAdapter = new RecyclerAdapter(soliList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        soliRecycler.setLayoutManager(mLayoutManager);

        soliRecycler.setAdapter(soliAdapter);


        boton = (Button) findViewById(R.id.nBoton);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }


    String days(String cumple){
        try {
            //Dates to compare
            int year = Calendar.getInstance().get(Calendar.YEAR);

            String CurrentDate=  "09/24/2015";
            String FinalDate=  cumple.substring(0, 6)+year;

            Date date1;
            Date date2;

            SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

            //Setting dates
            date1 = dates.parse(CurrentDate);
            date2 = dates.parse(FinalDate);

            //Comparing dates
            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);

            //Convert long to String
            String dayDifference = Long.toString(differenceDates);

            return dayDifference;
        }
        catch (Exception exception) {
            Log.e("DIDN'T WORK", "exception " + exception);
        }
        return "";
    }
}
