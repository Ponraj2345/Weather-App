package com.example.apitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class PopularCitiesAdapter extends RecyclerView.Adapter<PopularCitiesAdapter.ViewHolder>{
    ArrayList<DataClassForPopular> datas=new ArrayList<>();
    Context context;
    RecyclerInterface recyclerInterface;

    public PopularCitiesAdapter(ArrayList<DataClassForPopular> datas, Context context,RecyclerInterface recyclerInterface) {
        this.datas = datas;
        this.context = context;
        this.recyclerInterface=recyclerInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.popular_cities_recycler,parent,false);
        return new ViewHolder(view,recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       int degree=(int)Math.ceil(datas.get(position).getDegree());
       holder.tvDegree.setText(degree+"˚"+"C");
       holder.tvCity.setText(datas.get(position).getCity());
       if(datas.get(position).getClimateCondition().equals("mild"))
           holder.animationView.setAnimation(R.raw.mild);
       else if(datas.get(position).getClimateCondition().equals("cold"))
           holder.animationView.setAnimation(R.raw.cold);
       else if(datas.get(position).getClimateCondition().equals("warm"))
           holder.animationView.setAnimation(R.raw.warm);
       else if(datas.get(position).getClimateCondition().equals("hot"))
           holder.animationView.setAnimation(R.raw.hot);



    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCity,tvDegree;
        LottieAnimationView animationView;
        public ViewHolder(@NonNull View itemView,RecyclerInterface recyclerInterface) {
            super(itemView);
            animationView=itemView.findViewById(R.id.lottieRecyclerAnimation);
            tvCity=itemView.findViewById(R.id.tvRecyclerCityName);
            tvDegree=itemView.findViewById(R.id.tvRecyclerDegree);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerInterface!=null){
                        int pos=getAdapterPosition();
                        recyclerInterface.onCityClick(pos);
                    }
                }
            });

        }
    }
}
