package com.annakulczycka.message;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    private Button startButton;

    public final static String EXTRA_MESSAGE = "com.annakulczycka.message.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = (EditText)findViewById(R.id.nameEditText);
        startButton = (Button)findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameField.getText().toString();
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();

                startStory(name);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameField.setText("");
    }


    private void startStory(String name) {

        Intent intent = new Intent(this, secondActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.app_name);
        String message = nameField.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        intent.putExtra(key, name);
        startActivity(intent);
    }

    }
