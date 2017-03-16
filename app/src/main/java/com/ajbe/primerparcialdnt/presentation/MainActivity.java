package com.ajbe.primerparcialdnt.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.ajbe.primerparcialdnt.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ColorChooserDialog.ColorCallback {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.content_main) ConstraintLayout layout;
    // Roots
    private int a, b, c;
    private double root1;
    private double root2;

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
    public void goToNumbers() {
        startActivity(new Intent(this, GameNumberActivity.class));
    }

    @OnClick(R.id.button_mcd_mcm)
    public void goToMath() {
        startActivity(new Intent(this, MathActivity.class));
    }

    private void actionRoots() {
        new MaterialDialog.Builder(this)
                .title("Polinomios")
                .content("Digita a")
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input("a", null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        a = Integer.parseInt(input.toString());
                        showBDialog();
                    }
                }).show();
    }

    private void showBDialog() {
        new MaterialDialog.Builder(MainActivity.this)
                .title("Polinomios")
                .content("Digita b")
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input("b", null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        b = Integer.parseInt(input.toString());
                        showCDialog();
                    }
                }).show();
    }

    private void showCDialog() {
        new MaterialDialog.Builder(MainActivity.this)
                .title("Polinomios")
                .content("Digita c")
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input("c", null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        c = Integer.parseInt(input.toString());
                        showResult();
                    }
                }).show();

    }

    private void showResult() {
        calculateRoots();
        new MaterialDialog.Builder(this)
                .title("La raices son")
                .content("x1: "+ root1 +"\n x2: "+root2)
                .positiveText("Cerrar")
                .show();
    }

    private void calculateRoots() {
        root1 = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
        root2 = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
    }

    private void changeBackground() {
        // Pass AppCompatActivity which implements ColorCallback, along with the title of the dialog
        new ColorChooserDialog.Builder(this, R.string.title_color)
                .doneButton(R.string.md_done_label)
                .cancelButton(R.string.md_cancel_label)
                .backButton(R.string.md_back_label)
                .dynamicButtonColor(true)
                .show();
    }

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {
        layout.setBackgroundColor(selectedColor);
    }

    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {

    }
}
