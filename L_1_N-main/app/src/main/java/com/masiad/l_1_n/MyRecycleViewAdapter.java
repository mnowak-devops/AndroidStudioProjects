package com.masiad.l_1_n;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecycleViewAdapter extends
                    RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

    private List<Country> countries;
    private OnClickListener mClick;
    private LayoutInflater mInflater;

    public MyRecycleViewAdapter(Context context, List<Country> countryList){
        this.mInflater = LayoutInflater.from(context);
        this.countries = countryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.item_grid_view,
//                parent, false);
//        return new ViewHolder(view);
        View view = mInflater.inflate(R.layout.item_list_view,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country c = countries.get(position);
        holder.flag.setImageURI(Uri.parse(c.flagPath));
        holder.countryName.setText(c.name);
        holder.countryCapital.setText(c.capital);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public Country getItem(int id){
        return countries.get(id);
    }

    public void setOnClick(OnClickListener onClickListener){
        this.mClick = onClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView flag;
        private TextView countryName;
        private TextView countryCapital;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.countryFlagIV);
            countryName = itemView.findViewById(R.id.countryNameTV);
            countryCapital = itemView.findViewById(R.id.countryCapitalTV);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClick != null) {
                mClick.onClickListener(view, getAdapterPosition());
            }
        }
    }
}
