package com.mirea.pelipkons.thread;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.mirea.pelipkons.thread.databinding.ActivityMainBinding;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Имя текущего потока: " + mainThread.getName());
        mainThread.setName("МОЙ НОМЕР ГРУППЫ: 51, НОМЕР ПО СПИСКУ: 13, МОЙ ЛЮБИИМЫЙ ФИЛЬМ: Шрек");
        infoTextView.append("\n Новое имя потока    : " + mainThread.getName());
        Log.d(MainActivity.class.getSimpleName(), "Stack: " + Arrays.toString(mainThread.getStackTrace()));

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        int result = 76 / 28;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.textView.setText("Среднее число пар: " + result);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}