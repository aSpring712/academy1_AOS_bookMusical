package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        setTitle("Details");

        ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
        TextView tvName = (TextView) findViewById(R.id.tvName);

        Button btnBuy = (Button) findViewById(R.id.btnBuy);
        Button btnReturn = (Button) findViewById(R.id.btnReturn);

        RatingBar rBar = (RatingBar) findViewById(R.id.rBar);
        LayerDrawable starts = (LayerDrawable) rBar.getProgressDrawable();
        starts.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int imgID = intent.getIntExtra("imageID", 0);

        ivPoster.setImageResource(imgID);
        tvName.setText(title);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String getTime = sdf.format(date);

                AlertDialog.Builder dlg = new AlertDialog.Builder(ThirdActivity.this);
                dlg.setTitle("예매 확인");
                dlg.setMessage(getTime + "\n뮤지컬 " +title);
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "다음에 봐요ㅠㅠ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}