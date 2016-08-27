package com.release.igc.navtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class RockList extends AppCompatActivity {

    private ExpandableListView mExpandableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_list);

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
    }

    public void onHomeButtonClick (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClick_rock_1 (View v)
    {
        Intent intent = new Intent(this, rock_1.class);
        startActivity(intent);
    }
    public void onClick_rock_2 (View v)
    {
        Intent intent = new Intent(this, rock_2.class);
        startActivity(intent);
    }
    public void onClick_rock_3 (View v)
    {
        Intent intent = new Intent(this, rock_3.class);
        startActivity(intent);
    }

    public void onClick_rock_4 (View v)
    {
        Intent intent = new Intent(this, rock_4.class);
        startActivity(intent);
    }

    public void onClick_rock_5 (View v)
    {
        Intent intent = new Intent(this, rock_5.class);
        startActivity(intent);
    }

    public void onClick_rock_6 (View v)
    {
        Intent intent = new Intent(this, rock_6.class);
        startActivity(intent);
    }

    public void onClick_rock_7 (View v)
    {
        Intent intent = new Intent(this, rock_7.class);
        startActivity(intent);
    }

    public void onClick_rock_8 (View v)
    {
        Intent intent = new Intent(this, rock_8.class);
        startActivity(intent);
    }

    public void onClick_rock_9 (View v)
    {
        Intent intent = new Intent(this, rock_9.class);
        startActivity(intent);
    }

    public void onClick_rock_10 (View v)
    {
        Intent intent = new Intent(this, rock_10.class);
        startActivity(intent);
    }

    public void onClick_rock_11 (View v)
    {
        Intent intent = new Intent(this, rock_11.class);
        startActivity(intent);
    }


    public void onClick_rock_12 (View v)
    {
        Intent intent = new Intent(this, rock_12.class);
        startActivity(intent);
    }

    public void onClick_rock_13 (View v)
    {
        Intent intent = new Intent(this, rock_13.class);
        startActivity(intent);
    }

    public void onClick_rock_14 (View v)
    {
        Intent intent = new Intent(this, rock_14.class);
        startActivity(intent);
    }

    public void onClick_rock_15 (View v)
    {
        Intent intent = new Intent(this, rock_15.class);
        startActivity(intent);
    }

    public void onClick_rock_16 (View v)
    {
        Intent intent = new Intent(this, rock_16.class);
        startActivity(intent);
    }

    public void onClick_rock_17 (View v)
    {
        Intent intent = new Intent(this, rock_17.class);
        startActivity(intent);
    }

    public void onClick_rock_18 (View v)
    {
        Intent intent = new Intent(this, rock_18.class);
        startActivity(intent);
    }

    public void onClick_rock_20 (View v)
    {
        Intent intent = new Intent(this, rock_20.class);
        startActivity(intent);
    }

    public void onClick_rock_21 (View v)
    {
        Intent intent = new Intent(this, rock_21.class);
        startActivity(intent);
    }

    public void onClick_rock_22 (View v)
    {
        Intent intent = new Intent(this, rock_22.class);
        startActivity(intent);
    }

    public void onClick_rock_23 (View v)
    {
        Intent intent = new Intent(this, rock_23.class);
        startActivity(intent);
    }

    public void onClick_rock_24 (View v)
    {
        Intent intent = new Intent(this, rock_24.class);
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
