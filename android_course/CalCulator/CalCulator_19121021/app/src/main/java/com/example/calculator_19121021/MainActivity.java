package com.example.calculator_19121021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnDiv2;
    TextView textResult;
    String num1, num2;
    double result;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기(수정)");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnDiv2 = (Button) findViewById(R.id.BtnDiv2);
        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                if(edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
                else{
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1)+Double.parseDouble(num2);
                    textResult.setText("계산 결과 : "+result);
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                if(edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0){
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
            }
            else{
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1)-Double.parseDouble(num2);
                textResult.setText("계산 결과 : "+result);
            }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                if(edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0){
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
            }
            else{
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1)*Double.parseDouble(num2);
                textResult.setText("계산 결과 : "+result);
            }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                if(edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if (Integer.parseInt(num2) == 0) {
                        Toast.makeText(getApplicationContext(), "나눗셈 0 연산 불가", Toast.LENGTH_SHORT).show();
                    } else {
                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + result);
                    }
                }
            }
        });
        btnDiv2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                if(edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if (Integer.parseInt(num2) == 0) {
                        Toast.makeText(getApplicationContext(), "나눗셈 0 연산 불가", Toast.LENGTH_SHORT).show();
                    } else {
                        result = Double.parseDouble(num1) % Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + result);
                    }
                }
            }
        });

    }
}