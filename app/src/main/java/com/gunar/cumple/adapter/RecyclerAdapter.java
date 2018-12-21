package com.gunar.cumple.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gunar.cumple.R;
import com.gunar.cumple.model.Cumple;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Cumple> soliList;
    private static ClickListener clickListener;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre, fecha, dias;

        public MyViewHolder(View view) {
            super(view);

            nombre = (TextView) view.findViewById(R.id.nombre);
            fecha = (TextView) view.findViewById(R.id.fecha);
            dias = (TextView) view.findViewById(R.id.dias);
        }
    }

    public RecyclerAdapter(List<Cumple> myDataset) {
        soliList = myDataset;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Cumple soli = soliList.get(position);

        holder.nombre.setText(soli.getNombre());
        holder.fecha.setText(soli.getFecha());
        holder.dias.setText(days(soli.getFecha()));
    }

    @Override
    public int getItemCount() {
        return soliList.size();
    }


    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);

    }


    String days(String cumple){
        try {
            //Dates to compare
            int year = Calendar.getInstance().get(Calendar.YEAR);



            SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
            String CurrentDate=  dates.format(new Date());

            String FinalDate=  cumple.substring(0, 6)+year;

            Date date1;
            Date date2;

            //Setting dates
            date1 = dates.parse(CurrentDate);
            date2 = dates.parse(FinalDate);

            //Comparing dates
            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);

            //Convert long to String
            String dayDifference = Long.toString(differenceDates);

            return "faltan " + dayDifference + " dias";
        }
        catch (Exception exception) {
            Log.e("DIDN'T WORK", "exception " + exception);
        }
        return "";
    }


}



