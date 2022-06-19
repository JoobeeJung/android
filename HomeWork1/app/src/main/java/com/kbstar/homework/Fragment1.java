package com.kbstar.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment1, container, false);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        //필요하면 버튼 객체를 이용해서 이벤트 처리

        Button button = view.findViewById(R.id.btnOpen1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ImageActivity.class);

                startActivity(intent);
            }
        });
        return view;
    }
}