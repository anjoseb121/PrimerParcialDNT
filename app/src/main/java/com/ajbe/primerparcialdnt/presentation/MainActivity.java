package com.ajbe.primerparcialdnt.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ajbe.primerparcialdnt.R;
import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.content_main) ConstraintLayout layout;

    private ColorPicker mColorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mColorPicker = new ColorPicker(this);
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
    public void goToNumbers() {
        startActivity(new Intent(this, GameNumberActivity.class));
    }

    @OnClick(R.id.button_mcd_mcm)
    public void goToMath() {
        startActivity(new Intent(this, MathActivity.class));
    }

    private void actionRoots() {
        Toast.makeText(this, "jEJE Roots", Toast.LENGTH_SHORT).show();
    }

    private void changeBackground() {
        mColorPicker.show();
        mColorPicker.setCallback(new ColorPickerCallback() {
            @Override
            public void onColorChosen(@ColorInt int color) {
                layout.setBackgroundColor(color);
                mColorPicker.cancel();
            }
        });
    }

}
