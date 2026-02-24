package com.mirea.pelipkons.buttonclicker;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button whoAmi;
    private Button itsNotMe;
    private TextView tvOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        whoAmi = findViewById(R.id.whoAmI);
        itsNotMe = findViewById(R.id.itsNotMe);
        tvOut = findViewById(R.id.tvOut);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText("Мой номер по списку 13");
            }
        };
        whoAmi.setOnClickListener(onClickListener);
    }

    public void itsNotMeCLick(View view) {
        tvOut.setText("Это не я сделал");
    }
}