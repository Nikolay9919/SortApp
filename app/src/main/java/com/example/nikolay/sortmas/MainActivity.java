package com.example.nikolay.sortmas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = (TextView) findViewById(R.id.text);
        final EditText input = (EditText) findViewById(R.id.input);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void
                    onClick(View view) {
                        String s = input.getText().toString();
                        String[] split = s.split(";");
                        int[] arr = new int[split.length];
                        int t = 0;
                        for (String item : split) {
                            String trim = item.trim();
                            if(trim.isEmpty()){
                                continue;
                            }
                            arr[t++] = Integer.parseInt(trim);
                        }

                        for (int i = 0; i < arr.length; i++) {
                            int min = arr[i];
                            int min_i = i;
                            for (int j = i + 1; j < arr.length; j++) {
                                if (arr[j] < min) {
                                    min = arr[j];
                                    min_i = j;
                                }
                            }
                            if (i != min_i) {
                                int tmp = arr[i];
                                arr[i] = arr[min_i];
                                arr[min_i] = tmp;
                            }
                        }

                        String toRender = "";
                        for (int item : arr) {
                            toRender += item + "; ";
                        }
                        String substring = toRender.substring(0, toRender.length() - 2);
                        text.setText(substring);
                    }

                }
        );

    }

}
