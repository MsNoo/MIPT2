package com.example.mipt2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mipt2.calc.Calc;

public class MainActivity extends AppCompatActivity {

    private EditText etUserInput;
    private Spinner spSelectOption;
    private TextView tvOutput;
    private int selectedPos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etUserInput = findViewById(R.id.etUserInput);
        this.spSelectOption = findViewById(R.id.spSelectOption);
        this.tvOutput = findViewById(R.id.tvOutput);

        Spinner spinner = (Spinner) findViewById(R.id.spSelectOption);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.select_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedPos = position;
                Log.d("SelectedPosition", String.valueOf(selectedPos));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });
    }

    public void onBtnCalculateClick(View view) {
        String phrase = this.etUserInput.getText().toString();
        String result = "";
        if(!phrase.isEmpty()) {
            switch (selectedPos) {
                case 0:
                    int symbolCount = Calc.getSymbolsCount(phrase);
                    result = String.valueOf(symbolCount);
                    break;

                case 1:
                    int wordCount = Calc.getWordsCount(phrase);
                    result = String.valueOf(wordCount);
                    break;
            }
            this.tvOutput.setText(result);
        }
        else{
            Toast.makeText(getApplicationContext(), "Emptinessss", Toast.LENGTH_SHORT).show();
        }

    }
}