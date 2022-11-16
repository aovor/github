package com.example.p322_6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRab, rdoHor;
    Button button1;
    View dialogView;
    ImageView dlgImg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 7-6");

        rGroup1 = (RadioGroup) findViewById(R.id.rGroup1);
        rdoDog = (RadioButton) findViewById(R.id.rdoDog);
        rdoCat = (RadioButton) findViewById(R.id.rdoCat);
        rdoRab = (RadioButton) findViewById(R.id.rdoRab);
        rdoHor = (RadioButton) findViewById(R.id.rdoHor);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){
           public void onClick(View arg0) {
               dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
               AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
               dlgImg = (ImageView) dialogView.findViewById(R.id.imgPet);
               dlg.setView(dialogView);
               switch(rGroup1.getCheckedRadioButtonId()){
                   case R.id.rdoDog:
                       dlg.setTitle("강아지");
                       dlgImg.setImageResource(R.drawable.rdog);
                       break;
                   case R.id.rdoCat:
                       dlg.setTitle("고양이");
                       dlgImg.setImageResource(R.drawable.rcat);
                       break;
                   case R.id.rdoRab:
                       dlg.setTitle("토끼");
                       dlgImg.setImageResource(R.drawable.rrab);
                       break;
                   case R.id.rdoHor:
                       dlg.setTitle("말");
                       dlgImg.setImageResource(R.drawable.rhor);
                       break;
                   default:
                       Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
               }
               dlg.setPositiveButton("닫기", null);
               dlg.show();
            }
        });
    }
}