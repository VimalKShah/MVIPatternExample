package com.example.mvipatternexample;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainView {

    private Button mButton;
    private EditText mEditText;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mEditText = findViewById(R.id.editText);
        mButton = findViewById(R.id.button);

        new MainIntent(this).start();
    }

    @Override
    public Map<String, Observable> getActions() {
        Map<String, Observable> actions = new HashMap<>();
        actions.put("Button", RxView.clicks(mButton));
        actions.put("EditText", RxTextView.textChanges(mEditText));
        return actions;
    }

    @Override
    public Map<String, Consumer> getConsumers() {
        Map<String, Consumer> consumer = new HashMap<>();
        consumer.put("TextView", RxTextView.text(mTextView));
        consumer.put("EditText", RxTextView.text(mEditText));
        return consumer;
    }
}