package com.f.mygithub.adapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.f.mygithub.R;
import com.f.mygithub.fragments.ShablonFragment;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class ShablonAdapter extends RecyclerView.Adapter<ShablonAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<ShablonItem> shablonItems;
    private final Fragment fragment;


    public ShablonAdapter( Fragment fragment,  List<ShablonItem> shablonItems){
        this.fragment = fragment;
        this.inflater = LayoutInflater.from(fragment.getContext());
        this.shablonItems = shablonItems;
    }



    @NonNull
    @Override
    public ShablonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ShablonAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ShablonItem shablonItem = shablonItems.get(position);
        holder.webView.loadUrl(shablonItem.getHtmlShablon());
        holder.button.setOnClickListener(v -> {
            if (position == 0){
                Bundle bundle = new Bundle();
                bundle.putString("file", "shablon_1.html");
                FragmentTransaction fragmentTransaction = fragment
                        .getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();

                fragmentTransaction.replace(R.id.container, ShablonFragment.class, bundle);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
            if (position == 1){
                Bundle bundle = new Bundle();
                bundle.putString("file", "shablon_2.html");
                FragmentTransaction fragmentTransaction = fragment
                        .getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();

                fragmentTransaction.replace(R.id.container, ShablonFragment.class, bundle);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
            if (position == 2){
                Bundle bundle = new Bundle();
                bundle.putString("file", "shablon_3.html");
                FragmentTransaction fragmentTransaction = fragment
                        .getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();

                fragmentTransaction.replace(R.id.container, ShablonFragment.class, bundle);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
            if (position == 3){
                Bundle bundle = new Bundle();
                bundle.putString("file", "shablon_4.html");
                FragmentTransaction fragmentTransaction = fragment
                        .getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();

                fragmentTransaction.replace(R.id.container, ShablonFragment.class, bundle);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }


        });



    }

    @Override
    public int getItemCount() {
        return shablonItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final WebView webView;
        final Button button;

        ViewHolder(View view) {
            super(view);
            webView = (WebView)view.findViewById(R.id.item_web);
            button = (Button)view.findViewById(R.id.button);
        }

    }
}
