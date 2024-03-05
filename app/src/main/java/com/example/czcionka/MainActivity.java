package com.example.czcionka;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView fontSizeTextView;
    private TextView quoteTextView;
    private SeekBar fontSizeSeekBar;
    private Button changeQuoteButton;

    private String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int currentQuoteIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fontSizeTextView = findViewById(R.id.fontSizeTextView);
        quoteTextView = findViewById(R.id.quoteTextView);
        fontSizeSeekBar = findViewById(R.id.fontSizeSeekBar);
        changeQuoteButton = findViewById(R.id.changeQuoteButton);

        fontSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fontSizeTextView.setText("Rozmiar: " + progress);
                quoteTextView.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        changeQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
                quoteTextView.setText(quotes[currentQuoteIndex]);
            }
        });
    }
}
