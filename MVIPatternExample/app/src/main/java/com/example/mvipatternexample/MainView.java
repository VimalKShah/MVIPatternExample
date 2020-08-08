package com.example.mvipatternexample;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public interface MainView {

    Map<String, Observable> getActions();

    Map<String, Consumer> getConsumers();

}
