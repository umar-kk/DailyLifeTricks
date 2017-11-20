package com.example.umarkk.dailylifetricks;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class DataAdaptar extends Adapter<DataAdaptar.ViewHolder> {

    private static MyClickListener myClickListener;
    List<HackList> hackLists = new ArrayList();

    int[] myIntArray = new int[]{R.drawable.ic_smartphone, R.drawable.ic_mug, R.drawable.ic_apple,
            R.drawable.ic_hospital, R.drawable.ic_money_bag, R.drawable.ic_mother_with_baby_in_arms,
            R.drawable.ic_campfire, R.drawable.ic_wine_bottle, R.drawable.ic_head,
            R.drawable.ic_clipboard, R.drawable.ic_smartphone, R.drawable.ic_mug, R.drawable.ic_apple,
            R.drawable.ic_hospital, R.drawable.ic_money_bag, R.drawable.ic_mother_with_baby_in_arms,
            R.drawable.ic_campfire, R.drawable.ic_wine_bottle, R.drawable.ic_head,
            R.drawable.ic_clipboard,R.drawable.ic_smartphone, R.drawable.ic_mug, R.drawable.ic_apple,
            R.drawable.ic_hospital, R.drawable.ic_money_bag, };

    public interface MyClickListener {
        void onItemClick(View view);
    }

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements OnClickListener {
        private ImageView icon;
        private TextView range_text;

        public void onClick(View view) {
            DataAdaptar.myClickListener.onItemClick(view);
        }

        public ViewHolder(View view) {
            super(view);
            this.range_text = (TextView) view.findViewById(R.id.range_text);
            this.icon = (ImageView) view.findViewById(R.id.icon_grid);
            view.setOnClickListener(this);
        }
    }

    public DataAdaptar(List<HackList> hackLists) {
        this.hackLists = hackLists;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.range_text.setText(((HackList) this.hackLists.get(i)).getCategory());
        viewHolder.icon.setImageResource(this.myIntArray[i]);
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        myClickListener = myClickListener;
    }

    public int getItemCount() {

        return this.hackLists.size();
    }
}