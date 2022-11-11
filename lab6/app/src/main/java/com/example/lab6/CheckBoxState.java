package com.example.lab6;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import com.example.lab6.R;

public class CheckBoxState extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_state);
        EditText login = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);
        CheckBox checkBox = findViewById(R.id.checkBox);
        Button login_btn = findViewById(R.id.login_btn);
        final boolean[] checked = {PreferenceManager.getDefaultSharedPreferences(this).getBoolean("checkBox", false)};
        checkBox.setChecked(checked[0]);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checked[0] = checkBox.isChecked();
                PreferenceManager.getDefaultSharedPreferences(CheckBoxState.this)
                        .edit().putBoolean("checkBox", checked[0]).commit();
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to_login = String.valueOf(login.getText());
                String to_pass = String.valueOf(password.getText());
                PreferenceManager.getDefaultSharedPreferences(CheckBoxState.this)
                        .edit().putString("login", to_login).commit();
                PreferenceManager.getDefaultSharedPreferences(CheckBoxState.this)
                        .edit().putString("password", to_pass).commit();
            }
        });
        final String[] log = {PreferenceManager.getDefaultSharedPreferences(this)
                .getString("login", "")};
        final String[] par = {PreferenceManager.getDefaultSharedPreferences(this)
                .getString("password", "")};
        login.setText(log[0]);
        password.setText(par[0]);
        View saveLayout = findViewById(R.id.SaveLayout);
        EditText editText = findViewById(R.id.SaveNote);
        final String[] text = {PreferenceManager.getDefaultSharedPreferences(this)
                .getString("editText", "")};
        editText.setText(text[0]);
        saveLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                text[0] = String.valueOf(editText.getText());
                PreferenceManager.getDefaultSharedPreferences(CheckBoxState.this)
                        .edit().putString("editText", text[0]).commit();
            }
        });
    }
}
