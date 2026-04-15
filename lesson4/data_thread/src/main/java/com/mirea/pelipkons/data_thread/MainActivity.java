package com.mirea.pelipkons.data_thread;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.mirea.pelipkons.data_thread.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Runnable runn1 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("runn1: runOnUiThread — немедленное выполнение в UI-потоке из другого потока");
            }
        };

        final Runnable runn2 = new Runnable() {
            public void run() {
                binding.tvInfo.append("\nrunn2: post — помещает Runnable в очередь UI-потока для немедленного выполнения");
            }
        };

        final Runnable runn3 = new Runnable() {
            public void run() {
                binding.tvInfo.append("\nrunn3: postDelayed — выполнение с задержкой 2 секунды после runn2");
            }
        };

        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.tvInfo.postDelayed(runn3, 2000);
                    binding.tvInfo.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
