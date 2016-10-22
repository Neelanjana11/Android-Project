package com.neelanjana.benchmarkalgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Benchmark_activity extends AppCompatActivity{

    private EditText textSize;
    private TextView textDisplay;
    private TextView textBubble;
    private TextView textSelection;
    private TextView textInsertion;
    private TextView textQuick;
    private TextView textRadix;
    private TextView textMerge;
    private TextView textHeap;
    private RadioGroup rgGroup;
    private RadioButton selectedRadio;
    private RadioButton btnAvg1;
    private Button btnB;
    private Button btnS;
    private Button btnI;
    private Button btnQ;
    private Button btnR;
    private Button btnM;
    private Button btnH;
    private Button btnA;
    private Button btnRe;
    private static int[] array;
    private GridLayout grid;
    private Button btnBenchmark;

    public void generateArray(View view){
        try {
            int arraySize = Integer.parseInt(textSize.getText().toString());

            array = new int[arraySize];

            rgGroup = (RadioGroup) findViewById(R.id.rgGroup1);
            int selectedId = rgGroup.getCheckedRadioButtonId();

            selectedRadio = (RadioButton) findViewById(selectedId);
            textDisplay.setText("Array of size "+arraySize+" generated for "+ selectedRadio.getText());

            switch(selectedId) {
                case R.id.btnBest:
                    array = Calculator.generateNaturalNumbers(arraySize);
                    break;

                case R.id.btnAvg:
                    array = Calculator.generateRandomNumbers(arraySize);
                    break;

                case R.id.btnWorst:
                    array = Calculator.generateReverseNaturalNumbers(arraySize);
                    break;
            }
            grid.setVisibility(View.VISIBLE);
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Enter valid number :", Toast.LENGTH_SHORT).show();
        }
    }

        public void sort(View view) {
            int time, time1, time2, time3, time4, time5, time6;
            switch (view.getId()) {

                case R.id.btnBubble:
                    btnS.setEnabled(false);
                    btnI.setEnabled(false);
                    btnQ.setEnabled(false);
                    btnM.setEnabled(false);
                    btnH.setEnabled(false);
                    btnR.setEnabled(false);

                    time = Sort.bubbleSort(array);
                    textBubble.setText(Integer.toString(time));
                    break;

                case R.id.btnSelection:
                    btnB.setEnabled(false);
                    btnI.setEnabled(false);
                    btnQ.setEnabled(false);
                    btnM.setEnabled(false);
                    btnR.setEnabled(false);
                    btnH.setEnabled(false);

                    time = Sort.selectionSort(array);
                    textSelection.setText(Integer.toString(time));
                    break;

                case R.id.btnInsertion:
                    btnB.setEnabled(false);
                    btnS.setEnabled(false);
                    btnQ.setEnabled(false);
                    btnM.setEnabled(false);
                    btnR.setEnabled(false);
                    btnH.setEnabled(false);

                    time = Sort.insertionSort(array);
                    textInsertion.setText(Integer.toString(time));
                    break;

                case R.id.btnQuick:
                    btnB.setEnabled(false);
                    btnI.setEnabled(false);
                    btnS.setEnabled(false);
                    btnM.setEnabled(false);
                    btnR.setEnabled(false);
                    btnH.setEnabled(false);

                    time = Sort.bubbleSort(array);
                    textQuick.setText(Integer.toString(time));
                    break;

                case R.id.btnMerge:
                    btnB.setEnabled(false);
                    btnI.setEnabled(false);
                    btnS.setEnabled(false);
                    btnQ.setEnabled(false);
                    btnR.setEnabled(false);
                    btnH.setEnabled(false);

                    time = Sort.insertionSort(array);
                    textMerge.setText(Integer.toString(time));
                    break;

                case R.id.btnHeap:
                    btnB.setEnabled(false);
                    btnI.setEnabled(false);
                    btnS.setEnabled(false);
                    btnQ.setEnabled(false);
                    btnM.setEnabled(false);
                    btnR.setEnabled(false);

                    time = Sort.selectionSort(array);
                    textHeap.setText(Integer.toString(time));
                    break;

                case R.id.btnRadix:
                    btnB.setEnabled(false);
                    btnI.setEnabled(false);
                    btnS.setEnabled(false);
                    btnQ.setEnabled(false);
                    btnM.setEnabled(false);
                    btnH.setEnabled(false);

                    time = Sort.insertionSort(array);
                    textRadix.setText(Integer.toString(time));
                    break;

                case R.id.btnBenchmark:
                    btnS.setEnabled(false);
                    btnI.setEnabled(false);
                    btnB.setEnabled(false);
                    btnQ.setEnabled(false);
                    btnM.setEnabled(false);
                    btnR.setEnabled(false);
                    btnH.setEnabled(false);

                    time = Sort.bubbleSort(array);
                    textBubble.setText(Integer.toString(time));

                    time = Sort.selectionSort(array);
                    textSelection.setText(Integer.toString(time));

                    time = Sort.insertionSort(array);
                    textInsertion.setText(Integer.toString(time));

                    time = Sort.bubbleSort(array);
                    textQuick.setText(Integer.toString(time));

                    time = Sort.insertionSort(array);
                    textMerge.setText(Integer.toString(time));

                    time = Sort.selectionSort(array);
                    textHeap.setText(Integer.toString(time));

                    time = Sort.insertionSort(array);
                    textRadix.setText(Integer.toString(time));
                    break;

                case R.id.btnReset:
                    textDisplay.setText("");
                    textSize.setText("");
                    textRadix.setText("");
                    textMerge.setText("");
                    textInsertion.setText("");
                    textSelection.setText("");
                    textBubble.setText("");
                    textHeap.setText("");
                    textQuick.setText("");
                    grid.setVisibility(View.GONE);
                    btnS.setEnabled(true);
                    btnB.setEnabled(true);
                    btnQ.setEnabled(true);
                    btnM.setEnabled(true);
                    btnR.setEnabled(true);
                    btnH.setEnabled(true);
                    btnI.setEnabled(true);
                    btnAvg1.setChecked(true);
            }
        }
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.benchmark_activity_layout);
                textSize = (EditText) findViewById(R.id.textSize);
                textDisplay = (TextView) findViewById(R.id.textDisplay);
                textBubble = (TextView) findViewById(R.id.textBubble);
                textSelection = (TextView) findViewById(R.id.textSelection);
                textInsertion = (TextView) findViewById(R.id.textInsertion);
                textQuick = (TextView) findViewById(R.id.textQuick);
                textMerge = (TextView) findViewById(R.id.textMerge);
                textHeap = (TextView) findViewById(R.id.textHeap);
                textRadix = (TextView) findViewById(R.id.textRadix);
                btnB = (Button) findViewById(R.id.btnBubble);
                btnS = (Button) findViewById(R.id.btnSelection);
                btnI = (Button) findViewById(R.id.btnInsertion);
                btnQ = (Button) findViewById(R.id.btnQuick);
                btnM = (Button) findViewById(R.id.btnMerge);
                btnH = (Button) findViewById(R.id.btnHeap);
                btnR = (Button) findViewById(R.id.btnRadix);
                btnA = (Button) findViewById(R.id.btnBenchmark);
                btnRe = (Button) findViewById(R.id.btnReset);
                btnAvg1 = (RadioButton) findViewById(R.id.btnAvg);
                grid = (GridLayout) findViewById(R.id.grid);
                grid.setVisibility(View.GONE);

            }

        }

