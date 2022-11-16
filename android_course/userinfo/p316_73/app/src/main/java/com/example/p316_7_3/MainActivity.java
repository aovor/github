package com.example.p316_7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    EditText tvName, tvEmail, dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName = (EditText) findViewById(R.id.tvName);
        tvEmail = (EditText) findViewById(R.id.tvEmail);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder (MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.star);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int which) {
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int which) {
                    }
                });
                final AlertDialog dialog = dlg.create();
                dialog.show();
                dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean wantToCloseDialog = true;
                        dlgEdtName.setText(tvName.getText().toString());
                        dlgEdtEmail.setText(tvEmail.getText().toString());
                        if(wantToCloseDialog == false)
                            dialog.dismiss();
                    }
                });
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean wantToCloseDialog = false;

                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다.");
                        toast.setView(toastView);
                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int) (Math.random() * display.getWidth());
                        int yOffset = (int) (Math.random() * display.getHeight());
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                        toast.show();

                        if(wantToCloseDialog == false)
                            dialog.dismiss();
                    }
                });
            }
        });
    }
}