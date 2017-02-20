package fr.android.androidexercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Intent intent = getIntent();
        String res = intent.getStringExtra("yolo");
        boolean res2 = intent.getBooleanExtra("bool", false);
        Toast.makeText(BookActivity.this, res, Toast.LENGTH_SHORT).show();
        Toast.makeText(BookActivity.this, res2 ? "True" : "False", Toast.LENGTH_SHORT).show();
    }
}
