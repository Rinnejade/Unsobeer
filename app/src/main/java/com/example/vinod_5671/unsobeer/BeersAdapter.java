package com.example.vinod_5671.unsobeer;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinod-5671 on 30/06/18.
 */

public class BeersAdapter extends RecyclerView.Adapter<BeersAdapter.MyViewHolder>
        implements Filterable {

    private List<Beer> beerList;
    private List<Beer> beerListFiltered;
    private BeersAdapterListener listener;

    public BeersAdapter(List<Beer> beerList) {
        this.beerList = beerList;
        this.beerListFiltered  = new ArrayList<>();
        this.beerListFiltered.addAll(beerList);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, style, ibu, abv, ounces;

        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.id);
            name = (TextView) view.findViewById(R.id.name);
            style = (TextView) view.findViewById(R.id.style);
            ibu = (TextView) view.findViewById(R.id.ibu);
            abv = (TextView) view.findViewById(R.id.abv);
            ounces = (TextView) view.findViewById(R.id.ounces);

            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    listener.onBeerSelected(beerListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.beer_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Beer beer = beerListFiltered.get(position);
        holder.id.setText(beer.getId());
        holder.name.setText(beer.getName());
        holder.style.setText(beer.getStyle());
        holder.ibu.setText(beer.getIbu());
        holder.abv.setText(beer.getAbv());
        holder.ounces.setText(beer.getOunces().toString());
    }

    @Override
    public int getItemCount() {
        return beerListFiltered.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if(charString.isEmpty()){
                    beerListFiltered = beerList;
                }else{
                    List<Beer> filteredList = new ArrayList<>();
                    for (Beer row : beerList) {
                        if(getFilterCriteria(row, charString)){
                            filteredList.add(row);
                        }
                    }
                    beerListFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = beerListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                beerListFiltered = (List<Beer>) filterResults.values;
                Log.i("filtered list : ", beerListFiltered.size()+"");
                notifyDataSetChanged();
            }
            private boolean getFilterCriteria(Beer row, String searchterm){
                return row.getName().toLowerCase().contains(searchterm.toLowerCase()) || row.getStyle().toLowerCase().contains(searchterm.toLowerCase());
            }
        };
    }
    public interface BeersAdapterListener {
        void onBeerSelected(Beer beer);
    }
}

