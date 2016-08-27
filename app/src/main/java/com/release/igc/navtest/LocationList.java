package com.release.igc.navtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class LocationList extends AppCompatActivity {

    private ListView mList;

    //Added by Alex
    private ExpandableListView locationsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        //Toolbar & Back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Show Icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Set navigation for toolbar
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Variables
    }

    public void onClick_loc_1(View v)
    {
        Intent intent = new Intent(this, loc_1.class);
        startActivity(intent);
    }
    public void onClick_loc_2(View v)
    {
        Intent intent = new Intent(this, loc_2.class);
        startActivity(intent);
    }
    public void onClick_loc_3(View v)
    {
        Intent intent = new Intent(this, loc_3.class);
        startActivity(intent);
    }
    public void onClick_loc_4(View v)
    {
        Intent intent = new Intent(this, loc_4.class);
        startActivity(intent);
    }
    public void onClick_loc_5(View v)
    {
        Intent intent = new Intent(this, loc_5.class);
        startActivity(intent);
    }
    public void onClick_loc_6(View v)
    {
        Intent intent = new Intent(this, loc_6.class);
        startActivity(intent);
    }
    public void onClick_loc_7(View v)
    {
        Intent intent = new Intent(this, loc_7.class);
        startActivity(intent);
    }
    public void onClick_loc_8(View v)
    {
        Intent intent = new Intent(this, loc_8.class);
        startActivity(intent);
    }
    public void onClick_loc_9(View v)
    {
        Intent intent = new Intent(this, loc_9.class);
        startActivity(intent);
    }
    public void onClick_loc_10(View v)
    {
        Intent intent = new Intent(this, loc_10.class);
        startActivity(intent);
    }
    public void onClick_loc_11(View v)
    {
        Intent intent = new Intent(this, loc_11.class);
        startActivity(intent);
    }
    public void onClick_loc_12(View v)
    {
        Intent intent = new Intent(this, loc_12.class);
        startActivity(intent);
    }
    public void onClick_loc_13(View v)
    {
        Intent intent = new Intent(this, loc_13.class);
        startActivity(intent);
    }
    public void onClick_loc_14(View v)
    {
        Intent intent = new Intent(this, loc_14.class);
        startActivity(intent);
    }
    public void onClick_loc_15(View v)
    {
        Intent intent = new Intent(this, loc_15.class);
        startActivity(intent);
    }
    public void onClick_loc_16(View v)
    {
        Intent intent = new Intent(this, loc_16.class);
        startActivity(intent);
    }
    public void onClick_loc_17(View v)
    {
        Intent intent = new Intent(this, loc_17.class);
        startActivity(intent);
    }
    public void onClick_loc_18(View v)
    {
        Intent intent = new Intent(this, loc_18.class);
        startActivity(intent);
    }
    public void onClick_loc_19(View v)
    {
        Intent intent = new Intent(this, loc_19.class);
        startActivity(intent);
    }
    public void onClick_loc_20(View v)
    {
        Intent intent = new Intent(this, loc_20.class);
        startActivity(intent);
    }
    public void onClick_loc_21(View v)
    {
        Intent intent = new Intent(this, loc_21.class);
        startActivity(intent);
    }
    public void onClick_loc_22(View v)
    {
        Intent intent = new Intent(this, loc_22.class);
        startActivity(intent);
    }
    public void onClick_loc_23(View v)
    {
        Intent intent = new Intent(this, loc_23.class);
        startActivity(intent);
    }
    public void onClick_loc_24(View v)
    {
        Intent intent = new Intent(this, loc_24.class);
        startActivity(intent);
    }
    public void onClick_loc_25(View v)
    {
        Intent intent = new Intent(this, loc_25.class);
        startActivity(intent);
    }
    public void onClick_loc_26(View v)
    {
        Intent intent = new Intent(this, loc_26.class);
        startActivity(intent);
    }
    public void onClick_loc_27(View v)
    {
        Intent intent = new Intent(this, loc_27.class);
        startActivity(intent);
    }
    public void onClick_loc_28(View v)
    {
        Intent intent = new Intent(this, loc_28.class);
        startActivity(intent);
    }
    public void onClick_loc_29(View v)
    {
        Intent intent = new Intent(this, loc_29.class);
        startActivity(intent);
    }
    public void onClick_loc_30(View v)
    {
        Intent intent = new Intent(this, loc_30.class);
        startActivity(intent);
    }
    public void onClick_loc_31(View v)
    {
        Intent intent = new Intent(this, loc_31.class);
        startActivity(intent);
    }
    public void onClick_loc_32(View v)
    {
        Intent intent = new Intent(this, loc_32.class);
        startActivity(intent);
    }
    public void onClick_loc_33(View v)
    {
        Intent intent = new Intent(this, loc_33.class);
        startActivity(intent);
    }
    public void onClick_loc_34(View v)
    {
        Intent intent = new Intent(this, loc_34.class);
        startActivity(intent);
    }
    public void onClick_loc_35(View v)
    {
        Intent intent = new Intent(this, loc_35.class);
        startActivity(intent);
    }
    public void onClick_loc_36(View v)
    {
        Intent intent = new Intent(this, loc_36.class);
        startActivity(intent);
    }


    public void onHomeButtonClick (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case android.R.id.home:
                intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case R.id.locations:
                intent = new Intent(this, LocationList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case R.id.rocks:
                intent = new Intent(this, RockList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
