package com.weather004lifeplus.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tv, cityTv,countryTv,lastTimeTv, weatherConditionTv,maxTempTv,minTempTv,temperatureTv,CFTv;
    ImageView weatherIv;

    ListView forecastLv;
    AdapterForWeatherForecast adapter;
    ArrayList <WeatherDataModel> forecastList;
    WeatherDataManager manager;
    WeatherDataModel dataModel;

    int bit=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cityTv = (TextView)findViewById(R.id.cityTv);
        countryTv = (TextView)findViewById(R.id.countryTv);
        lastTimeTv = (TextView)findViewById(R.id.lastTimeTv);
        weatherConditionTv = (TextView)findViewById(R.id.weatherConditionTv);
        maxTempTv = (TextView)findViewById(R.id.maxTempTv);
        minTempTv = (TextView)findViewById(R.id.minTempTv);
        CFTv = (TextView)findViewById(R.id.CFTv);
        temperatureTv = (TextView)findViewById(R.id.temperatureTv);

        weatherIv =(ImageView)findViewById(R.id.weatherIv);


        forecastLv = (ListView)findViewById(R.id.forecastLv);
       // tv = (TextView)findViewById(R.id.tv);

        manager =new WeatherDataManager(this);
        dataModel =new WeatherDataModel();
        forecastList =new ArrayList<>();
        forecastList = manager.getForecastData();

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                viewData();
//            }
//        });
//        thread.run();


        viewData();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


public void viewData(){

                cityTv.setText(manager.dataModel.getCityName());
                countryTv.setText(manager.dataModel.getCountryName());
                lastTimeTv.setText("Last Update "+manager.dataModel.getLastBuildDate());
                weatherConditionTv.setText(manager.dataModel.getConditionText()+ "");
                maxTempTv.setText(manager.dataModel.getConditionMaxTemp()+ "");
                minTempTv.setText(manager.dataModel.getConditionMinTemp()+ "");
                temperatureTv.setText(manager.dataModel.getConditionTemp()+ "");

                weatherIv.setImageResource(manager.dataModel.getConditionCode());

                adapter = new AdapterForWeatherForecast(getApplicationContext(), forecastList);
                forecastLv.setAdapter(adapter);
                adapter.notifyDataSetChanged();

}


///////////////////////////////////////////////////////////////////////////////
                                                                            //
    public void btnRefresh(View view){
        tv.setText(manager.dataModel.getConditionTemp()+ "");               //
        adapter = new AdapterForWeatherForecast(this, forecastList);        //
        forecastLv.setAdapter(adapter);
        adapter.notifyDataSetChanged();                                     //
    }
                                                                            // How to call

///////////////////////////////////////////////////////////////////////////////

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refresh) {

            viewData();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
