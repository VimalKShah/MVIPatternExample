package com.example.mvipatternexample;

import java.util.Map;

import io.reactivex.Observable;

public class MainIntent {

    private Map<String, Observable> mActions;
    private MainModel mMainModel;

    public MainIntent(MainView mainView) {
        mActions = mainView.getActions();
        this.mMainModel = new MainModel(mainView.getConsumers());
    }

    void start() {
        mActions.get("Button").subscribe(next -> mMainModel.resetText());
        mActions.get("EditText").subscribe(changeText -> mMainModel.changeText(changeText.toString()));
    }


}
