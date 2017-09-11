package com.ifi.kuirin.toggleandroid;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

/**
 * Created by KuiRin on 9/11/2017 AD.
 */

public class ToggleAdapter extends BaseRecyclerAdapter<ToggleModel, ToggleAdapter.ViewHolder> {

    public final static int ITEM_TYPE_NORMAL = 0;
    public final static int ITEM_TYPE_HEADER = 1;
    static boolean canPress = false;

    public ToggleAdapter(@Nullable List<ToggleModel> objects) {
        super(objects);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        if (viewType == ITEM_TYPE_HEADER) {
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(20, 0, 0, 0);
            itemView.findViewById(R.id.item_title).setLayoutParams(lp);
        }
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textView.setText(getItem(position).getTitle());

        if (getItemViewType(position) == ITEM_TYPE_NORMAL) {
            holder.toggleButton.setEnabled(canPress);
            holder.toggleButton.setChecked(getItem(position).isChecked);
        }

        holder.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("recyclerView", "pos = " + position + " ,onCheckedChanged: " + b);
                if (getItemViewType(position) == ITEM_TYPE_HEADER) {
                    if (!b) {
                        for (ToggleModel model : getList()) {
                            model.setChecked(false);
                        }
                        canPress = false;
                        notifyDataSetChanged();
                        return;
                    } else {
                        canPress = true;
                        getItem(position).setChecked(true);
                        notifyDataSetChanged();
                    }
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return getList().get(position).getType();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ToggleButton toggleButton;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            toggleButton = itemView.findViewById(R.id.iten_toggle);
            textView = itemView.findViewById(R.id.item_title);
        }
    }
}
