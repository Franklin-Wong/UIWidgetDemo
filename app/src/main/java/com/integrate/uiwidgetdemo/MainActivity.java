package com.integrate.uiwidgetdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ShortcutBottomSheet bottomSheet;

    private String stringTest = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView showBottom = findViewById(R.id.show);
        showBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Todo
                showBottomSheet();
                stringTest = "123";
            }
        });
    }

    private void showBottomSheet() {
        bottomSheet = new ShortcutBottomSheet();
        bottomSheet.show(getSupportFragmentManager(), "bottomSheetFragment");
        bottomSheet.setCancelable(false);

    }

    public void hideBottomSheet(View view) {
        if (bottomSheet != null) {
            bottomSheet.dismiss();
        }
    }
}