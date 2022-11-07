package com.example.lab6;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
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
        CheckBox checkBox = findViewById(R.id.checkBox);
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
