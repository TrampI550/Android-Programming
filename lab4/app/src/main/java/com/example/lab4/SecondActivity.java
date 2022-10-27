package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        dateConsoler();
    }
    public void dateConsoler() {
        DatePicker mDatePicker = findViewById(R.id.datePicker);
        Calendar today = Calendar.getInstance();
        mDatePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        Toast.makeText(getApplicationContext(),
                                "DateChanged", Toast.LENGTH_SHORT).show();

                        System.out.print("Год: " + year + "\n" + "Месяц: "
                                + (monthOfYear + 1) + "\n" + "День: " + dayOfMonth + "\n");
                    }
                });
        TimePicker mTimePicker = findViewById(R.id.timepick);
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext(), "onTimeChanged",
                        Toast.LENGTH_SHORT).show();

                System.out.print("Час: " + hourOfDay + "\n" + "Минуты: "
                        + minute + "\n");
            }
        });
        Button next_btn2 = findViewById(R.id.next_btn2);
        next_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}