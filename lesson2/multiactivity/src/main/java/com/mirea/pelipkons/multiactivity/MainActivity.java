package com.mirea.pelipkons.multiactivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClickNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void onClickSend(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editText = findViewById(R.id.editText);
        intent.putExtra("key", String.valueOf(editText.getText()));
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() - Activity 1");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState() - Activity 1");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.i(TAG, "onPostCreate() - Activity 1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() - Activity 1");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i(TAG, "onPostResume() - Activity 1");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, "onAttachedWindow() - Activity 1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() - Activity 1");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState() - Activity 1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() - Activity 1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() - Activity 1");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG, "onDetachedFromWindow() - Activity 1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart() - Activity 1");
    }
}