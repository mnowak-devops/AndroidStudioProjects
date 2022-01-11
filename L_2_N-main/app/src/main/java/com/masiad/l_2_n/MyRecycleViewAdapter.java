package com.masiad.l_2_n;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class MyRecycleViewAdapter
        extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHandel> {

    List<Country> countries;
    ItemClick itemClick;
    LayoutInflater mInflater;

    public MyRecycleViewAdapter(Context context, List<Country> countryList){
        countries = countryList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHandel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_grid_veiw, parent, false);
        return new ViewHandel(view);
//        View view = mInflater.inflate(R.layout.item_list_view, parent, false);
//        return new ViewHandel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHandel holder, int position) {
        Country c = countries.get(position);
        holder.flagImage.setImageResource(c.flag);
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

    public void setClickListiner(ItemClick iClick){
        this.itemClick = iClick;
    }

    class ViewHandel extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView flagImage;
        TextView countryName;
        TextView countryCapital;

        public ViewHandel(@NonNull View itemView) {
            super(itemView);
            flagImage = itemView.findViewById(R.id.flagImageView);
            countryName = itemView.findViewById(R.id.countryNameTV);
            countryCapital = itemView.findViewById(R.id.countryCapitalTV);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClick != null) itemClick.onItemClickListener(view,
                    getAdapterPosition());
        }
    }
}
