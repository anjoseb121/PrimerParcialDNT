package com.ajbe.primerparcialdnt.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.ajbe.primerparcialdnt.R;
import com.ajbe.primerparcialdnt.utils.RandomUtils;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameNumberActivity extends AppCompatActivity {

    @BindView(R.id.container_hearts) LinearLayout containerHearts;
    @BindView(R.id.button_play) Button buttonPlay;
    @BindView(R.id.edit_answer) EditText editAnswer;

    private int mHearts = 0;
    private int max = 100;
    private int min = 0;
    private int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_number);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Generate random answer
        answer = RandomUtils.getRandomInteger(max, min);
        //Toast.makeText(this, "Respuesta: "+answer, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_play)
    public void guestNumber(View v) {
        int usersNumber = Integer.parseInt(editAnswer.getText().toString());

        if (usersNumber == answer)
            youWon(v);
        else if (usersNumber > answer) {
            Toast.makeText(this, "Este número es mayor que la respuesta", Toast.LENGTH_SHORT).show();
            hasLive(v);
        }
        else if (usersNumber < answer) {
            Toast.makeText(this, "Este numero es menor que la respuesta", Toast.LENGTH_SHORT).show();
            hasLive(v);
        }
    }

    private void hasLive(View v) {
        if (mHearts < containerHearts.getChildCount()) {
            containerHearts.getChildAt(mHearts).setVisibility(View.GONE);
            mHearts++;
        }
        if (mHearts == containerHearts.getChildCount()){
            Snackbar.make(v, "Perdiste", Snackbar.LENGTH_INDEFINITE).show();
            buttonPlay.setEnabled(false);
            buttonPlay.setText("Perdiste");
        }
    }

    private void youWon(View v) {
        Snackbar.make(v, "ESE ES EL NUMERO "+answer, Snackbar.LENGTH_INDEFINITE).show();
    }


}
