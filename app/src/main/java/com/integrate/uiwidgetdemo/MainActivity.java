package com.integrate.uiwidgetdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ShortcutBottomSheet bottomSheet;

    private String stringTest = " ";
<<<<<<< HEAD
    private String stringDev = " ";

=======
>>>>>>> 5ec00b5f93e1068117b341ee23353f3590ddf2a9

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

<<<<<<< HEAD

                stringTest = "Master0000";
                stringDev = "Dev1111";

=======
                stringTest = "Dev1111";
>>>>>>> 5ec00b5f93e1068117b341ee23353f3590ddf2a9

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