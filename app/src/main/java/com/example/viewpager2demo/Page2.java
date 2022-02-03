package com.example.viewpager2demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Page2 extends Fragment {
    private String title;

    public Page2(String title) {
        this.title = title;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        TextView textView = view.findViewById(R.id.tv2);
        textView.setText(title);
        return view;
    }
}