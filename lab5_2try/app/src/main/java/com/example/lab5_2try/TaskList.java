package com.example.lab5_2try;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileWriter;
import java.util.Calendar;

public class TaskList extends AppCompatActivity {
    final String LOG_TAG = "LOL";
    final Context context = this;
    Button create_task, next_btn;
    LinearLayout linearLayout;
    SharedPreferences sPref;
    final String DATA_NAME = "data_romba2";
    Calendar dateAndTime = Calendar.getInstance();
    private String Date;
    private String Task_text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        create_task = findViewById(R.id.create_task);
        next_btn = findViewById(R.id.next_btn5);
        linearLayout = findViewById(R.id.task_mega);
        Task_text = "";

        loadData();
        setInitialDateTime();
        setListenerOnButton();
    }

    private void saveData(String Str1, String Str2) {
        sPref = getSharedPreferences(DATA_NAME, MODE_PRIVATE);
        int number = 0;
        SharedPreferences.Editor ed = sPref.edit();
        if(!sPref.contains("size")) {
            ed.putInt("size", 0);
            number = 0;
        } else number = sPref.getInt("size", 0);
        ed.putInt("size", sPref.getInt("size", 0) + 1);
        ed.putString(Integer.toString(number), Str1 + "☼☼☼" + Str2);
        ed.apply();
        AddTask(Str1, Str2);
    }

    private void loadData() {
        String savedText;
        int number = 0;
        sPref = getSharedPreferences(DATA_NAME, MODE_PRIVATE);
        if(sPref.contains("size")) {
            number = sPref.getInt("size", 0);
        }
        for (int i = 0; i < number; i++) {
            savedText = sPref.getString(Integer.toString(i), "");
            String[] guys = savedText.split("☼☼☼");
            Log.d(LOG_TAG, savedText);
            AddTask(guys[0], guys[1]);
        }
    }

    private void AddTask(String Task_text, String Date) {
        LinearLayout linearLayout1 = new LinearLayout(this);
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout1.setBackgroundColor(R.drawable.back_g);
        ViewGroup.LayoutParams linLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        ViewGroup.LayoutParams lpView1 = new ViewGroup.LayoutParams(700, ViewGroup.LayoutParams.MATCH_PARENT);
        TextView tv1 = new TextView(this);
        tv1.setText(Task_text);
        linearLayout1.addView(tv1,lpView1);

        ViewGroup.LayoutParams lpView2 = new ViewGroup.LayoutParams(200, ViewGroup.LayoutParams.MATCH_PARENT);
        TextView tv2 = new TextView(this);
        tv2.setText(Date);
        linearLayout1.addView(tv2, lpView2);

        linearLayout.addView(linearLayout1, linLayoutParams);
    }

    public void setDate(View v) {
        new DatePickerDialog(TaskList.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void setInitialDateTime() {
        Date = DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR);
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };

    public void setListenerOnButton() {
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_next = new Intent(TaskList.this, Date_Time.class);
                startActivity(intent_next);
            }
        });
        create_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompt, null);
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
                mDialogBuilder.setView(promptsView);
                final EditText userInput = (EditText) promptsView.findViewById(R.id.input_text);
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        Task_text = userInput.getText().toString();
                                        saveData(Task_text, Date);
                                    }
                                })
                        .setNegativeButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = mDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}