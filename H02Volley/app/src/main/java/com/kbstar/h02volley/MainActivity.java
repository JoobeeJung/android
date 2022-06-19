package com.kbstar.h02volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Button button;
    private TextView textView;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process();
            }
        });

        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

    }

    public void printLog(String msg)
    {
        textView.append(msg + "\n");
    }

    public void process()
    {
        String url = input.getText().toString(); //input에 적혀있는 url을 가지고 온다.

        textView.setText(""); //새로 요청할 때에는 textView를 빈값으로 초기화 한다.

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        textView.setText(response);
                        printLog(response);//응답이 있으면 textView에 append를 한다.
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        printLog("에러 발생 : " + error.getMessage());//오류가 발생 시 오류메시지를 출력한다.

                    }
                }
        );

        request.setShouldCache(false);
        requestQueue.add(request);//requestQueue에 request를 add 한다.
    }
}