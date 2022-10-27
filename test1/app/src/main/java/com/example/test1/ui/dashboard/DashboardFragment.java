//package com.example.test1.ui.dashboard;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.example.test1.R;
//
//import org.w3c.dom.Text;
//
//public class MainActivity extends AppCompatActivity {
//    int count = 0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    public void onClicked(View v) {
//        TextView txt = findViewById(R.id.text);
//        txt.setText(String.valueOf(++count));
//    }
//}