package com.kbstar.h05pagesliding;

// H05PageSliding

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isOpen = false;
    LinearLayout slidingMenu;
    Button button;
    Button button1;
    Button button2;
    Button button3;

    Animation leftAni;
    Animation rightAni;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingMenu = findViewById(R.id.slidingMenu);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        textView = findViewById(R.id.textView);

        leftAni = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_left);
        rightAni = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_right);

        SlidingPageAnimationListener listener = new SlidingPageAnimationListener();
        leftAni.setAnimationListener(listener);
        rightAni.setAnimationListener(listener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isOpen ==true) {
                    slidingMenu.startAnimation(rightAni);
                }else {
                    slidingMenu.setVisibility(View.VISIBLE);
                    slidingMenu.startAnimation(leftAni);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append("\n Menu 1 Clicked!");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append("\n Menu 2 Clicked!");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append("\n Menu 3 Clicked!");
            }
        });
    }

    private class SlidingPageAnimationListener
                implements Animation.AnimationListener
    {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isOpen)
            {
                slidingMenu.setVisibility(View.INVISIBLE);
                button.setText("Open");
                isOpen = false;
            }else
            {
                //slidingMenu.setVisibility(View.VISIBLE);
                button.setText("Close");
                isOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}