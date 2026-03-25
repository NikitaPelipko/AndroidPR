package com.mirea.pelipkons.dialog;

import android.os.Bundle;

import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.snackbar.Snackbar;

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

    public void onClickShowAlertDialog(View view) {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onShowSnackbarClick(View v) {
        Snackbar snackbar = Snackbar.make(v, "This is snackbar!", Snackbar.LENGTH_LONG);
        snackbar.setAction("Click", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }
    public void onShowDateDialogClick(View v) {
        DateDialogFragment fragment = new DateDialogFragment();
        fragment.show(getSupportFragmentManager(), "Date picker");
    }

    public void onShowTimeDialog(View v) {
        TimeDialogFragment fragment = new TimeDialogFragment();
        fragment.show(getSupportFragmentManager(), "Time picker");
    }

    public void onShowProgressDialog(View v) {
        ProgressDialogFragment fragment = new ProgressDialogFragment();
        fragment.show(getSupportFragmentManager(), "Progress");
    }
}