package com.kbstar.f04drawer;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.kbstar.f04drawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
    implements FragmentCallback,
        NavigationView.OnNavigationItemSelectedListener
{
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    DrawerLayout drawer;
    Toolbar toolbar;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        drawer.addDrawerListener();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment1)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.menu1)
        {
            showToast("First menu selected!");
            onFragmentSelected(0,null);
        } else if(itemId == R.id.menu2)
        {
            showToast("Second menu selected!");
            onFragmentSelected(1,null);
        } else if(itemId == R.id.menu3)
        {
            showToast("Third menu selected!");
            onFragmentSelected(2,null);
        }

        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    public void showToast(String msg)
    {
        Toast.makeText(
                getApplicationContext(),
                msg, Toast.LENGTH_LONG)
                .show();

    }

    @Override
    public void onFragmentSelected(int position, Bundle bundle) {

        Fragment selectedFragment = null;

        if(position == 0)
        {
            selectedFragment = fragment1;
            toolbar.setTitle("첫번째");
        }else if(position == 1)
        {
            selectedFragment = fragment2;
            toolbar.setTitle("두번째");
        }else if(position == 2)
        {
            selectedFragment = fragment3;
            toolbar.setTitle("세번째");
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, selectedFragment)
                .commit();

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}