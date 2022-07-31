package com.f.mygithub.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.f.mygithub.R;
import com.f.mygithub.adapter.ShablonAdapter;
import com.f.mygithub.adapter.ShablonItem;

import java.util.ArrayList;


public class ListShablonFragment extends Fragment {

    private final ArrayList<ShablonItem> shablonItems = new ArrayList<>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_repository, container, false);


        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        ShablonAdapter shablonAdapter = new ShablonAdapter(ListShablonFragment.this, shablonItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(shablonAdapter);

        return view;
    }

    private void initData(){
        shablonItems.add(new ShablonItem("file:///android_asset/shablon_1.html"));
        shablonItems.add(new ShablonItem("file:///android_asset/shablon_2.html"));
        shablonItems.add(new ShablonItem("file:///android_asset/shablon_3.html"));
        shablonItems.add(new ShablonItem("file:///android_asset/shablon_4.html"));
    }


}