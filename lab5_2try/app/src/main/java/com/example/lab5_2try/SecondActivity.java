package com.example.lab5_2try;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity implements
        FirstFragment.onSomeEventListener, SecondFragment.onSomeEventListener {
    private Button next_btn2, prev_btn2;
    final String LOG_TAG = "tag";
    SecondFragment secondFragment;
    FirstFragment firstFragment;
    FragmentTransaction ft;
    FragmentManager myFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = myFragmentManager.beginTransaction();
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        ft.add(R.id.fragm, secondFragment);
        ft.replace(R.id.fragm, firstFragment);
        ft.commit();
    }
    public void someEvent(String a) {
        FragmentTransaction ft = myFragmentManager.beginTransaction();
        if (a == "next") {
            Intent intent_next = new Intent(SecondActivity.this, TextDialog.class);
            startActivity(intent_next);
        } else {
            if (a == "att") {
                if (secondFragment.isDetached()) {
                    Log.d(LOG_TAG, "ATT 2");
                    ft.attach(secondFragment);
                    ft.detach(firstFragment);
                } else {
                    Log.d(LOG_TAG, "ATT 1");
                    Toast.makeText(getApplicationContext(), "Page is attached",
                            Toast.LENGTH_SHORT).show();
                    secondFragment = new SecondFragment();
                    ft.add(R.id.fragm, secondFragment);
                    ft.detach(firstFragment);
                }
            } else if (a == "det") {
                Log.d(LOG_TAG, "DET 1");
                if (!(secondFragment.isRemoving())) {
                    Toast.makeText(getApplicationContext(), "Page is detached",
                            Toast.LENGTH_SHORT).show();
                    ft.remove(secondFragment);
                }
            } else if (a == "back") {
                Log.d(LOG_TAG, "BACK");
                ft.attach(firstFragment);
                ft.detach(secondFragment);
            }
            ft.commit();
        }
    }
}
