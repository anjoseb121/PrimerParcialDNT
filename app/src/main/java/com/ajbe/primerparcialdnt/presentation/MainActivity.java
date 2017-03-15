package com.ajbe.primerparcialdnt.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.ajbe.primerparcialdnt.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_change_background:
                changeBackground();
                break;
            case R.id.action_roots:
                actionRoots();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.button_number)
    public void goToNumbers(View v) {
        startActivity(new Intent(v.getContext(), GameNumberActivity.class));
    }

    @OnClick(R.id.button_mcd_mcm)
    public void goToMath(View v) {
        startActivity(new Intent(v.getContext(), MathActivity.class));
    }

    private void actionRoots() {
        Toast.makeText(this, "jEJE Roots", Toast.LENGTH_SHORT).show();
    }

    private void changeBackground() {
        Toast.makeText(this, "Jeje background", Toast.LENGTH_SHORT).show();
    }

}
