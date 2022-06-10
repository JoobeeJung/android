package com.kbstar.e03actionbarsearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    ActionBar actionBar;
    EditText keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        actionBar = getSupportActionBar();

//        actionBar.hide();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionBar.setLogo(R.drawable.home);
                actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);

        View view = menu.findItem(R.id.menu_search).getActionView();

        keyword = view.findViewById(R.id.keyword);
        showToast(keyword.getText().toString());

        keyword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                showToast("Editor Event !!!" + keyword.getText().toString());
                return false;
            }
        });

        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId)
        {
            case R.id.menu_refresh:
                doRefresh();
                break;
            case R.id.menu_search:
                showToast("검색");
                setText("검색!");
                break;
            case R.id.menu_settings:
                showToast("설정");
                setText("설정!");
                break;
            default:
                showToast("Unknown Menu Selected");
                break;
        }

//        if(item.getItemId() == R.id.menu_refresh)
//        {
//            showToast("새로고침");
//        }

        return super.onOptionsItemSelected(item);
    }

    private void doRefresh() {
        showToast("새로고침");
        setText("새로고침 !!");
    }

    private void setText(String msg){
        textView.setText(msg);
    }
    public void showToast(String msg)
    {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }

}