package com.gunar.cumple.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gunar.cumple.R;
import com.gunar.cumple.model.Cumple;

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
        holder.fecha.setText(soli.getFecha()+"Kg");
        holder.dias.setText("falta");
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


}



