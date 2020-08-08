package com.example.mvipatternexample;

import java.util.Map;
import java.util.Objects;
import java.util.Observable;

import io.reactivex.functions.Consumer;

public class MainModel {

    private static final String DEFAULT_TEXT = "Default Text";
    private String mText;
    private Map<String, Consumer> mConsumers;

    public MainModel(Map<String, Consumer> consumers) {
        this.mConsumers = consumers;
        resetText();
    }

    void changeText(String text) {
        this.mText = text;
        try {
            Objects.requireNonNull(mConsumers.get("TextView")).accept(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void resetText() {
        this.mText = DEFAULT_TEXT;
        try {
            Objects.requireNonNull(mConsumers.get("EditText")).accept(mText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
