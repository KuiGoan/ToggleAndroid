package com.ifi.kuirin.toggleandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ToggleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);

        List<ToggleModel> list = new ArrayList<>();
        list.add(new ToggleModel(ToggleAdapter.ITEM_TYPE_HEADER, false, "Item Header"));
        list.add(new ToggleModel(ToggleAdapter.ITEM_TYPE_NORMAL, false, "Item 2"));
        list.add(new ToggleModel(ToggleAdapter.ITEM_TYPE_NORMAL, false, "Item 3"));
        list.add(new ToggleModel(ToggleAdapter.ITEM_TYPE_NORMAL, false, "Item 4"));
        list.add(new ToggleModel(ToggleAdapter.ITEM_TYPE_NORMAL, false, "Item 5"));
        list.add(new ToggleModel(ToggleAdapter.ITEM_TYPE_NORMAL, false, "Item 6"));
        mAdapter = new ToggleAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }
}
