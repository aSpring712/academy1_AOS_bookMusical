package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Today's Musical");

        ImageView[] image = new ImageView[6];
        Integer[] imageID = {R.id.iv1, R.id.iv2, R.id.iv3,
                             R.id.iv4, R.id.iv5, R.id.iv6};
        Integer[] imageFileId = {R.drawable.fourminutes, R.drawable.hope, R.drawable.barethemusical,
                               R.drawable.ludwig, R.drawable.phantom, R.drawable.wicked};
        final String[] imgName = {"Four Minutes", "HOPE", "bare the musical",
                                  "루드윅", "Phantom", "Wicked"};

        for(int i = 0; i < imageID.length; i++) {
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageID[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(SecondActivity.this);
                    dlg.setTitle(imgName[index]);
                    dlg.setMessage("예매하시겠습니까?");
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                            intent.putExtra("title", imgName[index]);
                            intent.putExtra("imageID", imageFileId[index]);
                            startActivity(intent);
                        }
                    });
                    dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(SecondActivity.this, "잉...ㅠㅠ", Toast.LENGTH_SHORT).show();
                        }
                    });
                    dlg.show();
                }
            });
        }


    }
}