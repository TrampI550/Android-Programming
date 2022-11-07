package com.example.lab6;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab6.R;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.jaredrummler.android.colorpicker.ColorShape;

public class MainActivity extends AppCompatActivity implements ColorPickerDialogListener {
    private LinearLayout rect_1;
    private LinearLayout rect_2;
    private LinearLayout rect_3;
    private TextView rect1;
    private TextView rect2;
    private TextView rect3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rect_1 = findViewById(R.id.Rectangle_1);
        rect_2 = findViewById(R.id.Rectangle_2);
        rect_3 = findViewById(R.id.Rectangle_3);
        rect1 = findViewById(R.id.Rectangle1);
        rect2 = findViewById(R.id.Rectangle2);
        rect3 = findViewById(R.id.Rectangle3);

        rect_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColorPickerDialog(view.getId());
            }
        });
        rect_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColorPickerDialog(view.getId());
            }
        });
        rect_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColorPickerDialog(view.getId());
            }
        });
        rect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColorPickerDialog(view.getId());
            }
        });
        rect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColorPickerDialog(view.getId());
            }
        });
        rect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColorPickerDialog(view.getId());
            }
        });

        Button bNext = findViewById(R.id.NextPage);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SquaresList.class);
                startActivity(intent);
            }
        });
    }

    private void createColorPickerDialog(int id) {
        ColorPickerDialog.newBuilder()
                .setColor(Color.YELLOW)
                .setDialogType(ColorPickerDialog.TYPE_PRESETS)
                .setAllowCustom(true)
                .setAllowPresets(false)
                .setColorShape(ColorShape.SQUARE)
                .setDialogId(id)
                .show(this);
    }

    private void setBackgroundColor(LinearLayout rect, int colour, TextView textViewka) {
        rect.setBackgroundColor(colour);
        if (colour == Color.BLACK) {
            textViewka.setText("Black");
        } else if (colour == Color.BLUE) {
            textViewka.setText("Blue");
        } else if (colour == Color.CYAN) {
            textViewka.setText("Cyan");
        } else if (colour == Color.GRAY) {
            textViewka.setText("Gray");
        } else if (colour == Color.GREEN) {
            textViewka.setText("Green");
        } else if (colour == Color.MAGENTA) {
            textViewka.setText("Magenta");
        } else if (colour == Color.RED) {
            textViewka.setText("Red");
        } else if (colour == Color.WHITE) {
            textViewka.setText("White");
        } else if (colour == Color.YELLOW) {
            textViewka.setText("Yellow");
        }
    }

    private void setTextColor(TextView rect, int colour) {
        rect.setTextColor(colour);
    }

    @Override
    public void onColorSelected(int dialogId, int colour) {
        switch (dialogId) {
            case R.id.Rectangle_1:
                setBackgroundColor(rect_1, colour, rect1);
                break;
            case R.id.Rectangle_2:
                setBackgroundColor(rect_2, colour, rect2);
                break;
            case R.id.Rectangle_3:
                setBackgroundColor(rect_3, colour, rect3);
                break;
            case R.id.Rectangle1:
                setTextColor(rect1, colour);
                break;
            case R.id.Rectangle2:
                setTextColor(rect2, colour);
                break;
            case R.id.Rectangle3:
                setTextColor(rect3, colour);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dialogId);
        }
    }

    @Override
    public void onDialogDismissed(int dialogId) {
        Toast.makeText(this, "Dialog dismissed", Toast.LENGTH_SHORT).show();
    }
}

