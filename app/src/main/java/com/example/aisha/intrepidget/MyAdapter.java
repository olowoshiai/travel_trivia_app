package com.example.aisha.intrepidget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Aisha on 12/8/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<ListItem> listItems;

   private Context context;


   //constructor to initialize these objects

    public MyAdapter(List<ListItem> listItems, FourthFragment fourthFragment) {
        this.listItems = listItems;  //this is null?
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }


    //get the current object from the list
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.country.setText(listItem.getCountry());
        holder.language.setText(listItem.getLanguage());
        holder.currency.setText(listItem.getInformation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "Fuck", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), RecyclerPicturesActivity.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
        //open fourthfragment.java, listitem.java and this one
        /*
        if(listItems == null)
        {
            return 0;
        }
        else
            return listItems.size();
            */
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView country;
        public TextView language;
        public TextView currency;


        private ItemClickListener itemClickListener;


        public ViewHolder(View itemView) {
            super(itemView);

            country = (TextView) itemView.findViewById(R.id.textViewCountry);
            language = (TextView) itemView.findViewById(R.id.textViewLanguage);
            currency = (TextView) itemView.findViewById(R.id.textViewCurrency);
        }

    }


}
