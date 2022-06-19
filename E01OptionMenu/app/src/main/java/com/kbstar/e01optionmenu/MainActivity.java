package com.kbstar.e01optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId)
        {
            case R.id.menu_refresh:
                doRefresh();
                textView.setText("새로고침");
                break;
            case R.id.menu_search:
                showToast("검색");
                textView.setText("검색하기");
                break;
            case R.id.menu_settings:
                showToast("설정");
                textView.setText("설정하기");
                break;
            default:
                showToast("Unknown Menu Selected");
                textView.setText("모름름");
               break;
        }

        /*
        if(item.getItemId() == R.id.menu_refresh)
        {
            showToast("새로고침");
        }
        */

        return super.onOptionsItemSelected(item);
    }

    public void doRefresh()
    {
        showToast("새로고침");
    }

    public void showToast(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}