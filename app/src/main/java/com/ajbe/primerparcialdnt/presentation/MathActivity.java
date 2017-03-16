package com.ajbe.primerparcialdnt.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import com.ajbe.primerparcialdnt.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MathActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.editText_number_one) EditText editNumberOne;
    @BindView(R.id.editText_number_two) EditText editNumberTwo;
    @BindView(R.id.textView_result) TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.button_mcm)
    public void calcMCM() {

        if (editNumberOne.getText().length() == 0) {
            editNumberOne.setError("No puede estar vacio");
            return;
        } else if (editNumberTwo.getText().length() == 0) {
            editNumberTwo.setError("No puede estar vacio");
            return;
        }

        int a = Integer.parseInt(editNumberOne.getText().toString());
        int b = Integer.parseInt(editNumberTwo.getText().toString());
        int mcm=1;
        int i=2;
        while(i <= a || i <= b) {
            if(a%i == 0 || b%i == 0) {
                mcm = mcm * i;
                if(a%i == 0)
                    a=a/i;
                if(b%i == 0)
                    b=b/i;
            } else
                i=i+1;
        }
        textResult.setText(String.valueOf(mcm));
    }

    @OnClick(R.id.button_mcd)
    public void calcMCD() {
        if (editNumberOne.getText().length() == 0) {
            editNumberOne.setError("No puede estar vacio");
            return;
        } else if (editNumberTwo.getText().length() == 0) {
            editNumberTwo.setError("No puede estar vacio");
            return;
        }
        int a = Integer.parseInt(editNumberOne.getText().toString());
        int b = Integer.parseInt(editNumberTwo.getText().toString());
        textResult.setText(String.valueOf(recursiveMCD(a, b)));
    }

    private int recursiveMCD(int a, int b) {
        if (b == 0)
            return a;
        else
            return recursiveMCD(b, a % b);
    }


}
