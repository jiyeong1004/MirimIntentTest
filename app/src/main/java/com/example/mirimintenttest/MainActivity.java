package com.example.mirimintenttest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    RadioButton btn_plus, rdo_minus, rdo_multi, rdo_divide;
    Button btn_result;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnResult = findViewById(R.id.btn_result);
        rg = findViewById(R.id.rg);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

        btnResult.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("input1", input1.getText().toString());
            intent.putExtra("input2", input2.getText().toString());

            String op = "";

            switch (rg.getCheckedRadioButtonId()){
                case R.id.rdo_plus:
                    op = "더하기";
                    break;
                case R.id.rdo_minus:
                    op = "빼기";
                    break;
                case R.id.rdo_multi:
                    op = "곱하기";
                    break;
                case R.id.rdo_divide:
                    op = "나누기";
                    break;
            }

            intent.putExtra("op", op);
            startActivity(intent);
        }
    };
}