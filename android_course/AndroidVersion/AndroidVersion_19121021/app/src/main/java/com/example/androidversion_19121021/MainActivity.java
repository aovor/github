package com.example.androidversion_19121021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch switch1;
    RadioGroup rGroup1;
    RadioButton RdoQ, RdoR, RdoS;
    Button btnReset;
    ImageView imgVer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        switch1 = (Switch) findViewById(R.id.Switch);
        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        RdoQ = (RadioButton) findViewById(R.id.Q);
        RdoR = (RadioButton) findViewById(R.id.R);
        RdoS = (RadioButton) findViewById(R.id.S);
        btnReset = (Button) findViewById(R.id.Reset);
        imgVer = (ImageView) findViewById(R.id.ImgVer);

        switch1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switch1.isChecked()==true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                    imgVer.setVisibility(View.VISIBLE);
                }

                else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnReset.setVisibility(View.INVISIBLE);
                    imgVer.setVisibility(View.INVISIBLE);
                }
            }
        });


        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.Q:
                        imgVer.setImageResource(R.drawable.pic_q);
                        break;
                    case R.id.R:
                        imgVer.setImageResource(R.drawable.pic_r);
                        break;
                    case R.id.S:
                        imgVer.setImageResource(R.drawable.pic_s);
                        break;
                    default:
                        break;
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                switch1.setChecked(false);
                rGroup1.clearCheck();
                imgVer.setImageResource(0);
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                btnReset.setVisibility(View.INVISIBLE);
                imgVer.setVisibility(View.INVISIBLE);
            }
        });
    }
}