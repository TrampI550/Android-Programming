package com.example.lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        setListenerOnButton();
    }

    public void setListenerOnButton() {
        Button btn_dia = findViewById(R.id.btn_dia);
        Button prev_btn = findViewById(R.id.prev_btn);
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        EditText result = findViewById(R.id.result);
        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FifthActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });
        btn_dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(FifthActivity.this);
                a_builder.setMessage("А может не надо?")
                        .setCancelable(false)
                        .setPositiveButton("Надо, андроша, надо", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int res = Integer.valueOf(num1.getText().toString())
                                        + Integer.valueOf(num2.getText().toString());
                                result.setText(String.valueOf(res));
                                Snackbar.make(view, "Готово, хозяин", Snackbar.LENGTH_LONG)
                                        .show();
                                dialogInterface.cancel();
                            }
                        })
                        .setNegativeButton("Ладно, уговорил", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = a_builder.create();
                //alert.setTitle("Are you crazy");
                alert.show();
            }
        });
    }
}